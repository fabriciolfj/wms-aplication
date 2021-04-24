package com.github.fabriciolfj.productservice.core.domain.calculo

import com.github.fabriciolfj.productservice.core.domain.imposto.impl.Cofins
import com.github.fabriciolfj.productservice.core.domain.imposto.impl.Icms
import com.github.fabriciolfj.productservice.core.domain.imposto.impl.Pis
import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.math.RoundingMode

@Component
class Calculo {

    fun createImposto(tipoCalculo: TipoCalculo, base: BigDecimal): BigDecimal {
        return when (tipoCalculo) {
            TipoCalculo.TRIBUTADO -> {
                val icms = Icms(base, Pis(base, Cofins(base)));
                val result = icms!!.calular()
                result.setScale(2, RoundingMode.FLOOR)
            }
            TipoCalculo.ISENTOPISCOFINS -> {
                Icms(base).calular().setScale(2, RoundingMode.FLOOR)
            }
            TipoCalculo.TRIBUTADOCOFINSISENTO -> {
                val icms = Icms(base, Pis(base))
                icms!!.calular().setScale(2, RoundingMode.FLOOR)
            }
        }
    }
}