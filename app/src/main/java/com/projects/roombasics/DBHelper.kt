package com.projects.roombasics

import android.content.Context
import androidx.room.Room

object DBHelper {
    fun getInstance(context: Context): ContactDAO{
        return Room.databaseBuilder(context,ContactDatabase::class.java,"contactDB").build().contactDAO()
    }
}