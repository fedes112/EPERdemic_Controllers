package ar.edu.unq.eperdemic.controllers.modelo

import java.io.Serializable

class Item(val nombre: String, val peso: Int) : Serializable {

    override fun toString(): String {
        return nombre
    }

}