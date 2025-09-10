package com.example.auth.ui.signin

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.auth.state.SignInState
import com.example.domain.model.base.UIState
import com.example.domain.usecase.GetUserTokenUseCase
import com.example.domain.usecase.PostJelloSignInUseCase
import com.example.domain.usecase.SaveUserTokenUseCase
import com.example.navigator.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val navigator: Navigator,
    private val postJelloSignInUseCase: PostJelloSignInUseCase,
    private val saveUserTokenUseCase: SaveUserTokenUseCase,
    private val getUserTokenUseCase: GetUserTokenUseCase,
) : ViewModel() {

    private val _signIn: MutableLiveData<SignInState> = MutableLiveData()
    val signIn: LiveData<SignInState> = _signIn

    private val _token: MutableLiveData<String> = MutableLiveData()
    val token: LiveData<String> = _token

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
                        it.data?.let {
                            saveUserTokenUseCase.invoke(it.token)
                        }
                        _signIn.value = SignInState.OnSignInAvailable(it.data)
                    }
                }
            }
        }
    }

    fun onNavigateToHome(context: Context) {
        navigator.navigateToFeatureHome(context)
    }

    fun getToken() {
        viewModelScope.launch(Dispatchers.Main) {
            getUserTokenUseCase().collect {
                _token.value = it
            }
        }
    }
}