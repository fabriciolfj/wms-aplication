package com.github.fabriciolfj.productservice.core.domain.imposto.impl

import com.github.fabriciolfj.productservice.core.domain.faixa.impl.FaixaCofins
import com.github.fabriciolfj.productservice.core.domain.imposto.Imposto
import java.math.BigDecimal

class Cofins(override var base: BigDecimal) : Imposto(base) {

    override var imposto : Imposto? = null

    override fun getAliquota(): BigDecimal {
        return FaixaCofins.FAIXA.getAliquota()
    }

    override fun nextImposto(imposto: Imposto?) : Imposto? {
        this.imposto = imposto
        return this.imposto
    }
}