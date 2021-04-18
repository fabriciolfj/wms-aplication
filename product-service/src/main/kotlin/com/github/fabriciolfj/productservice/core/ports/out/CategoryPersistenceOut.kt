package com.github.fabriciolfj.productservice.core.ports.out

import com.github.fabriciolfj.productservice.core.domain.Category

interface CategoryPersistenceOut {

    fun save(category: Category) : Category

    fun findCategoryName(name: String) : Category
}