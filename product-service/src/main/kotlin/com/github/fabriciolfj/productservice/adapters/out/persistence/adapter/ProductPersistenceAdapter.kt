package com.github.fabriciolfj.productservice.adapters.out.persistence.adapter

import com.github.fabriciolfj.productservice.adapters.out.persistence.mapper.ProductEntityMapper
import com.github.fabriciolfj.productservice.adapters.out.persistence.repository.ProductRepository
import com.github.fabriciolfj.productservice.core.domain.Product
import com.github.fabriciolfj.productservice.core.ports.out.ProductPersistenceOut
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ProductPersistenceAdapter : ProductPersistenceOut{

    val logger = LoggerFactory.getLogger(ProductPersistenceAdapter::class.java)

    @Autowired
    lateinit var productRepository: ProductRepository
    @Autowired
    lateinit var productEntityMapper: ProductEntityMapper

    override fun save(product: Product) : Product {
        return productEntityMapper.toEntity(product)
            .apply {
                logger.info("Product create: {}", this)
                productRepository.save(this)
            }
            .let { productEntityMapper.toDomain(it) }
    }
}