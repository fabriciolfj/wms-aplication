package com.github.fabriciolfj.productservice.adapters.`in`.product.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(NON_NULL)
class ProductResponse(val name: String, val code: String,@JsonProperty("id_category") val idCategory: Long)