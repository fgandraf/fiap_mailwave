package br.com.mailwave.integration

import retrofit2.Call
import retrofit2.http.GET

interface MessageApi {

    @GET("/api/received/messages/unread/1")
    fun getMessages(): List<Message>

}