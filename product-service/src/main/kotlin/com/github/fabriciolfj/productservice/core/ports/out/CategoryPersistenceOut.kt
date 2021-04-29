package com.github.fabriciolfj.productservice.core.ports.out

import com.github.fabriciolfj.productservice.core.domain.Category
import com.github.fabriciolfj.productservice.core.domain.Product

interface CategoryPersistenceOut {

    fun save(category: Category) : Category

    fun findCategoryName(name: String) : Category?

    fun findProducts(name: String) : List<Product>
}