package com.example.movie.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Users::class], version = 1, exportSchema = false)
 abstract class UsersDataBase: RoomDatabase() {

    abstract fun usersDataBaseDao() : UsersDataBaseDao

    companion object {

        @Volatile
        private var INSTANCE: UsersDataBase? = null

        fun getInstance(context: Context): UsersDataBase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                    UsersDataBase::class.java,
                        "users_base"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
