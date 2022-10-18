package tws.trackingcore.rule

import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.springframework.core.io.ClassPathResource
import org.springframework.jdbc.datasource.init.ScriptUtils
import org.springframework.test.context.junit.jupiter.SpringExtension
import javax.sql.DataSource


class BeforeClassBDRule : BeforeAllCallback {
    override fun beforeAll(context: ExtensionContext) {
        val dataSource = SpringExtension.getApplicationContext(context).getBean(DataSource::class.java)
        dataSource.connection.use { conn ->
            println("Applying test.sql")
            ScriptUtils.executeSqlScript(conn, ClassPathResource("/test.sql"))
        }
    }
}