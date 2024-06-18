package br.com.mailwave.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "folder")
data class Folder(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String = ""
)