package ar.edu.unq.eperdemic.services

import ar.edu.unq.eperdemic.modelo.Especie
import ar.edu.unq.eperdemic.modelo.Patogeno

interface PatogenoService {
    fun crearPatogeno(patogeno: Patogeno): Int
    fun getPatogeno(id: Int): Patogeno
    fun getAllPatogenos(): List<Patogeno>
    fun agregarEspecie(id: Int, nombreEspecie: String, paisDeOrigen : String) : Especie
}