package br.com.mailwave.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.mailwave.db.dao.AllDAO
import br.com.mailwave.models.Email
import br.com.mailwave.models.Folder

@Database(entities = [Email::class, Folder::class], version = 1)
abstract class AppDB: RoomDatabase() {

    abstract fun allDAO(): AllDAO

    companion object{

        private lateinit var instance: AppDB

        fun getDatabase(context: Context): AppDB{
            if(!::instance.isInitialized){
                instance = Room.databaseBuilder(
                    context,
                    AppDB::class.java,
                    "mailwave_db"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }


    }

}