package com.example.foodappbyjalgas.util

interface DomainMapper<Entity,DomainModel> {
    fun mapToDomainModel(entity: Entity):DomainModel
    fun mapFromDomainModel(domainModel: DomainModel):Entity
}