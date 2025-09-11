package com.example.remote.mapper.home

import com.example.domain.mapper.base.Mapper
import com.example.domain.model.domain.JelloSignInDomainModel
import com.example.remote.model.signin.JelloBaseResponse

class JelloHomeDomainMapper: Mapper<JelloBaseResponse, JelloSignInDomainModel> {

    override fun to(t: JelloBaseResponse): JelloSignInDomainModel =
        JelloSignInDomainModel(
            code = t.code ?: 0,
            message = t.message.orEmpty(),
            name = t.data?.name.orEmpty(),
            address = t.data?.address.orEmpty(),
            profil = t.data?.profil.orEmpty(),
            token = t.data?.token.orEmpty(),
        )


}