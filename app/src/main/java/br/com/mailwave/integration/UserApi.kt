package br.com.mailwave.integration

import br.com.mailwave.integration.dto.UserLoginRequest
import br.com.mailwave.integration.dto.UserLoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {

    @POST("/api/users/login")
    fun login(@Body userLoginRequest: UserLoginRequest): Response<UserLoginResponse>

}