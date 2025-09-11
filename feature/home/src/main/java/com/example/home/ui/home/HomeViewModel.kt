package com.example.home.ui.home

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.base.UIState
import com.example.domain.usecase.FetchHomeUseCase
import com.example.home.state.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchHomeUseCase: FetchHomeUseCase
): ViewModel() {

    private val _home: MutableStateFlow<HomeState> = MutableStateFlow(HomeState.OnLoading)
    val home: StateFlow<HomeState> get() = _home

    fun fetchHome() =
        viewModelScope.launch(Dispatchers.Main) {
            fetchHomeUseCase.invoke().collect {
                when(it) {
                    is UIState.OnLoading -> _home.value = HomeState.OnLoading
                    is UIState.OnFailed -> _home.value = HomeState.OnError(it.domainResourceError?.message.orEmpty())
                    is UIState.OnSuccess -> _home.value = HomeState.OnHomeAvailable(it.data)
                }
            }
        }

}