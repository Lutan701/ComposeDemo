package com.demo.xx.model.db

import androidx.room.Room
import com.demo.xx.App
import com.demo.xx.model.db.upgrade.MIGRATION_1_2

object DbProvider {

    private lateinit var _db: AppDatabase

    val db: AppDatabase
        get() = _db

    fun init() {
        _db = Room
            .databaseBuilder(App.instance, AppDatabase::class.java, "boh_xx.db")
            .addMigrations(MIGRATION_1_2)
            .build()
    }

}