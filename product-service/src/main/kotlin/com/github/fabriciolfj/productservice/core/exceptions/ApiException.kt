package com.github.fabriciolfj.productservice.core.exceptions

import com.github.fabriciolfj.productservice.core.exceptions.dto.ErrosDTO
import com.github.fabriciolfj.productservice.core.exceptions.dto.Problem
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

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
        return handleValidationInternal(ex, ex.bindingResult, headers, status, request)
    }

    private fun handleValidationInternal(ex: Exception, bindingResult: BindingResult, headers: HttpHeaders, status: HttpStatus, webRequest: WebRequest): ResponseEntity<Any> {
        var problemObjects =
            bindingResult
                .allErrors
                .map {
                    val message = messageSource.getMessage(it, LocaleContextHolder.getLocale())
                    var name = "indefinido"
                    if (it is FieldError) {
                        name = (it.objectName as? FieldError)!!.field
                    }

                    ErrosDTO(name, message)
                }.toList()

        var problem = Problem("Falha ao requisitar o serviço", status.value(), problemObjects)
        return super.handleExceptionInternal(ex, problem, headers, status, webRequest)
    }
}