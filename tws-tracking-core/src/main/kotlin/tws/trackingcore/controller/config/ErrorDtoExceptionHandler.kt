package tws.trackingcore.controller.config

import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.ServletWebRequest
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import tws.tracking.lib.model.ErrorDto
import javax.servlet.http.HttpServletRequest


@ControllerAdvice
class ErrorDtoExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [DataIntegrityViolationException::class])
    protected fun handleHibernateErrors(
        ex: DataIntegrityViolationException, request: HttpServletRequest
    ): ResponseEntity<ErrorDto> {
        return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(
                ErrorDto(
                    HttpStatus.CONFLICT.value(), ex.javaClass.name,
                    request.servletPath, if (ex.message != null) ex.message!! else ""
                )
            )
    }

    /**
     * Customize the response for MethodArgumentNotValidException.
     * Extract all errors from bean validation and return a body with an instance of [ErrorDto]
     */
    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {
        fun extractErrors(): Map<String, String?> {
            val errors = mutableMapOf<String, String?>()
            ex.allErrors.forEach { error ->
                val fieldName = (error as FieldError).field
                val errorMessage = error.getDefaultMessage()
                errors[fieldName] = errorMessage
            }
            return errors
        }

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(
                ErrorDto(
                    HttpStatus.BAD_REQUEST.value(),
                    ex.javaClass.name,
                    (request as ServletWebRequest).request.contextPath + request.request.servletPath,
                    extractErrors().map { e -> e.key + ":" + (if (e.value != null) e.value else "") }
                        .joinToString(", ")
                )
            )
    }


}
