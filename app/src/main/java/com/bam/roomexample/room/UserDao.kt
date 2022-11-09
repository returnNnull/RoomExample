package com.bam.roomexample.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query


@Dao
interface UserDao {

    @Query("select * from User")
    fun getAll(): LiveData<List<User>>

    @Insert(onConflict = REPLACE)
    suspend fun insert(user: User)

    @Delete
    suspend fun delete(user: User)
}