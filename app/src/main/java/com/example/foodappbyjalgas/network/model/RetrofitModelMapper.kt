package com.example.foodappbyjalgas.network.model

import com.example.foodappbyjalgas.domain.model.Model
import com.example.foodappbyjalgas.util.DomainMapper

class RetrofitModelMapper : DomainMapper<RetrofitModel, Model> {
    override fun mapToDomainModel(entity: RetrofitModel): Model {
        return Model(
                id = entity.pk,
                title = entity.title,
                sourceUrl = entity.sourceUrl,
                rating = entity.rating,
                publisher = entity.publisher,
                ingredients = entity.ingredients,
                featuredImage = entity.featuredImage,
                description = entity.description,
                dateAdded = entity.dateAdded,
                dateUpdated = entity.dateUpdated,
                cookingInstructions = entity.cookingInstructions,

                )
    }

    override fun mapFromDomainModel(domainModel: Model): RetrofitModel {

        return RetrofitModel(
                pk = domainModel.id,
                title = domainModel.title,
                sourceUrl = domainModel.sourceUrl,
                rating = domainModel.rating,
                publisher = domainModel.publisher,
                ingredients = domainModel.ingredients,
                featuredImage = domainModel.featuredImage,
                description = domainModel.description,
                dateAdded = domainModel.dateAdded,
                dateUpdated = domainModel.dateUpdated,
                cookingInstructions = domainModel.cookingInstructions,
        )
    }
}