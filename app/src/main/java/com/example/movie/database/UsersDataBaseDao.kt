package com.example.movie.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UsersDataBaseDao {
    @Insert
    fun insert(user: Users?)

    @Update
    fun update(user: Users?)

    @Query("SELECT * from user_table WHERE user_email = :email")
    fun get(email: String): Users?
}