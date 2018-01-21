package de.wz.muckibude

import de.wz.muckibude.exercises.FindExerciseUseCase
import de.wz.muckibude.exercises.ExerciseRepo
import org.jetbrains.exposed.sql.Database
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Primary



@Configuration
class AppConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    fun dataSource(): DataSource {
        var dataSource = DataSourceBuilder.create().
                build()
        return dataSource
    }

    @Bean
    fun applicationInitializer()  = ApplicationInitializer(dataSource());



    @Bean
    fun exerciseRepo()  = ExerciseRepo()

    @Bean
    fun findExerciseUseCase() = FindExerciseUseCase(exerciseRepo())

}