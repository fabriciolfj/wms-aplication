package com.github.fabriciolfj.productservice.core.exceptions

import java.lang.RuntimeException

class ProductNotFoundException(msg: String) : RuntimeException(msg)