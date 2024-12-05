package com.demo.xx.model.bean

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TestItem(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "item_num") val itemNum: String,
    @ColumnInfo(name = "item_short_name") val itemShortName: String,
    @ColumnInfo(name = "item_name_cn") val itemNameCN: String,
)
