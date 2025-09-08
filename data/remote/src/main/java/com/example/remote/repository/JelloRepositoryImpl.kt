package com.example.remote.repository

import com.example.domain.model.base.DomainResource
import com.example.domain.model.domain.JelloSignInDomainModel
import com.example.domain.repository.JelloRepository
import com.example.remote.service.JelloService
import com.example.remote.utils.handleApiCall

class JelloRepositoryImpl @Inject constructor(
    private val jelloService: JelloService
): JelloRepository {

    override suspend fun Login(
        email: String,
        password: String
    ): DomainResource<JelloSignInDomainModel> {
        return handleApiCall(
            apiServiceTransform = {
                jelloService.Login(email, password)
            },
            mapperToDomain = JelloSignInDomainMapper()
        )
    }

}