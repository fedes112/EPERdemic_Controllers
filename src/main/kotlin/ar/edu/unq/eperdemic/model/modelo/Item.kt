package ar.edu.unq.eperdemic.model.modelo

import java.io.Serializable

class Item(val nombre: String, val peso: Int) : Serializable {

    override fun toString(): String {
        return nombre
    }

}