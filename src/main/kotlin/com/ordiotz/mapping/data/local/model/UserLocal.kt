package com.ordiotz.mapping.data.local.model

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table

@Serializable
data class UserLocal(
    val id: Long,
    val name: String,
    val gender: String,
) {
    companion object {
        fun fromResultRow(resultRow: ResultRow): UserLocal {
            return UserLocal(
                id = resultRow[UserLocalT.id],
                name = resultRow[UserLocalT.name],
                gender = resultRow[UserLocalT.gender]
            )
        }
    }
}

object UserLocalT: Table() {
    val id = long("id").autoIncrement()
    val name = varchar("name", 255)
    val gender = varchar("gender", 255)

    override val primaryKey: PrimaryKey
        get() = PrimaryKey(id)
}