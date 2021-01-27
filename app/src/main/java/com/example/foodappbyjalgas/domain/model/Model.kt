package com.example.foodappbyjalgas.domain.model


import com.google.gson.annotations.SerializedName

data class Model(
    var id: Int? = null,
    var title: String? = null,
    var publisher: String? = null,
    var featuredImage: String? = null,
    var rating: Int? = 0,
    var sourceUrl: String? = null,
    var description: String? = null,
    var cookingInstructions: String? = null,
    var ingredients: List<String>? = null,
    var dateAdded: String? = null,
    var dateUpdated: String? = null,
)