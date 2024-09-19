package br.com.mailwave.integration

import br.com.mailwave.integration.dto.Message
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface MessageApi {

    @GET("/api/received/messages/unread/{userId}")
    fun getUnreadMessages(@Path("userId") userId: Long, @Header("Authorization") token: String): Response<List<Message>>

}