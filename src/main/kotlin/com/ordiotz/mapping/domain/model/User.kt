package com.ordiotz.mapping.domain.model

import com.ordiotz.mapping.data.local.model.UserLocal
import com.ordiotz.mapping.domain.util.BaseMapper
import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Long = 0L,
    val name: String,
    val gender: String
)

object UserMapper: BaseMapper<User, UserLocal> {
    override fun User.toData(): UserLocal = UserLocal(
        id =id,
        name=name,
        gender=gender
    )
    override fun UserLocal.toDomain(): User = User(
        id =id,
        name=name,
        gender=gender
    )
}