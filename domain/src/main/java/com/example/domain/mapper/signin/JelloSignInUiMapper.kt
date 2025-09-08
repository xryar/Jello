package com.example.domain.mapper.signin

import com.example.domain.mapper.base.Mapper
import com.example.domain.model.domain.JelloSignInDomainModel
import com.example.domain.model.ui.JelloSignInUiModel

class JelloSignInUiMapper: Mapper<JelloSignInDomainModel, JelloSignInUiModel> {
    override fun to(t: JelloSignInDomainModel): JelloSignInUiModel {
        return JelloSignInUiModel(
            address = t.address,
            name = t.name,
            token = t.token,
            profil = t.profil,
        )
    }

}