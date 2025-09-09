package com.example.domain.usecase

import com.example.domain.mapper.signin.JelloSignInUiMapper
import com.example.domain.model.base.DomainResource
import com.example.domain.model.base.UIState
import com.example.domain.model.ui.JelloSignInUiModel
import com.example.domain.repository.JelloRepository
import com.example.domain.utils.mapTo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PostJelloSignInUseCase @Inject constructor(
    private val repository: JelloRepository
) {

    operator fun invoke(
        email: String,
        password: String,
    ): Flow<UIState<JelloSignInUiModel>> = flow {
        emit(UIState.OnLoading())

        when(val result = repository.login(email, password)) {
            is DomainResource.OnError -> {
                emit(UIState.OnFailed(domainResourceError = result.domainResourceError))
            }
            is DomainResource.OnSuccess -> {
                val dataResult = result.data
                emit(UIState.OnSuccess(dataResult.mapTo(JelloSignInUiMapper())))
            }
            else -> Unit
        }
    }

}