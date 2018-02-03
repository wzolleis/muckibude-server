package de.wz.muckibude

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import de.wz.muckibude.exercises.ExerciseRepo
import de.wz.muckibude.exercises.FindExerciseUseCase
import javax.sql.DataSource


class AppConfig {
    companion object {
        fun dataSource(): DataSource {
            val dbUrl = System.getenv("JDBC_DATABASE_URL")
            val username = System.getenv("JDBC_DATABASE_USERNAME")
            val password = System.getenv("JDBC_DATABASE_PASSWORD")

            val config = HikariConfig()
            config.jdbcUrl = dbUrl
            config.minimumIdle = 3
            config.maximumPoolSize = 10
            config.username = username
            config.password = password

            return HikariDataSource(config)

        }

        fun applicationInitializer() = ApplicationInitializer(dataSource());

        fun exerciseRepo() = ExerciseRepo()

        fun findExerciseUseCase() = FindExerciseUseCase(exerciseRepo())
    }


}