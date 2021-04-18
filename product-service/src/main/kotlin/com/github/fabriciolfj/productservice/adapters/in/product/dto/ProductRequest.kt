package com.github.fabriciolfj.productservice.adapters.`in`.product.dto

import javax.validation.constraints.NotBlank

data class ProductRequest(
    @field:NotBlank(message = "Name mandatory") var name : String,
    @field:NotBlank(message = "Category mandatory")
    var category: String)