package com.demo.xx.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.xx.model.BarrelModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val barrelModel: BarrelModel
) : ViewModel() {

    private val _barrelsStatus = MutableLiveData<List<Int>>()
    val barrelStatus: LiveData<List<Int>> get() = _barrelsStatus

    init {
        getBarrelsStatus()
    }

    fun getBarrelsStatus() {
        viewModelScope.launch {
            val list = barrelModel.getBarrelsStatus()
            _barrelsStatus.value = list
        }
    }

    fun setBarrelsStatus(list: List<Int>) {
        _barrelsStatus.value = list
    }

}