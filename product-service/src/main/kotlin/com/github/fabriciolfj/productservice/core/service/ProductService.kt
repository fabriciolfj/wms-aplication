package com.github.fabriciolfj.productservice.core.service

import com.github.fabriciolfj.productservice.core.domain.Product
import com.github.fabriciolfj.productservice.core.ports.`in`.ProductIn
import com.github.fabriciolfj.productservice.core.ports.out.ProductPersistenceOut
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductService : ProductIn {

    @Autowired
    lateinit var productPersistenceOut: ProductPersistenceOut
    @Autowired
    lateinit var categoryService: CategoryService

    override fun save(product: Product, category: String) : Product {
        return product
            .apply {
                this.code = UUID.randomUUID().toString()
                this.category = categoryService.findCategory(category)
            }
            .let { productPersistenceOut.save(it) }
    }
}