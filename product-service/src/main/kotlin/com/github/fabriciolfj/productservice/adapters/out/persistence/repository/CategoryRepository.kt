package com.github.fabriciolfj.productservice.adapters.out.persistence.repository

import com.github.fabriciolfj.productservice.adapters.out.persistence.entity.CategoryEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CategoryRepository : JpaRepository<CategoryEntity, Long> {

    fun findByDescription(name: String) : Optional<CategoryEntity>
}