package de.wz.muckibude

import io.javalin.ApiBuilder.get
import io.javalin.ApiBuilder.path
import io.javalin.Javalin
import org.flywaydb.core.Flyway
import org.jetbrains.exposed.sql.Database
import javax.sql.DataSource

class ApplicationInitializer(private val dataSource: DataSource, private val serverPort : Int)  {
    fun initDatabase() {
        val flyway = Flyway()
        flyway.dataSource = dataSource
        flyway.migrate()
        Database.connect(dataSource)

    }

    fun initAppServer() {
        val app = Javalin.create().apply {
            //enableStaticFiles("/public")
            enableStandardRequestLogging()
            port(serverPort)
        }.start()

        app.routes {
            path("api/exercises") {
                val exerciseController = AppConfig.Api.exerciseController()
                get(exerciseController::findAll)
            }
        }

    }

}
