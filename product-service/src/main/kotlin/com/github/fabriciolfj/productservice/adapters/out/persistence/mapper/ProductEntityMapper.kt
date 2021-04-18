package com.github.fabriciolfj.productservice.adapters.out.persistence.mapper

import com.github.fabriciolfj.productservice.adapters.out.persistence.entity.ProductEntity
import com.github.fabriciolfj.productservice.adapters.out.persistence.mapper.impl.ProductEntityMapperDecorated
import com.github.fabriciolfj.productservice.core.domain.Product
import org.mapstruct.DecoratedWith
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper(componentModel = "spring")
@DecoratedWith(ProductEntityMapperDecorated::class)
interface ProductEntityMapper {

    @Mappings(
     Mapping(target = "id", ignore = true),
     Mapping(target = "category", ignore = true)
    )
    fun toEntity(product: Product) : ProductEntity

    fun toDomain(productEntity: ProductEntity) : Product
}