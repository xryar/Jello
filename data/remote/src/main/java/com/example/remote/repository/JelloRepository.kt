package com.example.remote.repository

interface JelloRepository {

    suspend fun Login(email: String, password: String) : DomainResource<JelloLoginDomainModel>

}