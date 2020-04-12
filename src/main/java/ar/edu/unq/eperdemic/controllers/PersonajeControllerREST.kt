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
  fun create(@RequestBody personaje: Personaje): ResponseEntity<String> {
    val personajeName= personajeService.create(personaje)
    return ResponseEntity<String>(personajeName, HttpStatus.CREATED)
  }

  @GetMapping("/{name}")
  fun findByName(@PathVariable name: String) = personajeService.findByName(name)

  @DeleteMapping("/{name}")
  fun deleteByName(@PathVariable name: String){
    Optional.ofNullable(personajeService.findByName(name))
    personajeService.deleteByName(name)
  }

}