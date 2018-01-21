package de.wz.muckibude

import org.jetbrains.exposed.sql.Database
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import javax.sql.DataSource

class ApplicationInitializer(val dataSource: DataSource) : ApplicationListener<ApplicationReadyEvent> {
    override fun onApplicationEvent(event: ApplicationReadyEvent?) {
        Database.connect(dataSource)

    }

}
