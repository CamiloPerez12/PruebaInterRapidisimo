package com.jcpd.pruebainterrapidisimo.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jcpd.pruebainterrapidisimo.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository : Repository
): ViewModel(){

    private val _version = MutableStateFlow("")
    val version : StateFlow <String> = _version.asStateFlow()

    init {
        checkVersion()
    }

    private fun checkVersion() {
        viewModelScope.launch {
            val response = repository.getVersion().body()
            _version.update {
                response?: "Error"
            }
        }
    }

}