package com.github.fabriciolfj.productservice.core.exceptions

import com.fasterxml.jackson.databind.JsonMappingException
import com.fasterxml.jackson.databind.exc.InvalidFormatException
import com.fasterxml.jackson.databind.exc.PropertyBindingException
import com.fasterxml.jackson.module.kotlin.MissingKotlinParameterException
import com.github.fabriciolfj.productservice.core.exceptions.dto.ErrosDTO
import com.github.fabriciolfj.productservice.core.exceptions.dto.Problem
import org.apache.commons.lang3.exception.ExceptionUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.stream.Collectors

@ControllerAdvice
class ApiException : ResponseEntityExceptionHandler() {

    @Autowired
    lateinit var messageSource: MessageSource

    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {
        return this.handleValidationInternal(ex, ex.bindingResult, headers, status, request)
    }

    @ExceptionHandler(ProductNotFoundException::class)
    fun productNotFound(ex: ProductNotFoundException) : ResponseEntity<Problem> {
        var error = Problem(ex.message!!, HttpStatus.BAD_REQUEST.value())
        return ResponseEntity.badRequest().body(error)
    }

    @ExceptionHandler(CategoryNotFoundException::class)
    fun categoryNotFound(ex: CategoryNotFoundException) : ResponseEntity<Problem> {
        var error = Problem(ex.message!!, HttpStatus.BAD_REQUEST.value())
        return ResponseEntity.badRequest().body(error)
    }

    override fun handleHttpMessageNotReadable(ex: HttpMessageNotReadableException, headers: HttpHeaders, status: HttpStatus, request: WebRequest): ResponseEntity<Any> {
        val rootCause = ExceptionUtils.getRootCause(ex)

        if (rootCause is InvalidFormatException) {
            return handleInvalidFormatException(rootCause, headers, status, request)
        }

        if (rootCause is PropertyBindingException) {
            return handlePropertyException(rootCause, headers, status, request)
        }

        var error = Problem("Corpo da requisição está inválida", HttpStatus.BAD_REQUEST.value())
        return handleExceptionInternal(ex, error, HttpHeaders(), status, request)
    }

    private fun handlePropertyException(e: PropertyBindingException, headers: HttpHeaders, status: HttpStatus, request: WebRequest): ResponseEntity<Any> {
        val path = e.path.stream().map { ex: JsonMappingException.Reference -> ex.fieldName }.collect(Collectors.joining("."))
        val detail = "A propriedade $path, encontra-se ignorada ou não existe no objeto correspondente."
        var error = Problem(detail, HttpStatus.BAD_REQUEST.value())

        return handleExceptionInternal(e, error, headers, status, request)
    }

    private fun handleInvalidFormatException(e: InvalidFormatException, headers: HttpHeaders, status: HttpStatus, request: WebRequest): ResponseEntity<Any> {
        val path = e.path.stream().map { m: JsonMappingException.Reference -> m.fieldName }.collect(Collectors.joining("."))
        val detail = "A propriedade $path recebeu o valor $e.value, que é um tipo inválido. Corrija e informe um valor compátivel com o tipo ${e.targetType.simpleName}."
        val problem = Problem(detail, HttpStatus.BAD_REQUEST.value())
        return handleExceptionInternal(e, problem, headers, status, request)
    }

    private fun handleValidationInternal(ex: Exception, bindingResult: BindingResult, headers: HttpHeaders, status: HttpStatus, webRequest: WebRequest): ResponseEntity<Any> {
        var problemObjects =
            bindingResult
                .allErrors
                .map {
                    val message = messageSource.getMessage(it, LocaleContextHolder.getLocale())
                    var name = "indefinido"
                    if (it is FieldError) {
                        name = it.field
                    }

                    ErrosDTO(name, message)
                }.toList()

        var problem = Problem("Falha ao requisitar o serviço", status.value(), problemObjects)
        return super.handleExceptionInternal(ex, problem, headers, status, webRequest)
    }
}