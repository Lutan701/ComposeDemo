package com.demo.xx.model.db.upgrade

import android.util.Log
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(db: SupportSQLiteDatabase) {
        Log.d("DbUpgrade", "Upgrade1_2")
    }
}