package com.example.auth.ui.signin

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.auth.state.SignInState
import com.example.domain.model.base.UIState
import com.example.domain.usecase.PostJelloSignInUseCase
import com.example.navigator.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val navigator: Navigator,
    private val postJelloSignInUseCase: PostJelloSignInUseCase,
) : ViewModel() {

    private val _signIn: MutableLiveData<SignInState> = MutableLiveData()
    private val signIn: LiveData<SignInState> = _signIn

    fun postSignIn(email: String, password: String) {
        viewModelScope.launch(Dispatchers.Main) {
            postJelloSignInUseCase(email, password).collect {
                when(it) {
                    is UIState.OnFailed -> {
                        _signIn.value = SignInState.OnSignInError(it.domainResourceError?.message.orEmpty())
                    }
                    is UIState.OnLoading -> {
                        _signIn.value = SignInState.OnSignInLoading
                    }
                    is UIState.OnSuccess -> {
                        _signIn.value = SignInState.OnSignInAvailable(it.data)
                    }
                }
            }
        }
    }

    fun onNavigateToHome(context: Context) {
        navigator.navigateToFeatureHome(context)
    }
}