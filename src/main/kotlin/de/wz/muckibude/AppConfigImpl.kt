package de.wz.muckibude

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import de.wz.muckibude.AppConfigImpl.Env.dbUrl
import de.wz.muckibude.AppConfigImpl.Env.serverPort
import de.wz.muckibude.exercises.ExerciseController
import de.wz.muckibude.exercises.ExerciseRepo
import de.wz.muckibude.exercises.ExerciseService
import javax.sql.DataSource


class AppConfigImpl  {
    companion object : AppConfig {
        override fun applicationInitializer() : ApplicationInitializer = ApplicationInitializerImpl(dataSource(), serverPort());

        private fun dataSource(): DataSource {
            val dbUrl = dbUrl()
            val config = HikariConfig()
            config.jdbcUrl = dbUrl
            config.minimumIdle = 3
            config.maximumPoolSize = 10
            return HikariDataSource(config)
        }
    }

    object Infrastructure {
        private fun exerciseRepo() = ExerciseRepo()
        fun exerciseService() = ExerciseService(exerciseRepo())
    }

    object Api {
        fun exerciseController() = ExerciseController(AppConfigImpl.Infrastructure.exerciseService())

    }

    object Env {
        fun serverPort() : Int = System.getenv("PORT").toInt()
        fun dbUrl() : String = System.getenv("JDBC_DATABASE_URL")
    }


}