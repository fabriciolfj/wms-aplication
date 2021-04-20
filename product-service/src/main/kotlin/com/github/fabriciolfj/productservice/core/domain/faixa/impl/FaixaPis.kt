package com.github.fabriciolfj.productservice.core.domain.faixa.impl

import com.github.fabriciolfj.productservice.core.domain.faixa.Faixa
import java.math.BigDecimal

enum class FaixaPis : Faixa {

    FAIXA {
        override fun getAliquota() = BigDecimal(0.65)
    };
}