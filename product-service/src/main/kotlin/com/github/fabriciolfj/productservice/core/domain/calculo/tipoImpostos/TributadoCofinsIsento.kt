package com.github.fabriciolfj.productservice.core.domain.calculo.tipoImpostos

import com.github.fabriciolfj.productservice.core.domain.calculo.TipoCalculo
import com.github.fabriciolfj.productservice.core.domain.imposto.impl.Icms
import com.github.fabriciolfj.productservice.core.domain.imposto.impl.Pis
import java.math.BigDecimal
import java.math.RoundingMode

class TributadoCofinsIsento : TipoCalculo {

    override fun calcular(base: BigDecimal): BigDecimal {
        val icms = Icms(base, Pis(base))
        return icms!!.calular().setScale(2, RoundingMode.FLOOR)
    }
}