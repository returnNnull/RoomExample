package com.bam.roomexample.room

import androidx.lifecycle.LiveData
import androidx.room.RoomDatabase

class UserRepository( var  dataBase: DbConnection) {

    var users: LiveData<List<User>> = dataBase.userDao().getAll()

    fun getAll(): LiveData<List<User>>{
        return users
    }

    suspend fun insert(user: User){
        dataBase.userDao().insert(user)
    }

    suspend fun delete(user: User){
        dataBase.userDao().delete(user)
    }



}