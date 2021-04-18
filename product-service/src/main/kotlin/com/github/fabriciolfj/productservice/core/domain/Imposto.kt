package com.github.fabriciolfj.productservice.core.domain

import java.math.BigDecimal

abstract class Imposto(aliquota: BigDecimal) {

    abstract fun calular(base: BigDecimal, imposto: Imposto)
}