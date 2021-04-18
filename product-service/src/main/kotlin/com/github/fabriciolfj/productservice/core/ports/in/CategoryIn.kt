package com.github.fabriciolfj.productservice.core.ports.`in`

import com.github.fabriciolfj.productservice.core.domain.Category

interface CategoryIn {

    fun save(category: Category) : Category

    fun findCategory(name: String) : Category
}