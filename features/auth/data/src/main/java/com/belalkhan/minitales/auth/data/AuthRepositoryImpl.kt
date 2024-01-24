package com.belalkhan.minitales.auth.data

import com.belalkhan.minitales.network.NetworkResult
import com.belalkhan.minitales.network.RequestHandler
import com.belalkhan.minitales.network.Response
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val requestHandler: RequestHandler) : AuthRepository {
    override suspend fun login(request: UserLoginRequest): NetworkResult<Response<UserApiModel>> {
       return requestHandler.post(
            urlPathSegment = listOf("auth","login"),
            body = request
        )
    }
}