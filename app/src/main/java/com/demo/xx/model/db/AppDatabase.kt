package com.demo.xx.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.demo.xx.model.bean.TestItem
import com.demo.xx.model.bean.User
import com.demo.xx.model.db.dao.UserDao

@Database(entities = [User::class, TestItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

}