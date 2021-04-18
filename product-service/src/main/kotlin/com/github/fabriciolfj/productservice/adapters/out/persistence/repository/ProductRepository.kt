package com.github.fabriciolfj.productservice.adapters.out.persistence.repository

import com.github.fabriciolfj.productservice.adapters.out.persistence.entity.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProductRepository : JpaRepository<ProductEntity, Long> {

    fun findByCode(code: String) : Optional<ProductEntity>
}