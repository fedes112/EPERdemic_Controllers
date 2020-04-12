package ar.edu.unq.eperdemic.controllers.advisers

import ar.edu.unq.eperdemic.controllers.PersonajeControllerREST
import ar.edu.unq.eperdemic.services.PersonajeNotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.http.HttpStatus.NOT_FOUND


@ControllerAdvice(assignableTypes = [PersonajeControllerREST::class])
class ParsonageControllerAdviser : GeneralControllerAdviser() {
    @ExceptionHandler(PersonajeNotFoundException::class)
    fun handleEventNotFoundException(e : PersonajeNotFoundException) : ResponseEntity<String> {
        return error(NOT_FOUND, e);
    }

}
