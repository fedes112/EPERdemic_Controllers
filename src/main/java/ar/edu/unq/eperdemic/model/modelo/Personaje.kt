package ar.edu.unq.eperdemic.model.modelo

import ar.edu.unq.eperdemic.model.modelo.exception.MuchoPesoException
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import java.io.Serializable
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
class Personaje(val nombre: String) : Serializable {
    var pesoMaximo = 0
    var xp = 0
    var vida = 0
    @JsonIgnore
    var inventario: MutableSet<Item> = HashSet()


    fun recoger(item: Item) {
        val pesoActual = pesoActual
        if (pesoActual + item.peso > pesoMaximo) {
            throw MuchoPesoException(this, item)
        }
        inventario.add(item)
    }

    @get:JsonIgnore
    val pesoActual: Int
        get() {
            var pesoActual = 0
            for (item in inventario) {
                pesoActual += item.peso
            }
            return pesoActual
        }

    override fun toString(): String {
        return nombre
    }

}