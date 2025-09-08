package com.example.domain.repository

import com.example.domain.model.base.DomainResource
import com.example.domain.model.domain.JelloSignInDomainModel

interface JelloRepository {

    suspend fun Login(email: String, password: String) : DomainResource<JelloSignInDomainModel>

}