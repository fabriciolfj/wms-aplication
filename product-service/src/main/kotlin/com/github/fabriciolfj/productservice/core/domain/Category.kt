package com.github.fabriciolfj.productservice.core.domain

data class Category(var name: String, var products: List<Product>) {
    constructor() : this("", emptyList())
}