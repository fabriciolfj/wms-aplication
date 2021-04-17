package com.github.fabriciolfj.productservice.adapters.`in`.category.dto

data class CategoryResponse(var name: String, var products: List<ProductsCategoryResponse>) {

    constructor() : this("", emptyList())
}