package de.wz.muckibude

import org.flywaydb.core.Flyway
import org.jetbrains.exposed.sql.Database
import javax.sql.DataSource

class ApplicationInitializer(private val dataSource: DataSource)  {
    fun initDatabase() {
        val flyway = Flyway();

        flyway.dataSource = dataSource;
        flyway.clean()
        flyway.migrate()
        Database.connect(dataSource)

    }

}
