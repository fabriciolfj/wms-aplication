package com.github.fabriciolfj.productservice.core.domain.faixa.impl

import com.github.fabriciolfj.productservice.core.domain.faixa.Faixa
import java.math.BigDecimal

enum class FaixaCofins : Faixa {

    FAIXA {
        override fun getAliquota() = BigDecimal(7.00)
    };
}