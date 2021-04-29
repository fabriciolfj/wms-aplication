package com.github.fabriciolfj.productservice.core.exceptions.dto

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class ErrosDTO(val message: String, val field: String)