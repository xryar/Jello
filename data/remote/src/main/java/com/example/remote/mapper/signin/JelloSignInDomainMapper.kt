package com.example.remote.mapper.signin

import com.example.domain.mapper.base.Mapper
import com.example.domain.model.domain.JelloSignInDomainModel
import com.example.remote.model.signin.JelloBaseResponse
import com.example.remote.model.signin.JelloSignInResponse

class JelloSignInDomainMapper: Mapper<JelloBaseResponse<JelloSignInResponse>, JelloSignInDomainModel> {

    override fun to(t: JelloBaseResponse<JelloSignInResponse>): JelloSignInDomainModel =
        JelloSignInDomainModel(
            code = t.code ?: 0,
            message = t.message.orEmpty(),
            name = t.data?.name.orEmpty(),
            address = t.data?.address.orEmpty(),
            profil = t.data?.profil.orEmpty(),
            token = t.data?.token.orEmpty(),
        )


}