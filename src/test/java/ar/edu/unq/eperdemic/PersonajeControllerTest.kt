package ar.edu.unq.eperdemic


import ar.edu.unq.eperdemic.controllers.PersonajeControllerREST
import ar.edu.unq.eperdemic.model.dao.PersonajeDAO
import ar.edu.unq.eperdemic.model.modelo.Personaje
import ar.edu.unq.eperdemic.services.PersonajeService
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
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
@DataJpaTest
@RunWith(SpringRunner::class)
class PersonajeControllerTest {

    @Autowired
    private lateinit var personajeService: PersonajeService
    @Autowired
    private lateinit var personajeController: PersonajeControllerREST
    @Autowired
    private lateinit var personajeDAO: PersonajeDAO



    private lateinit var mockMvc: MockMvc
    private lateinit var objectMapper: ObjectMapper

    private lateinit var maguito: Personaje

    @Before
    fun setup() {
        this.mockMvc = standaloneSetup(this.personajeController).build()

        objectMapper = ObjectMapper()
        objectMapper.registerModule(Jdk8Module())
        objectMapper.registerModule(KotlinModule())

        maguito = Personaje("Maguito")
        maguito.pesoMaximo = 15
        maguito.vida = 198
    }

    @Test
    @Throws(Exception::class)
    fun createPersonajeAndReturnId() {
        val json = json(maguito)
        val maguitoId = postAndReturnId(json)
        val maguitoRetrieved = this.personajeService.findById(maguitoId)

        assertEqualsPersonaje(maguito, maguitoRetrieved)
    }

    @Test
    @Throws(Exception::class)
    fun givenIdReturnPersonaje() {
        val maguitoId = personajeService.create(maguito)
        val maguitoRetrieved = getById(maguitoId)

        assertEqualsPersonaje(maguito, maguitoRetrieved)
    }

    private fun assertEqualsPersonaje(maguito: Personaje, maguitoRetrieved: Personaje) {
        assertEquals(maguito.nombre, maguitoRetrieved.nombre)
        assertEquals(maguito.pesoMaximo, maguitoRetrieved.pesoMaximo)
        assertEquals(maguito.vida, maguitoRetrieved.vida)
    }

    @Throws(Exception::class)
    private fun postAndReturnId(json: String): Long {
        val mvcResult = performPost(json)
        return  mvcResult.response.contentAsString.toLong()
    }

    @Throws(Exception::class)
    private fun getById(id: Long): Personaje {
        val mvcResult = performGetById(id)
        return personaje(mvcResult)
    }

    @Throws(Exception::class)
    private fun performPost(json: String): MvcResult {
        return mockMvc.perform(post("/personaje").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isCreated).andReturn()
    }

    @Throws(Exception::class)
    private fun performGetById(id: Long): MvcResult {
        return mockMvc.perform(get("/personaje/" + id)).andExpect(status().isOk).andReturn()
    }

    @Throws(IOException::class)
    private fun personaje(mvcResult: MvcResult): Personaje {
        val retrievedCharString = mvcResult.response.contentAsString
        return objectMapper.readValue(retrievedCharString, Personaje::class.java)
    }

    @Throws(JsonProcessingException::class)
    private fun json(`object`: Any?): String {
        return objectMapper.writeValueAsString(`object`)
    }

}
