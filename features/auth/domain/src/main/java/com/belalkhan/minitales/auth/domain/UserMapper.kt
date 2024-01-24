package com.belalkhan.minitales.auth.domain

import com.belalkhan.minitales.auth.data.UserApiModel
import javax.inject.Inject

class UserMapper @Inject constructor() : Mapper<UserApiModel, User> {
    override fun map(from: UserApiModel): User {
        return User(
            authToken = from.authToken,
            avatar = from.avatar,
            createdAt = from.createdAt,
            email = from.email,
            fullName = from.fullName,
            id = from.id
        )
    }
}