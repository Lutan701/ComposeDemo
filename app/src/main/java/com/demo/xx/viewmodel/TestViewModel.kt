package com.demo.xx.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.demo.xx.instrument.RackInfo
import com.demo.xx.instrument.RackList
import com.demo.xx.instrument.RackState
import com.demo.xx.model.UserModel
import com.demo.xx.model.bean.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TestViewModel @Inject constructor(
    private val userModel: UserModel,
) : ViewModel() {

    private val _racks = MutableLiveData(RackList)
    val racks:LiveData<List<RackInfo>> get() = _racks

    fun changeRackState(rackId: Int, state: RackState) {
        val updateRacks = _racks.value!!.map { rack ->
            if (rack.rackId == rackId) {
                rack.copy(state = state)
            } else {
                rack
            }
        }
        _racks.value = updateRacks
    }


    val userPager: Flow<PagingData<User>> = Pager(
        config = PagingConfig(
            pageSize = 30, // 每页的大小
            enablePlaceholders = false // 禁用占位符
        )
    ) {
        userModel.getUsersPaged()
    }.flow.cachedIn(viewModelScope)

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users

    fun getUsers() {
        viewModelScope.launch {
            val list = withContext(Dispatchers.IO) { userModel.getUsers() }
            _users.value = list
        }
    }

}