package ar.edu.unq.eperdemic.services

import ar.edu.unq.eperdemic.model.dao.PersonajeDAO
import ar.edu.unq.eperdemic.model.modelo.Personaje
import org.springframework.stereotype.Service

@Service
class PersonajeService(private val personajeDAO: PersonajeDAO) {
    fun create(personaje: Personaje) : Long {
        personajeDAO.save(personaje)
        return personaje.id!!
    }

    fun findById(id: Long): Personaje {
        val personaje: Personaje? = personajeDAO.getOne(id)
        return personaje ?: throw PersonajeNotFoundException(id)
    }

    fun deleteById(id: Long) {
        val personaje: Personaje? = personajeDAO.getOne(id)
        personaje?.let {  personajeDAO.delete(it)} ?: throw PersonajeNotFoundException(id)
    }
}

class PersonajeNotFoundException(id: Long) : RuntimeException("Personaje $id not found")
