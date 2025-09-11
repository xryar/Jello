package com.example.home.state

import com.example.domain.model.ui.JelloHomeUiModel

sealed class HomeState {

    data class OnHomeAvailable(
        val dataUiModel: JelloHomeUiModel?
    ): HomeState()

    object OnLoading: HomeState()

    data class OnError(
        val message: String
    ): HomeState()

}