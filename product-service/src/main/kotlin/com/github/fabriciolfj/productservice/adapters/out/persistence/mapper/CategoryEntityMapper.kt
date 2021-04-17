package com.github.fabriciolfj.productservice.adapters.out.persistence.mapper

import com.github.fabriciolfj.productservice.adapters.out.persistence.entity.CategoryEntity
import com.github.fabriciolfj.productservice.core.domain.Category
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper(componentModel = "spring")
interface CategoryEntityMapper {

    @Mappings(
        Mapping(target = "productEntities", ignore = true),
        Mapping(target = "description", source = "name")
    )
    fun toEntity(category: Category) : CategoryEntity

    fun toDomain(categoryEntity: CategoryEntity) : Category
}