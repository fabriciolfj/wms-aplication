package com.github.fabriciolfj.productservice.core.domain.faixa.impl

import com.github.fabriciolfj.productservice.core.domain.faixa.Faixa
import java.math.BigDecimal

enum class FaixaIcms : Faixa {

    FAIXA {
        override fun getAliquota() = BigDecimal(18.00)
    };
}