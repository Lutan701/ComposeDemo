package com.demo.xx.model

import androidx.paging.PagingSource
import com.demo.xx.model.bean.User
import com.demo.xx.model.db.DbProvider
import javax.inject.Inject

class UserModel @Inject constructor() {

    fun getUsers(): List<User> {
        val users = DbProvider.db.userDao().getAll()
        return users
    }

    fun getUsersPaged(): PagingSource<Int, User> {
        return DbProvider.db.userDao().getUserPaged()
    }

}