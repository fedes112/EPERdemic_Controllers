package ar.edu.unq.eperdemic.model.modelo

import com.fasterxml.jackson.annotation.JsonInclude
import javax.persistence.*

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
class Personaje() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    @Column(nullable = false, length = 500)
    var nombre: String? = null
    var vida: Int = 0
    var pesoMaximo: Int = 0



    constructor(nombre: String) : this() {
        this.nombre = nombre
    }



    override fun toString(): String {
        return nombre!!
    }

}