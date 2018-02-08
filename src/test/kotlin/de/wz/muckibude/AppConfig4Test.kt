package de.wz.muckibude

class AppConfig4Test : AppConfig {
    override fun applicationInitializer(): ApplicationInitializer {
        return ApplicationInitializer4Test()
    }
}

class ApplicationInitializer4Test : ApplicationInitializer {
    override fun initDatabase() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initAppServer() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}