package com.github.fabriciolfj.productservice.adapters.out.persistence.entity

import javax.persistence.*

@Entity
@Table(name = "CATEGORY")
data class CategoryEntity(
        @Id
        @Column(name = "ID", nullable = false)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?,
        @Column(name = "DESCRIPTION", nullable = false, unique = true)
        var description: String,
        @OneToMany(mappedBy = "category")
        var productEntities: List<ProductEntity>) {

        constructor() : this(null, "", emptyList())
}