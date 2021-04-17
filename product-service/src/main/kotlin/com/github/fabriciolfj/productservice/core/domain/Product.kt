package com.github.fabriciolfj.productservice.core.domain

data class Product(val name: String, val code: String, val category: Category?) {
    constructor() : this("", "", null)
}