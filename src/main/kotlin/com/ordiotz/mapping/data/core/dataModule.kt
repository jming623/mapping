package com.ordiotz.mapping.data.core

import com.ordiotz.mapping.data.local.repo.UserRepo
import com.ordiotz.mapping.domain.repo.IUserRepo
import org.koin.dsl.module

val dataModule = module {
    single<IUserRepo> { UserRepo() }
}