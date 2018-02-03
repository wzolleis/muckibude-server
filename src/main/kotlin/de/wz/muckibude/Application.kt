package de.wz.muckibude

import io.javalin.Javalin
fun main(args: Array<String>) {
    AppConfig.applicationInitializer().initDatabase()

    val port = System.getenv("PORT").toInt()
    val app = Javalin.start(port)
    app.get("/") { ctx -> ctx.result("Hello World") }
}
