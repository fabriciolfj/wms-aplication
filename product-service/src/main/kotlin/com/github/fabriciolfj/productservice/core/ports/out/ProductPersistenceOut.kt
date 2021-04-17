package com.github.fabriciolfj.productservice.core.ports.out

import com.github.fabriciolfj.productservice.core.domain.Product

interface ProductPersistenceOut {

    fun save(product: Product) : Product
}