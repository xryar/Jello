package com.example.remote.mapper.home

import com.example.domain.mapper.base.Mapper
import com.example.domain.model.domain.JelloHomeDomainModel
import com.example.remote.model.home.JelloHomeResponse
import com.example.remote.model.signin.JelloBaseResponse

class JelloHomeDomainMapper: Mapper<JelloBaseResponse<JelloHomeResponse>, JelloHomeDomainModel> {

    override fun to(t: JelloBaseResponse<JelloHomeResponse>): JelloHomeDomainModel =
        JelloHomeDomainModel(
            header = t.data?.header?.map { it.toHeaderDomain() } ?: listOf(),
            body = t.data?.body?.map { it.toBodyDomain() } ?: listOf(),
        )

    fun JelloHomeResponse.HeaderResponse.toHeaderDomain(): JelloHomeDomainModel.HeaderDomainModel {
        return JelloHomeDomainModel.HeaderDomainModel(
            id = this.id ?: 0,
            image = this.image.orEmpty(),
        )
    }

    fun JelloHomeResponse.BodyResponse.toBodyDomain(): JelloHomeDomainModel.BodyDomainModel {
        return JelloHomeDomainModel.BodyDomainModel(
            title = this.title.orEmpty(),
            data = this.data?.map { it.toDataDomain() } ?: listOf()
        )
    }

    fun JelloHomeResponse.BodyResponse.DataResponse.toDataDomain(): JelloHomeDomainModel.BodyDomainModel.DataDomainModel {
        return JelloHomeDomainModel.BodyDomainModel.DataDomainModel(
            id = this.id ?: 0,
            image = this.image.orEmpty(),
        )
    }


}