package com.example.domain.usecase

import com.example.domain.mapper.home.JelloHomeUiMapper
import com.example.domain.model.base.DomainResource
import com.example.domain.model.base.UIState
import com.example.domain.model.ui.JelloHomeUiModel
import com.example.domain.repository.JelloRepository
import com.example.domain.repository.PreferenceRepository
import com.example.domain.utils.mapTo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FetchHomeUseCase @Inject constructor(
    private val repository: JelloRepository,
    private val preferenceRepository: PreferenceRepository
) {

    operator fun invoke(): Flow<UIState<JelloHomeUiModel>> = flow {
        emit(UIState.OnLoading())

        preferenceRepository.getString("token_user").let {
            when (val result = repository.fetchHome(it)) {
                is DomainResource.OnError -> {
                    emit(UIState.OnFailed(domainResourceError = result.domainResourceError))
                }
                is DomainResource.OnSuccess -> {
                    val dataTemp = result.data
                    emit(UIState.OnSuccess(dataTemp.mapTo(JelloHomeUiMapper())))
                }
                else -> Unit
            }
        }
    }

}