package com.github.fabriciolfj.productservice.core.ports.`in`

import com.github.fabriciolfj.productservice.core.domain.Product

interface ProductIn {

    fun save(product: Product, category: String, imposto: String) : Product

    fun findProduct(code: String) : Product

    fun listProductCategory(name: String): List<Product>
}