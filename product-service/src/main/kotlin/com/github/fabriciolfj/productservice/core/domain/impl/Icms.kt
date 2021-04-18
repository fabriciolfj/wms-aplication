package com.github.fabriciolfj.productservice.core.domain.impl

import com.github.fabriciolfj.productservice.core.domain.Estado
import com.github.fabriciolfj.productservice.core.domain.Imposto
import java.math.BigDecimal

class Icms(aliquota: BigDecimal): Imposto(aliquota) {

    override fun calular(base: BigDecimal, imposto: Imposto) {
        TODO("Not yet implemented")
    }

    fun getAliquota(estado: Estado) : BigDecimal {
        return BigDecimal.ZERO
    }
}