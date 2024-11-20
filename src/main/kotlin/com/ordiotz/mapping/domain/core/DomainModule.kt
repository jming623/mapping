package com.ordiotz.mapping.domain.core

import com.ordiotz.mapping.domain.service.UserService
import org.koin.dsl.module

val DomainModule = module {
    single { UserService(get()) }
}