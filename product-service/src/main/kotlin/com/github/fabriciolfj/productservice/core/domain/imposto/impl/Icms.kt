package com.github.fabriciolfj.productservice.core.domain.imposto.impl

import com.github.fabriciolfj.productservice.core.domain.faixa.impl.FaixaIcms
import com.github.fabriciolfj.productservice.core.domain.imposto.Imposto
import java.math.BigDecimal

class Icms(override var base: BigDecimal, override var imposto: Imposto? = null): Imposto(base, imposto) {

    override fun getAliquota(): BigDecimal {
        return FaixaIcms.FAIXA.getAliquota()
    }
}