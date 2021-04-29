package com.github.fabriciolfj.productservice.adapters.out.persistence.adapter

import com.github.fabriciolfj.productservice.adapters.out.persistence.mapper.CategoryEntityMapper
import com.github.fabriciolfj.productservice.adapters.out.persistence.mapper.ProductEntityMapper
import com.github.fabriciolfj.productservice.adapters.out.persistence.repository.CategoryRepository
import com.github.fabriciolfj.productservice.core.domain.Category
import com.github.fabriciolfj.productservice.core.domain.Product
import com.github.fabriciolfj.productservice.core.exceptions.CategoryNotFoundException
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
    @Autowired
    lateinit var productMapper : ProductEntityMapper

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

    override fun findProducts(name: String): List<Product> {
         val category = categoryRepository.findByDescription(name)
             .orElseThrow { CategoryNotFoundException("Categoria não encontrada $name") }
        return category.productEntities.map { productMapper.toDomain(it) }
            .toList()
    }

}