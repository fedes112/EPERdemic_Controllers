package ar.edu.unq.eperdemic

import ar.edu.unq.eperdemic.controllers.PersonajeControllerREST
import ar.edu.unq.eperdemic.model.dao.PersonajeDAO
import ar.edu.unq.eperdemic.model.modelo.Personaje
import ar.edu.unq.eperdemic.services.PersonajeService
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup
import java.io.IOException

@ContextConfiguration(classes = [ControllerTestConfig::class])
@RunWith(SpringRunner::class)
class PersonajeControllerTest {

    @Test
    fun contextLoads() {
    }
//    @Autowired
//    private lateinit var personajeService: PersonajeService
//    @Autowired
//    private lateinit var personajeController: PersonajeControllerREST
//    @Autowired
//    private lateinit var personajeDAO: PersonajeDAO
//
//
//
//    private lateinit var mockMvc: MockMvc
//    private lateinit var objectMapper: ObjectMapper
//
//    private lateinit var maguito: Personaje
//
//    @Before
//    fun setup() {
//        this.mockMvc = standaloneSetup(this.personajeController).build()
//
//        objectMapper = ObjectMapper()
//        objectMapper.registerModule(Jdk8Module())
//        objectMapper.registerModule(KotlinModule())
//
//        maguito = Personaje("Maguito")
//        maguito.pesoMaximo = 15
//        maguito.vida = 198
//        maguito.xp = 2500
//    }
//
//    @Test
//    @Throws(Exception::class)
//    fun createPersonajeAndReturnId() {
//        val json = json(maguito)
//        val maguitoName = postAndReturnName(json)
//        val maguitoRetrieved = this.personajeService.findByName(maguitoName)
//
//        assertEqualsPersonaje(maguito, maguitoRetrieved)
//    }
//
//    @Test
//    @Throws(Exception::class)
//    fun givenIdReturnPersonaje() {
//        val maguitoName = personajeService.create(maguito)
//        val maguitoRetrieved = getByName(maguitoName)
//
//        assertEqualsPersonaje(maguito, maguitoRetrieved)
//    }
//
//    private fun assertEqualsPersonaje(maguito: Personaje, maguitoRetrieved: Personaje) {
//        assertEquals(maguito.nombre, maguitoRetrieved.nombre)
//        assertEquals(maguito.pesoMaximo, maguitoRetrieved.pesoMaximo)
//        assertEquals(maguito.vida, maguitoRetrieved.vida)
//        assertEquals(maguito.xp, maguitoRetrieved.xp)
//    }
//
//    @Throws(Exception::class)
//    private fun postAndReturnName(json: String): String {
//        val mvcResult = performPost(json)
//        return mvcResult.response.contentAsString
//    }
//
//    @Throws(Exception::class)
//    private fun getByName(maguitoName: String): Personaje {
//        val mvcResult = performGetByName(maguitoName)
//        return personaje(mvcResult)
//    }
//
//    @Throws(Exception::class)
//    private fun performPost(json: String): MvcResult {
//        return mockMvc.perform(post("/personaje").contentType(MediaType.APPLICATION_JSON).content(json))
//                .andExpect(status().isCreated).andReturn()
//    }
//
//    @Throws(Exception::class)
//    private fun performGetByName(maguitoName: String): MvcResult {
//        return mockMvc.perform(get("/personaje/" + maguitoName)).andExpect(status().isOk).andReturn()
//    }
//
//    @Throws(IOException::class)
//    private fun personaje(mvcResult: MvcResult): Personaje {
//        val retrievedCharString = mvcResult.response.contentAsString
//        return objectMapper.readValue(retrievedCharString, Personaje::class.java)
//    }
//
//    @Throws(JsonProcessingException::class)
//    private fun json(`object`: Any?): String {
//        return objectMapper.writeValueAsString(`object`)
//    }
//
//    @After
//    fun emilinarModelo() {
//        personajeDAO.eliminar(maguito)
//    }

}
