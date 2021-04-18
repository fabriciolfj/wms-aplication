package com.github.fabriciolfj.productservice.adapters.`in`.product.api

import com.github.fabriciolfj.productservice.adapters.`in`.product.dto.ProductRequest
import com.github.fabriciolfj.productservice.adapters.`in`.product.dto.ProductResponse
import com.github.fabriciolfj.productservice.adapters.`in`.product.mapper.ProductMapper
import com.github.fabriciolfj.productservice.core.ports.`in`.ProductIn
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/v1/products")
class ProductController {

    @Autowired
    lateinit var productIn: ProductIn
    @Autowired
    lateinit var productMapper: ProductMapper

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@Valid @RequestBody productRequest: ProductRequest) : ProductResponse {
        return productMapper.toDomain(productRequest)
            .apply { productIn.save(this, productRequest.category) }
            .let { productMapper.toResponse(it) }
    }
}