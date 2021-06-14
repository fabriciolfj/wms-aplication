package com.github.fabriciolfj.productservice.core.domain.calculo.tipoImpostos

import com.github.fabriciolfj.productservice.core.domain.calculo.TipoCalculo
import com.github.fabriciolfj.productservice.core.domain.imposto.impl.Icms
import java.math.BigDecimal
import java.math.RoundingMode


class IsentoPisCofins : TipoCalculo {

    override fun calcular(base: BigDecimal): BigDecimal {
        return Icms(base).calular().setScale(2, RoundingMode.FLOOR)
    }
}