package com.ordiotz.mapping.app.plugins

import io.ktor.server.application.*
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database

fun Application.configureDatabases() {
    val driverClass = "org.mariadb.jdbc.Driver"
    val url = "jdbc:mariadb://43.203.127.146:3306"
    val user = "ordiotz"
    val password = "ordiotz123"
    val databaseName = "test"
    val host = "${url}/${databaseName}?user=${user}&password=${password}"

    val db = Database.connect(provideDataSource(host, driverClass))
}
private fun provideDataSource(url: String, driverClass: String) = HikariDataSource(
    HikariConfig().apply {
        driverClassName = driverClass
        jdbcUrl = url
        maximumPoolSize = 3
        isAutoCommit = false
        transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        validate()
    }
)