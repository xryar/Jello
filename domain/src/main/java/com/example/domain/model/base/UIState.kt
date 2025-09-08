package com.example.domain.model.base

sealed class UIState<V> {
    class OnLoading<V> : UIState<V>()

    data class OnSuccess<V: Any>(val data: V?) : UIState<V>()

    data class OnFailed<V>(
        val message: String? = null,
        val domainResourceError: DomainResourceError? = null
    ) : UIState<V>()
}