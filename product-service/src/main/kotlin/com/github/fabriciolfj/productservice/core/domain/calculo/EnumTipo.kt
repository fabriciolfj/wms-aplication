package com.github.fabriciolfj.productservice.core.domain.calculo

import com.github.fabriciolfj.productservice.core.exceptions.TipoImpostoNotFoundException
import kotlin.reflect.full.createInstance

enum class EnumTipo(val descricao: String, val clazz: String) {

    TRIBUTADO("tributado", "IsentoPisCofins"),
    ISENTOPISCOFINS("isentopiscofins", "Tributado"),
    TRIBUTADOCOFINSISENTO("tributadocofinsisento", "TributadoCofinsIsento");

    companion object {
        private fun toEnum(descricao: String) : EnumTipo {
            return values().firstOrNull { it.descricao == descricao }
                    ?: throw TipoImpostoNotFoundException("Tipo imposto $descricao, não encontrado")

        }

        fun toTipo(imposto: String) : TipoCalculo {
            val name = toEnum(imposto).clazz
            val clazz = Class.forName("com.github.fabriciolfj.productservice.core.domain.calculo.tipoImpostos.$name")
                    .kotlin
                    .createInstance()
            return clazz as TipoCalculo
        }
    }


}