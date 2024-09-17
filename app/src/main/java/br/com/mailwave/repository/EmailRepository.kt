package br.com.mailwave.repository

import android.content.Context
import br.com.mailwave.db.AppDB
import br.com.mailwave.db.dao.AllDAO
import br.com.mailwave.models.Email
import br.com.mailwave.models.Folder

class AppRepository(context: Context) {

    private val db: AllDAO = AppDB.getDatabase(context).allDAO()

    fun insertEmail(email: Email): Long{
        return db.insert(email)
    }

    fun updateEmail(email: Email): Int{
        return db.update(email)
    }

    fun deleteEmail(email: Email): Int{
        return db.delete(email)
    }

    fun getEmailById(id: Long): Email {
        return db.getEmailById(id)
    }

    fun getAllEmails(): List<Email>{
        return db.getAllEmails()
    }

    fun insertFolder(folder: Folder): Long{
        return db.insert(folder)
    }

    fun updateFolder(folder: Folder): Int{
        return db.update(folder)
    }

    fun deleteFolder(folder: Folder): Int{
        return db.delete(folder)
    }

    fun getFolderById(id: Long): Folder {
        return db.getFolderById(id)
    }

    fun getAllFolders(): List<Folder>{
        return db.getAllFolders()
    }

}