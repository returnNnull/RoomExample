package com.bam.roomexample.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1, exportSchema = true)
abstract class DbConnection : RoomDatabase() {
    abstract fun userDao(): UserDao
}