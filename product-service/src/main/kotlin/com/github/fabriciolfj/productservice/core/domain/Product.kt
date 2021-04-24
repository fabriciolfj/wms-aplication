package com.github.fabriciolfj.productservice.core.domain

import java.math.BigDecimal

data class Product(var name: String, var code: String, var price: BigDecimal, var imposto: BigDecimal, var category: Category?) {
    constructor() : this("", "", BigDecimal.ZERO, BigDecimal.ZERO, null)
}