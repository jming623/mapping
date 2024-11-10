package com.ordiotz.mapping.app.plugins

import io.ktor.server.application.*
import org.koin.core.Koin
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.configureFrameworks() {
    install(Koin) {
        slf4jLogger()
        modules(module {
        })
    }
}
