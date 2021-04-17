package com.github.fabriciolfj.productservice.adapters.`in`.category.mapper

import com.github.fabriciolfj.productservice.adapters.`in`.category.dto.CategoryRequest
import com.github.fabriciolfj.productservice.adapters.`in`.category.dto.CategoryResponse
import com.github.fabriciolfj.productservice.core.domain.Category
import org.mapstruct.*

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
@DecoratedWith(CategoryMapperDecorated::class)
interface CategoryMapper {

    @Mappings(
        Mapping(target = "products", ignore = true),
        Mapping(source = "description", target = "name"))
    fun toDomain(categoryRequest: CategoryRequest): Category

    @Mapping(target = "products", ignore = true)
    fun toResponse(category: Category): CategoryResponse
}