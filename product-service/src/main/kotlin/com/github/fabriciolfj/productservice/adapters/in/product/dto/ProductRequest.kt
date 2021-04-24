package com.github.fabriciolfj.productservice.adapters.`in`.product.dto

import java.math.BigDecimal
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class ProductRequest(
    @field:NotBlank(message = "Name mandatory") var name : String,
    @field:NotBlank(message = "Category mandatory") var category: String,
    @field:NotNull(message = "Informe o valor do produto") var price: BigDecimal,
    @field:NotBlank(message = "Informe o tipo de tributacao") var tributo: String)