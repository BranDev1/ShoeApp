package com.udacity.shoestore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class SharedViewModel: ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
    get() =_shoeList

    fun onSave(shoe: Shoe){
        _shoeList.value?.add(shoe)
        Log.d("Shared","${_shoeList.value?.get(0)?.name}")
        Timber.i(_shoeList.value?.get(0)?.name)
    }

}