package ar.edu.unq.eperdemic.controllers

import ar.edu.unq.eperdemic.model.modelo.Personaje
import ar.edu.unq.eperdemic.services.PersonajeService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@ServiceREST
@RequestMapping("/personaje")
class PersonajeControllerREST(private val personajeService: PersonajeService) {

  @PostMapping
  fun create(@RequestBody personaje: Personaje): ResponseEntity<Long> {
    val personajeId= personajeService.create(personaje)
    return ResponseEntity<Long>(personajeId, HttpStatus.CREATED)
  }

  @GetMapping("/{id}")
  fun findByName(@PathVariable id: Long) = personajeService.findById(id)

  @DeleteMapping("/{id}")
  fun deleteByName(@PathVariable id: Long){
    Optional.ofNullable(personajeService.findById(id))
    personajeService.deleteById(id)
  }

}