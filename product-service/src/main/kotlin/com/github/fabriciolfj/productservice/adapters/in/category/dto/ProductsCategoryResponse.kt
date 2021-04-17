package com.github.fabriciolfj.productservice.adapters.`in`.category.dto

data class ProductsCategoryResponse(val name: String, val code: String) {

    constructor(): this("", "")
}