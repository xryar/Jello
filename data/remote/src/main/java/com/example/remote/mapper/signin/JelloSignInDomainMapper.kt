package com.example.remote.mapper.signin

import com.example.domain.mapper.base.Mapper
import com.example.domain.model.domain.JelloSignInDomainModel
import com.example.remote.model.signin.JelloBaseResponse

class JelloSignInDomainMapper: Mapper<JelloBaseResponse, JelloSignInDomainModel> {

    override fun to(t: JelloBaseResponse): JelloSignInDomainModel =
        JelloSignInDomainModel(
            name = t.data?.name.orEmpty(),
            address = t.data?.address.orEmpty(),
            profil = t.data?.profil.orEmpty(),
            token = t.data?.token.orEmpty(),
        )


}