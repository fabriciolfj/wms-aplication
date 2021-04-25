package com.github.fabriciolfj.productservice.core.exceptions.dto

data class Problem(val message: String, val status: Int, val erros: List<ErrosDTO>)