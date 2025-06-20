package com.jcpd.pruebainterrapidisimo.presentation.location

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jcpd.pruebainterrapidisimo.data.Repository
import com.jcpd.pruebainterrapidisimo.data.models.LocationsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel(){

    private val _state = MutableStateFlow<List<LocationsModel>>(listOf())
    val state: StateFlow<List<LocationsModel>> = _state.asStateFlow()

    init {
        getLocations()
    }

    private fun getLocations() {
        viewModelScope.launch {
            val response  = repository.getLocations()
            if (response.isSuccessful && response.body() != null) {
                _state.value = response.body()!!
            }
        }
    }
}