package com.example.remote.repository

import com.example.domain.model.base.DomainResource
import com.example.domain.model.domain.JelloHomeDomainModel
import com.example.domain.model.domain.JelloSignInDomainModel
import com.example.domain.repository.JelloRepository
import com.example.remote.mapper.home.JelloHomeDomainMapper
import com.example.remote.mapper.signin.JelloSignInDomainMapper
import com.example.remote.service.JelloService
import com.example.remote.utils.handleApiCall
import javax.inject.Inject

class JelloRepositoryImpl @Inject constructor(
    private val jelloService: JelloService
): JelloRepository {

    override suspend fun login(
        email: String,
        password: String
    ): DomainResource<JelloSignInDomainModel> {
        return handleApiCall(
            apiServiceTransform = {
                jelloService.login(email, password)
            },
            mapperToDomain = JelloSignInDomainMapper()
        )
    }

    override suspend fun fetchHome(token: String): DomainResource<JelloHomeDomainModel> {
        return handleApiCall(
            apiServiceTransform = {
                jelloService.getHome(
                    token = token
                )
            },
            mapperToDomain = JelloHomeDomainMapper()
        )
    }

}