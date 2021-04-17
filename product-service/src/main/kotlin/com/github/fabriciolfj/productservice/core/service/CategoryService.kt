package com.github.fabriciolfj.productservice.core.service

import com.github.fabriciolfj.productservice.core.domain.Category
import com.github.fabriciolfj.productservice.core.ports.`in`.CategoryIn
import com.github.fabriciolfj.productservice.core.ports.out.CategoryPersistenceOut
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CategoryService : CategoryIn {

    @Autowired
    lateinit var categoryPersistenceOut: CategoryPersistenceOut

    override fun save(category: Category): Category {
        return categoryPersistenceOut.save(category)
    }
}