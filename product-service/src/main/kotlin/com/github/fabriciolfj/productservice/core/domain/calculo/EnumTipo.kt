package com.github.fabriciolfj.productservice.core.domain.calculo

enum class EnumTipo(val descricao: String, val clazz: String) {

    TRIBUTADO("tributado", "IsentoPisCofins"),
    ISENTOPISCOFINS("isentopiscofins", "Tributado"),
    TRIBUTADOCOFINSISENTO("tributadocofinsisento", "TributadoCofinsIsento");

    companion object {
        fun toEnum(descricao: String) : EnumTipo {
            return values().first { it.descricao == descricao }
        }
    }
}