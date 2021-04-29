package com.github.fabriciolfj.productservice.core.service

import com.github.fabriciolfj.productservice.core.domain.Category
import com.github.fabriciolfj.productservice.core.domain.Product
import com.github.fabriciolfj.productservice.core.exceptions.CategoryNotFoundException
import com.github.fabriciolfj.productservice.core.ports.`in`.CategoryIn
import com.github.fabriciolfj.productservice.core.ports.out.CategoryPersistenceOut
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CategoryService : CategoryIn {

    @Autowired
    lateinit var categoryPersistenceOut: CategoryPersistenceOut

    override fun save(category: Category): Category {
        var entity = categoryPersistenceOut.findCategoryName(category.name)
        entity?: categoryPersistenceOut.save(category)
        return category;
    }

    override fun findCategory(name: String): Category? {
        return categoryPersistenceOut.findCategoryName(name)
            ?: throw CategoryNotFoundException("Category not found $name")
    }

    fun findProducts(category: String) : List<Product> {
        return categoryPersistenceOut.findProducts(category)
    }


}