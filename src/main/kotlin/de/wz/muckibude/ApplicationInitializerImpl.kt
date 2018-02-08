package de.wz.muckibude

import de.wz.muckibude.exercises.Exercise
import io.javalin.ApiBuilder.*
import io.javalin.Javalin
import org.flywaydb.core.Flyway
import org.jetbrains.exposed.sql.Database
import javax.sql.DataSource

class ApplicationInitializerImpl(private val dataSource: DataSource, private val serverPort : Int)  : ApplicationInitializer {
    override fun initDatabase() {
        val flyway = Flyway()
        flyway.dataSource = dataSource
        flyway.migrate()
        Database.connect(dataSource)

    }

    override fun initAppServer() {
        val app = Javalin.create().apply {
            //enableStaticFiles("/public")
            enableStandardRequestLogging()

            port(serverPort)
        }.start()

        val exerciseController = AppConfigImpl.Api.exerciseController()

        app.routes {
            path("api/exercises") {
                get(exerciseController::findAll)
                post { ctx ->
                    val body = ctx.body()
                    val exercise = ctx.bodyAsClass(Exercise::class.java)
                    exerciseController.insert(exercise)
                    ctx.status(201)
                }
            }
        }

    }

}

interface ApplicationInitializer {
    fun initDatabase()
    fun initAppServer()
}
