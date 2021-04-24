package com.github.fabriciolfj.productservice.core.domain.calculo

enum class TipoCalculo(val descricao: String) {

    TRIBUTADO("tributado"),
    ISENTOPISCOFINS("isentopiscofins"),
    TRIBUTADOCOFINSISENTO("tributadocofinsisento");

    companion object {
        fun toEnum(descricao: String) : TipoCalculo {
            return values().first { it.descricao == descricao }
        }
    }
}