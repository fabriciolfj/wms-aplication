package com.github.fabriciolfj.productservice.adapters.`in`.category.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.validation.constraints.NotBlank

@JsonIgnoreProperties(ignoreUnknown = true)
data class CategoryRequest(
                           @field:NotBlank(message = "Description mandatory")
                           val description: String)