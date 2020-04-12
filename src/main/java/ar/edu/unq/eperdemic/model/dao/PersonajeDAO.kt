package ar.edu.unq.eperdemic.model.dao

import ar.edu.unq.eperdemic.model.modelo.Personaje

/**
 * Tiene la responsabilidad de guardar y recuperar personajes desde
 * el medio persistente
 */
interface PersonajeDAO {
    fun guardar(personaje: Personaje)
    fun recuperar(nombre: String): Personaje
    fun eliminar(personaje: Personaje)
}