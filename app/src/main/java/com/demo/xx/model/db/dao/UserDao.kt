package com.demo.xx.model.db.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.demo.xx.model.bean.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Insert
    fun insert(vararg users: User)

    @Query("SELECT * FROM user ORDER BY uid ASC")
    fun getUserPaged(): PagingSource<Int, User>

}