package com.ordiotz.mapping.app

import com.ordiotz.mapping.app.plugins.configureRouting
import com.ordiotz.mapping.app.plugins.configureSerialization
import com.ordiotz.mapping.app.plugins.*
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureFrameworks()
    configureSerialization()
    configureRouting()
    configureDatabases()
}
