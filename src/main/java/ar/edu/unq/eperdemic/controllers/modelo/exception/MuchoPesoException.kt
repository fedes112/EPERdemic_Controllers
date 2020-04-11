package ar.edu.unq.eperdemic.controllers.modelo.exception

import ar.edu.unq.eperdemic.controllers.modelo.Item
import ar.edu.unq.eperdemic.controllers.modelo.Personaje

class MuchoPesoException(private val personaje: Personaje, private val item: Item) :
    RuntimeException() {
    override val message: String
        get() = "El personaje [" + personaje + "] no puede recoger [" + item + "] porque cagar mucho peso ya"

    companion object {
        private const val serialVersionUID = 1L
    }

}