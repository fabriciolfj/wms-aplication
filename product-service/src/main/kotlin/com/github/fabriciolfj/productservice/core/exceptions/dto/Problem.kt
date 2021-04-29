package com.github.fabriciolfj.productservice.core.exceptions.dto

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class Problem(val message: String, val status: Int, val erros: List<ErrosDTO>?) {
    constructor(message: String, status: Int) : this(message, status, null)
}