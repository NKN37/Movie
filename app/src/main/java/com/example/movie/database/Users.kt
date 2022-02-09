package com.example.movie.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class Users(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,

    @ColumnInfo(name = "user_email")
    var email: String,

    @ColumnInfo(name = "user_password")
    var password: Long = 0L
)