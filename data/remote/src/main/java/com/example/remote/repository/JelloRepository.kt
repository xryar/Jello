package com.example.remote.repository

import com.example.domain.model.base.DomainResource

interface JelloRepository {

    suspend fun Login(email: String, password: String) : DomainResource<JelloLoginDomainModel>

}