package com.jcpd.pruebainterrapidisimo.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jcpd.pruebainterrapidisimo.data.Repository
import com.jcpd.pruebainterrapidisimo.data.local.SharedPreferencesManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository,
    private val sharedPreferencesManager: SharedPreferencesManager
) : ViewModel() {

    private val _state = MutableStateFlow<HomeScreenState>(HomeScreenState())
    val state: StateFlow<HomeScreenState> = _state.asStateFlow()

    init {
        checkVersion()
        login()
    }

    private fun login() {
        viewModelScope.launch {
            val response = repository.getLogin()
            _state.update { state ->
                if (response.isSuccessful && response.body() != null) {
                    sharedPreferencesManager.saveUser(response.body())
                }
                state.copy(
                    userModel = response.body(),
                    loading = false,
                    error = response.code() != 200,
                    errorMessage = response.errorBody().toString()
                )
            }
        }
    }

    private fun checkVersion() {
        viewModelScope.launch {
            val response = repository.getVersion().body()
            _state.update { state ->
                if (response != null) {
                    comperVersion(response)
                    sharedPreferencesManager.saveVersion(response)
                }
                state.copy(version = response)
            }
        }
    }

    private fun comperVersion(response: String) {
        var version = sharedPreferencesManager.readVersion()
        if (version != response) {
            if (version != null) {
                _state.update { state ->
                    state.copy(shouldDisplayDialog = true, isVersionUp = version.toInt() > response.toInt())
                }
            }
        }
    }
}