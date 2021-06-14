package com.github.fabriciolfj.productservice.core.domain.calculo

import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class Calculo {

    fun createImposto(tipoCalculo: TipoCalculo, base: BigDecimal): BigDecimal {
        return tipoCalculo.calcular(base)
    }
}