package com.github.fabriciolfj.productservice.core.service

import com.github.fabriciolfj.productservice.core.domain.Product
import com.github.fabriciolfj.productservice.core.domain.calculo.Calculo
import com.github.fabriciolfj.productservice.core.domain.calculo.TipoCalculo
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
    @Autowired
    lateinit var calculo: Calculo

    override fun save(product: Product, category: String, imposto: String) : Product {
        return product
            .apply {
                this.imposto = calculo.createImposto(TipoCalculo.toEnum(imposto), product.price)
                this.code = UUID.randomUUID().toString()
                this.category = categoryService.findCategory(category)
            }
            .let { productPersistenceOut.save(it) }
    }
}