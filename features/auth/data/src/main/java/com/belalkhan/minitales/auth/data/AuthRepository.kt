package com.belalkhan.minitales.auth.data

import com.belalkhan.minitales.network.NetworkResult
import com.belalkhan.minitales.network.Response

interface AuthRepository {
    suspend fun login(request: UserLoginRequest): NetworkResult<Response<UserApiModel>>
}