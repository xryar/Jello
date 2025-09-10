package com.example.auth.state

import com.example.domain.model.ui.JelloSignInUiModel

sealed class SignInState {

    data class OnSignInAvailable(
        val signInUiModel: JelloSignInUiModel?
    ): SignInState()

    object  OnSignInLoading: SignInState()

    data class OnSignInError(
        val message: String
    ): SignInState()

}