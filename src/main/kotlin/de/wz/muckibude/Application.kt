package de.wz.muckibude

fun main(args: Array<String>) {
    val initializer = AppConfig.applicationInitializer()
    initializer.initDatabase()
    initializer.initAppServer()
}
