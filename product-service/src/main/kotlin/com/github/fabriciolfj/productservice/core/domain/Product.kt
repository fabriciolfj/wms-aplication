package com.github.fabriciolfj.productservice.core.domain

data class Product(var name: String, var code: String, var category: Category?) {
    constructor() : this("", "", null)
}