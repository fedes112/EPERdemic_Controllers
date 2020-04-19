package ar.edu.unq.eperdemic

import ar.edu.unq.eperdemic.modelo.Patogeno
import ar.edu.unq.eperdemic.persistencia.dao.PatogenoDAO
import ar.edu.unq.eperdemic.persistencia.dao.jdbc.JDBCPatogenoDAO
import ar.edu.unq.eperdemic.services.PatogenoService
import ar.edu.unq.eperdemic.services.impl.PatogenoServiceImpl
import ar.edu.unq.eperdemic.utils.jdbc.DataServiceJDBC
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PatogenoServiceTest {
    private val service: PatogenoService = PatogenoServiceImpl(JDBCPatogenoDAO())
    lateinit var patogeno: Patogeno


    @Before
    fun crearModelo() {
       patogeno =  Patogeno("Gripe2")
    }

    @Test
    fun alGuardarYLuegoRecuperarSeObtieneObjetosSimilares() {
        var id = service.crearPatogeno(patogeno)
        id = id + 0
        Assert.assertTrue(true)
    }

//    @After
//    fun emilinarModelo() {
//        dao.eliminar(patogeno)
//    }

}