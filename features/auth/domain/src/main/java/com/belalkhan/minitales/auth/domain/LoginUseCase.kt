package com.belalkhan.minitales.auth.domain

import com.belalkhan.minitales.auth.data.AuthRepository
import com.belalkhan.minitales.auth.data.UserLoginRequest
import com.belalkhan.minitales.network.NetworkException
import com.belalkhan.minitales.network.NetworkResult
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository,
    private val mapper: UserMapper
) {

    suspend fun invoke(email: String, password: String): Resource<User> {
        val request = UserLoginRequest(email, password)
        return when (val result = authRepository.login(request)) {
            is NetworkResult.Error -> {
                result.toResourceError()
            }

            is NetworkResult.Success -> {
                Resource.Success(mapper.map(result.result.data))
            }

        
        }

    }
}

fun NetworkResult.Error<*>.toResourceError(): Resource.Error {
    return when (exception) {
        is NetworkException.NotFoundException -> Resource.Error(ResourceError.SERVICE_UNAVAILABLE)
        is NetworkException.UnKnownException -> Resource.Error(ResourceError.UNKNOWN)
        else -> Resource.Error(ResourceError.UNAUTHORIZED)
    }
}