package com.github.fabriciolfj.productservice.adapters.out.persistence.mapper

import com.github.fabriciolfj.productservice.adapters.out.persistence.entity.ProductEntity
import com.github.fabriciolfj.productservice.core.domain.Product
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface ProductEntityMapper {

    @Mapping(target = "id", ignore = true)
    fun toEntity(product: Product) : ProductEntity

    fun toDomain(productEntity: ProductEntity) : Product
}