package com.example.codelabpractices

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codelabpractices.data.MarsPhoto
import com.example.codelabpractices.network.MarsApi
import com.example.codelabpractices.network.MarsApiStatus
import kotlinx.coroutines.launch

class CodeLabMarsPhotosViewModel : ViewModel() {
    private val _status = MutableLiveData<MarsApiStatus>()
    private val _photos = MutableLiveData<List<MarsPhoto>>()
    val status: LiveData<MarsApiStatus> = _status
    val photos: LiveData<List<MarsPhoto>> = _photos

    init {
        getMarsPhotos()
    }

    private fun getMarsPhotos() {
        viewModelScope.launch {
            _status.value = MarsApiStatus.LOADING
            try {
                _photos.value = MarsApi.retrofitService.getPhotos()
                _status.value = MarsApiStatus.DONE
            } catch (e: Exception) {
                _photos.value = emptyList()
                _status.value = MarsApiStatus.ERROR
            }
        }
    }
}