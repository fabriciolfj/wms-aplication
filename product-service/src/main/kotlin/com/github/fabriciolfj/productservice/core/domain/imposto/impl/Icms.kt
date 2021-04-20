package com.github.fabriciolfj.productservice.core.domain.imposto.impl

import com.github.fabriciolfj.productservice.core.domain.faixa.impl.FaixaIcms
import com.github.fabriciolfj.productservice.core.domain.imposto.Imposto
import java.math.BigDecimal

class Icms(override var base: BigDecimal): Imposto(base) {

    override var imposto : Imposto? = null

    override fun getAliquota(): BigDecimal {
        return FaixaIcms.FAIXA.getAliquota()
    }

    override fun nextImposto(imposto: Imposto?) : Imposto? {
        this.imposto = imposto
        return this.imposto
    }
}