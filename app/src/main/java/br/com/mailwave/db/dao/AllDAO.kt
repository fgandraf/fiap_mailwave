package br.com.mailwave.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.mailwave.models.Email
import br.com.mailwave.models.Folder
import kotlinx.coroutines.flow.Flow

@Dao
interface AllDAO {

    @Insert
    fun insert(email: Email): Long

    @Update
    fun update(email: Email): Int

    @Delete
    fun delete(email: Email): Int

    @Query("SELECT * FROM email WHERE id = :id")
    fun getEmailById(id: Long): Email

    @Query("SELECT * FROM email")
    fun getAllEmails(): List<Email>

    @Insert
    fun insert(folder: Folder): Long

    @Update
    fun update(folder: Folder): Int

    @Delete
    fun delete(folder: Folder): Int

    @Query("SELECT * FROM folder WHERE id = :id")
    fun getFolderById(id: Long): Folder

    @Query("SELECT * FROM folder ORDER BY name ASC")
    fun getAllFolders(): List<Folder>



}