package com.github.fabriciolfj.productservice.adapters.`in`.product.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL
import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

@JsonInclude(NON_NULL)
class ProductResponse(var name: String, var code: String,@JsonProperty("id_category") val idCategory: Long, val imposto: BigDecimal) {
    constructor() : this("", "", 0L, BigDecimal.ZERO)
}