package com.udacity.shoestore.screens.shoedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeDetailViewModel : ViewModel() {
    private val _eventDataSave = MutableLiveData<Boolean>()
    val eventDataSave : LiveData<Boolean> = _eventDataSave

    init {
        _eventDataSave.value = false
    }

    fun onDataSave() {
        _eventDataSave.value = true
    }

    fun onDataSaveComplete() {
        _eventDataSave.value = false
    }
}