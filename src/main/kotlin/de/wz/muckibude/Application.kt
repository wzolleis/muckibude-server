package de.wz.muckibude

fun main(args: Array<String>) {
    val initializer = AppConfigImpl.applicationInitializer()
    initializer.initDatabase()
    initializer.initAppServer()
}
