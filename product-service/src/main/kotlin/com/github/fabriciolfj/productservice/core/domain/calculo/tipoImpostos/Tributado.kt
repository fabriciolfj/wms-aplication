package com.github.fabriciolfj.productservice.core.domain.calculo.tipoImpostos

import com.github.fabriciolfj.productservice.core.domain.calculo.TipoCalculo
import com.github.fabriciolfj.productservice.core.domain.imposto.impl.Cofins
import com.github.fabriciolfj.productservice.core.domain.imposto.impl.Icms
import com.github.fabriciolfj.productservice.core.domain.imposto.impl.Pis
import java.math.BigDecimal
import java.math.RoundingMode

class Tributado : TipoCalculo {

    override fun calcular(base: BigDecimal): BigDecimal {
        val icms = Icms(base, Pis(base, Cofins(base)));
        val result = icms!!.calular()
        result.setScale(2, RoundingMode.FLOOR)
        return result;
    }
}