package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class SharedViewModel: ViewModel() {


    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>> = _shoeList

    private val _eventDataSave = MutableLiveData<Boolean>()
    val eventDataSave : LiveData<Boolean> = _eventDataSave

    init {
        _eventDataSave.value = false
    }

    fun onSave(shoe: Shoe){
        _shoeList.value?.add(shoe)
    }

    fun onDataSave() {
        _eventDataSave.value = true
    }

    fun onDataSaveComplete() {
        _eventDataSave.value = false
    }

}