package com.ordiotz.mapping.data.local.repo

import com.ordiotz.mapping.app.plugins.dbQuery
import com.ordiotz.mapping.data.local.model.UserLocal
import com.ordiotz.mapping.data.local.model.UserLocalT
import com.ordiotz.mapping.domain.model.User
import com.ordiotz.mapping.domain.model.UserMapper.toDomain
import com.ordiotz.mapping.domain.repo.IUserRepo
import org.jetbrains.exposed.sql.selectAll

class UserRepo: IUserRepo {
    override suspend fun getAll(): List<User> = dbQuery {
        val queryResult = UserLocalT.selectAll()
        if (queryResult.empty()) {
            listOf()
        }else{
            queryResult.map {resultRow ->
                UserLocal.fromResultRow(resultRow).toDomain()
            }
        }
    }
    override suspend fun getById(id: Long): User? {
        TODO("Not yet implemented")
    }
    override suspend fun insert(t: User) {
        TODO("Not yet implemented")
    }
    override suspend fun update(t: User): Boolean {
        TODO("Not yet implemented")
    }
    override suspend fun delete(t: User): Boolean {
        TODO("Not yet implemented")
    }
}