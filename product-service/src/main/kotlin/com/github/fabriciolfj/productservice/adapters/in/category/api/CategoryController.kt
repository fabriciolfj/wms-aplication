package com.github.fabriciolfj.productservice.adapters.`in`.category.api

import com.github.fabriciolfj.productservice.adapters.`in`.category.dto.CategoryRequest
import com.github.fabriciolfj.productservice.adapters.`in`.category.dto.CategoryResponse
import com.github.fabriciolfj.productservice.adapters.`in`.category.mapper.CategoryMapper
import com.github.fabriciolfj.productservice.core.ports.`in`.CategoryIn
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/v1/category")
class CategoryController {

    @Autowired
    lateinit var categoryIn: CategoryIn

    @Autowired
    lateinit var mapper: CategoryMapper

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun save(@RequestBody @Valid request: CategoryRequest) : CategoryResponse {
        return mapper.toDomain(request)
                .apply { categoryIn.save(this) }
                .let { mapper.toResponse(it) }
    }
}