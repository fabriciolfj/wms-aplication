package com.github.fabriciolfj.productservice.adapters.out.persistence.repository

import com.github.fabriciolfj.productservice.adapters.out.persistence.entity.CategoryEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<CategoryEntity, Long>