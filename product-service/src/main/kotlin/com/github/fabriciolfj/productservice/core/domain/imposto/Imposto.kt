package com.github.fabriciolfj.productservice.core.domain.imposto

import java.math.BigDecimal

abstract class Imposto(open var base: BigDecimal) {

    abstract var imposto : Imposto?
    fun calular() : BigDecimal {
        var valor = base.multiply(getAliquota()).div(BigDecimal(100.00))
        return  valor.add(imposto?.calular() ?: BigDecimal.ZERO)
    }

    abstract fun getAliquota() : BigDecimal

    abstract fun nextImposto(imposto: Imposto?): Imposto?
}