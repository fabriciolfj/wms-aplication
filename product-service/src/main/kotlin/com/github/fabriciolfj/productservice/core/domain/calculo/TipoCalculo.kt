package com.github.fabriciolfj.productservice.core.domain.calculo

import java.math.BigDecimal

interface TipoCalculo {

    fun calcular(base: BigDecimal): BigDecimal
}