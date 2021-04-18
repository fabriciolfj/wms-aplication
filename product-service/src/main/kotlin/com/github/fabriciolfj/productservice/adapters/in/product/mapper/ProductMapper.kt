package com.github.fabriciolfj.productservice.adapters.`in`.product.mapper

import com.github.fabriciolfj.productservice.adapters.`in`.product.dto.ProductRequest
import com.github.fabriciolfj.productservice.adapters.`in`.product.dto.ProductResponse
import com.github.fabriciolfj.productservice.core.domain.Product
import org.mapstruct.*


@Mapper(componentModel = "spring")
@DecoratedWith(ProductMapperDecorated::class)
interface ProductMapper {

    @Mappings(
        Mapping(target = "category", ignore = true),
        Mapping(target = "code", ignore = true)
    )
    fun toDomain(request: ProductRequest) : Product

    fun toResponse(product: Product) : ProductResponse

}