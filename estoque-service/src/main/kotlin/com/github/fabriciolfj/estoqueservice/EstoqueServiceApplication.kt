package com.github.fabriciolfj.estoqueservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EstoqueServiceApplication

fun main(args: Array<String>) {
	runApplication<EstoqueServiceApplication>(*args)
}
