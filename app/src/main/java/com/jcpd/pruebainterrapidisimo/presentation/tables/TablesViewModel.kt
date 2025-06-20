package com.jcpd.pruebainterrapidisimo.presentation.tables

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jcpd.pruebainterrapidisimo.data.Repository
import com.jcpd.pruebainterrapidisimo.data.models.TableModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TablesViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val _state = MutableStateFlow<List<TableModel>>(listOf())
    val state: StateFlow<List<TableModel>> = _state.asStateFlow()

    init {
        getEsqueme()
    }

    private fun getEsqueme() {
        viewModelScope.launch {
            val response = repository.getEsqueme()
            if (response.isSuccessful && response.body() != null) {
                _state.value = response.body()!!
            }
        }
    }
}