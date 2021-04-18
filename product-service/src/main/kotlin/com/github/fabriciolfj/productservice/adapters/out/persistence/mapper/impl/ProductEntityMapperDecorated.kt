package com.github.fabriciolfj.productservice.adapters.out.persistence.mapper.impl

import com.github.fabriciolfj.productservice.adapters.out.persistence.entity.ProductEntity
import com.github.fabriciolfj.productservice.adapters.out.persistence.entity.toEntityCategory
import com.github.fabriciolfj.productservice.adapters.out.persistence.mapper.ProductEntityMapper
import com.github.fabriciolfj.productservice.core.domain.Product
import org.springframework.beans.factory.annotation.Autowired

abstract class ProductEntityMapperDecorated : ProductEntityMapper {

    @Autowired
    lateinit var mapper: ProductEntityMapper

    override fun toEntity(product: Product): ProductEntity {
        var entity = mapper.toEntity(product)
        entity.category = toEntityCategory(product.category!!)
        return entity;
    }
}