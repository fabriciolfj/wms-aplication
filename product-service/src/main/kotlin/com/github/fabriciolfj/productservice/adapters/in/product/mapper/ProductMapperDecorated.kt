package com.github.fabriciolfj.productservice.adapters.`in`.product.mapper

import com.github.fabriciolfj.productservice.adapters.`in`.product.dto.ProductResponse
import com.github.fabriciolfj.productservice.core.domain.Product

abstract class ProductMapperDecorated : ProductMapper {

    override fun toResponse(product: Product): ProductResponse {
        return ProductResponse(product.name, product.code, product.category!!.id)
    }

}
