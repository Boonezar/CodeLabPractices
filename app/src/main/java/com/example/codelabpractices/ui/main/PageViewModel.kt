package com.example.codelabpractices.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

class PageViewModel : ViewModel() {

    private val _type = MutableLiveData<String>()
    private val _buttonEvents = MutableLiveData<TabNavigationButtonEvent>()
    val buttonEvents: LiveData<TabNavigationButtonEvent> = _buttonEvents
    val text: LiveData<String> = Transformations.map(_type) {
        "Tap to test $it"
    }
    val buttonText: LiveData<String> = Transformations.map(_type) {
        it
    }

    fun setType(type: String) {
        _type.value = type
    }

    fun buttonClick() {
        if(_type.value == "Alert Dialog") {
            _buttonEvents.value = TabNavigationButtonEvent.OPEN_ALERT_DIALOG
        } else if(_type.value == "Date Picker") {
            _buttonEvents.value = TabNavigationButtonEvent.OPEN_DATE_PICKER
        }
    }
}

enum class TabNavigationButtonEvent {
    OPEN_ALERT_DIALOG,
    OPEN_DATE_PICKER
}
