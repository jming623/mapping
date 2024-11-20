package com.ordiotz.mapping.domain.util

interface BaseRepo<T> {
    suspend fun getAll(): List<T>
    suspend fun getById(id: Long): T?

    suspend fun insert(t: T)
    suspend fun update(t: T): Boolean
    suspend fun delete(t: T): Boolean
}