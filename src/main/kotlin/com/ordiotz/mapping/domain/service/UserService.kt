package com.ordiotz.mapping.domain.service

import com.ordiotz.mapping.data.local.model.UserLocal
import com.ordiotz.mapping.data.local.repo.UserRepo
import com.ordiotz.mapping.domain.exception.AppException
import com.ordiotz.mapping.domain.model.User
import com.ordiotz.mapping.domain.repo.IUserRepo

class UserService(
    private val userRepo: IUserRepo
)
{
    suspend fun getAllUsers(): Result<List<User>> {
        try {
            val result = userRepo.getAll()
            return Result.success(result)
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }
}