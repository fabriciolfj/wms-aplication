package com.github.fabriciolfj.productservice.adapters.out.persistence.adapter

import com.github.fabriciolfj.productservice.adapters.out.persistence.mapper.CategoryEntityMapper
import com.github.fabriciolfj.productservice.adapters.out.persistence.repository.CategoryRepository
import com.github.fabriciolfj.productservice.core.domain.Category
import com.github.fabriciolfj.productservice.core.ports.out.CategoryPersistenceOut
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.lang.RuntimeException
import java.util.*

@Component
class CategoryPersistenceAdapter : CategoryPersistenceOut {

    val logger = LoggerFactory.getLogger(CategoryPersistenceAdapter::class.java)

    @Autowired
    lateinit var categoryRepository: CategoryRepository
    @Autowired
    lateinit var mapper: CategoryEntityMapper

    override fun save(category: Category): Category {
        val entity = mapper.toEntity(category)
        logger.info("Save category: {}", entity)
        return mapper.toDomain(categoryRepository.save(entity))
    }

    override fun findCategoryName(name: String): Category? {
        return categoryRepository.findByDescription(name)
            .map { mapper.toDomain(it) }
            .orElseGet { null }
    }

}