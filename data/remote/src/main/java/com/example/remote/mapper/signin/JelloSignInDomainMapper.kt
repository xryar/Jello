package com.example.remote.mapper.signin

import com.example.domain.mapper.base.Mapper
import com.example.domain.model.domain.JelloSignInDomainModel
import com.example.remote.model.signin.JelloBaseResponse
import com.example.remote.model.signin.JelloSignInResponse

class JelloSignInDomainMapper: Mapper<JelloSignInResponse, JelloSignInDomainModel> {
    override fun to(t: JelloSignInResponse): JelloSignInDomainModel {
        return JelloSignInDomainModel(
            name = t.data?.name.orEmpty(),
            addresss = t.data?.address.orEmpty(),
            token = t.data?.token.orEmpty(),
            profil = t.data?.profil.orEmpty(),
        )
    }
}