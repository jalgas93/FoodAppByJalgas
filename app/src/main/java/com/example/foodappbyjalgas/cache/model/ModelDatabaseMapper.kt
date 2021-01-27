package com.example.foodappbyjalgas.cache.model

import com.example.foodappbyjalgas.domain.model.Model
import com.example.foodappbyjalgas.util.DomainMapper
import java.lang.StringBuilder

class ModelDatabaseMapper : DomainMapper<ModelDatabase, Model> {
    override fun mapToDomainModel(entity: ModelDatabase): Model {
        return Model(
                id = entity.id,
                title = entity.title,
                sourceUrl = entity.sourceUrl,
                rating = entity.rating,
                publisher = entity.publisher,
                ingredients = mapToDomainModelToList(entity.ingredients),
                featuredImage = entity.featuredImage,
                description = entity.description,
                dateAdded = entity.dateAdded,
                dateUpdated = entity.dateUpdated,
                cookingInstructions = entity.cookingInstructions,
        )
    }

    override fun mapFromDomainModel(domainModel: Model): ModelDatabase {
        return ModelDatabase(
                id = domainModel.id!!,
                title = domainModel.title!!,
                sourceUrl = domainModel.sourceUrl,
                rating = domainModel.rating,
                publisher = domainModel.publisher,
                ingredients = mapFromDomainModelToString(domainModel.ingredients!!),
                featuredImage = domainModel.featuredImage,
                description = domainModel.description,
                dateAdded = domainModel.dateAdded,
                dateUpdated = domainModel.dateUpdated,
                cookingInstructions = domainModel.cookingInstructions,
        )
    }

    private fun mapToDomainModelToList(ingredients: String?): List<String>? {
        var list: ArrayList<String> = ArrayList()
        ingredients?.let {
            for (ingredients in it.split(",")) {
                list.add(ingredients)
            }
        }
        return list

    }

    private fun mapFromDomainModelToString(ingredients: List<String>): String {
        val ingredientString: StringBuilder = StringBuilder()
        for (ingredient in ingredients) {
            ingredientString.append("$ingredient")
        }
        return ingredientString.toString()

    }


}