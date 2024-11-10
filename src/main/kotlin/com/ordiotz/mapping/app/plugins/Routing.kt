package com.ordiotz.mapping.app.plugins

import io.ktor.http.ContentType
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    install(StatusPages) {
        exception<IllegalStateException> { call, cause ->
            call.respondText("App in illegal state as ${cause.message}")
        }
    }
    routing {
        get("/") {
            call.respondText("Hello World!", ContentType.Text.Html)
        }
        get("/error-test") {
            throw IllegalStateException("Too Busy")
        }
    }
}
