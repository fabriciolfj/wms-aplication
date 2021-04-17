package com.github.fabriciolfj.productservice.adapters.`in`.category.mapper

import com.github.fabriciolfj.productservice.adapters.`in`.category.dto.CategoryResponse
import com.github.fabriciolfj.productservice.adapters.`in`.category.dto.ProductsCategoryResponse
import com.github.fabriciolfj.productservice.core.domain.Category
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired

abstract class CategoryMapperDecorated: CategoryMapper {

    val logger = LoggerFactory.getLogger(CategoryMapperDecorated::class.java)

    @Autowired
    lateinit var categoryMapper: CategoryMapper

    override fun toResponse(category: Category): CategoryResponse {
        var response = CategoryResponse(category.name, category.products.map { ProductsCategoryResponse(it.name, it.code) }.toList())
        logger.info("Category response mapper: {}", response)
        return response
    }

}
