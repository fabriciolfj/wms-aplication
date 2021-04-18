package com.github.fabriciolfj.productservice.core.domain

data class Category(var id: Long, var name: String, var products: List<Product>) {
    constructor() : this(0L,"", emptyList())
}