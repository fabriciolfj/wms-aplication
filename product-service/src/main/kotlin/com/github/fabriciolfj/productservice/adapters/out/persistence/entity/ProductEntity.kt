package com.github.fabriciolfj.productservice.adapters.out.persistence.entity

import java.math.BigDecimal
import javax.persistence.*


@Entity
@Table(name = "PRODUCT")
data class ProductEntity(
        @Id
        @Column(name = "id", nullable = false)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?,
        @Column(name = "NAME", nullable = false)
        var name: String,
        @Column(name = "CODE", nullable = false)
        var code: String,
        @JoinColumn(name = "CATEGORY_ID")
        @ManyToOne
        var category: CategoryEntity?,
        var imposto: BigDecimal) {

        constructor() : this(null, "", "", null, BigDecimal.ZERO)
}
