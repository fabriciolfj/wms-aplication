package com.github.fabriciolfj.productservice.core.domain.imposto

import java.math.BigDecimal

abstract class Imposto(open var base: BigDecimal, open var imposto: Imposto?) {

    fun calular() : BigDecimal {
        val percentual = (getAliquota().divide(BigDecimal.valueOf(100)))
        var valor = base.multiply(percentual)
        return  valor.add(imposto?.calular() ?: BigDecimal.ZERO)
    }

    abstract fun getAliquota() : BigDecimal
}