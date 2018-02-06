package de.wz.muckibude

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import de.wz.muckibude.AppConfig.Env.dbUrl
import de.wz.muckibude.AppConfig.Env.serverPort
import de.wz.muckibude.exercises.ExerciseController
import de.wz.muckibude.exercises.ExerciseRepo
import de.wz.muckibude.exercises.ExerciseService
import javax.sql.DataSource


class AppConfig {
    companion object {
        fun applicationInitializer() = ApplicationInitializer(dataSource(), serverPort());

        fun dataSource(): DataSource {
            val dbUrl = dbUrl()
            val config = HikariConfig()
            config.jdbcUrl = dbUrl
            config.minimumIdle = 3
            config.maximumPoolSize = 10

            return HikariDataSource(config)
        }


        fun exerciseRepo() = ExerciseRepo()

        fun exerciseService() = ExerciseService(exerciseRepo())
    }

    object Api {
        fun exerciseController() = ExerciseController(AppConfig.exerciseService())

    }

    object Env {
        fun serverPort() : Int = System.getenv("PORT").toInt()
        fun dbUrl() : String = System.getenv("JDBC_DATABASE_URL")
    }


}