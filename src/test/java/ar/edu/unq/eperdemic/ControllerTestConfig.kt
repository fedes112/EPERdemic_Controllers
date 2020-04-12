package ar.edu.unq.eperdemic

import ar.edu.unq.eperdemic.controllers.PersonajeControllerREST
import ar.edu.unq.eperdemic.model.dao.PersonajeDAO
import ar.edu.unq.eperdemic.model.dao.impl.JDBCPersonajeDAO
import ar.edu.unq.eperdemic.services.PersonajeService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class ControllerTestConfig {


    @Bean
    fun personajeDAO(): PersonajeDAO {
        return JDBCPersonajeDAO()
    }

    @Bean
    fun personajeService(personajeDAO : PersonajeDAO): PersonajeService {
        return PersonajeService(personajeDAO)
    }

    @Bean
    fun personajeController(personajeService : PersonajeService): PersonajeControllerREST {
        return PersonajeControllerREST(personajeService)
    }
}

