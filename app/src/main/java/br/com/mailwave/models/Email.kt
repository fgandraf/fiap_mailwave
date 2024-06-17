package br.com.mailwave.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "email")
data class Email(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val senderImage: Int = 0,
    val sender: String = "",
    val body: String = "",
    val folder: String = "",
    val tag: String = "",
    val read: Boolean = false,
)