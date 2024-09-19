package br.com.mailwave.integration.dto

import java.time.LocalDateTime

data class Message(
    val id: Long,
    val sender: String,
    val subject: String,
    val isRead: Boolean,
    val receivedAt: LocalDateTime,
    val accountId: Long,
    val folder: String,
    val tag: String,
    val body: String
)
