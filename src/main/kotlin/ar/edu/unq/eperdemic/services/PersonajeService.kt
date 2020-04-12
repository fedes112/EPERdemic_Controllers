package ar.edu.unq.eperdemic.services

import ar.edu.unq.eperdemic.model.dao.PersonajeDAO
import ar.edu.unq.eperdemic.model.modelo.Personaje
import org.springframework.stereotype.Service

@Service
class PersonajeService(private val personajeDAO: PersonajeDAO) {
    fun create(personaje: Personaje) : String {
        personajeDAO.guardar(personaje)
        return personaje.nombre
    }

    fun findByName(name: String): Personaje {
        val personaje: Personaje? = personajeDAO.recuperar(name)
        return personaje ?: throw PersonajeNotFoundException(name)
    }

    fun deleteByName(name: String) {
        val personaje: Personaje? = personajeDAO.recuperar(name)
        personaje?.let {  personajeDAO.eliminar(it)} ?: throw PersonajeNotFoundException(name)
    }
}

class PersonajeNotFoundException(name: String) : RuntimeException("Event $name not found")
