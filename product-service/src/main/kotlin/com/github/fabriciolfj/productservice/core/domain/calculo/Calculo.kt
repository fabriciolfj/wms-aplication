package com.github.fabriciolfj.productservice.core.domain.calculo

import com.github.fabriciolfj.productservice.core.domain.imposto.impl.Cofins
import com.github.fabriciolfj.productservice.core.domain.imposto.impl.Icms
import com.github.fabriciolfj.productservice.core.domain.imposto.impl.Pis
import java.math.BigDecimal

class Calculo {

    fun createImposto(tipoCalculo: TipoCalculo, base: BigDecimal): BigDecimal {
        return when (tipoCalculo) {
            TipoCalculo.TRIBUTADO -> {
                val icms = Icms(base).nextImposto(Pis(base).nextImposto(Cofins(base)))
                icms!!.calular()
            }
            TipoCalculo.ISENTOPISCOFINS -> {
                Icms(base).calular()
            }
            TipoCalculo.TRIBUTADOCOFINSISENTO -> {
                val icms = Icms(base).nextImposto(Pis(base))
                icms!!.calular()
            }
        }
    }
}