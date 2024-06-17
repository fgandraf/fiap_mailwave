package br.com.mailwave.models

data class Email(
    val senderImage: Int,
    val sender: String,
    val body: String,
    val read: Boolean
)