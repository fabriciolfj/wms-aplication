package com.github.fabriciolfj.productservice.core.domain.imposto.impl

import com.github.fabriciolfj.productservice.core.domain.faixa.impl.FaixaPis
import com.github.fabriciolfj.productservice.core.domain.imposto.Imposto
import java.math.BigDecimal

class Pis(override var base: BigDecimal): Imposto(base) {

    override var imposto : Imposto? = null

    override fun getAliquota(): BigDecimal {
        return FaixaPis.FAIXA.getAliquota()
    }

    override fun nextImposto(imposto: Imposto?) : Imposto? {
        this.imposto = imposto
        return imposto
    }
}