package com.ordiotz.mapping.app.plugins

import com.ordiotz.mapping.data.local.repo.UserRepo
import com.ordiotz.mapping.domain.repo.IUserRepo
import com.ordiotz.mapping.domain.service.UserService
import io.ktor.server.application.*
import org.koin.core.Koin
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger
import org.koin.core.module.dsl.bind

fun Application.configureFrameworks() {
    install(Koin) {
        slf4jLogger()
        modules(
            module {
                singleOf(::UserRepo) { bind<IUserRepo>() }
                singleOf(::UserService)
            }
        )
    }
}
