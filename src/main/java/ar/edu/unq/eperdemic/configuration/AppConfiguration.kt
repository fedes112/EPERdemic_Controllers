package ar.edu.unq.eperdemic.configuration

import ar.edu.unq.eperdemic.model.dao.PersonajeDAO
import ar.edu.unq.eperdemic.model.dao.impl.JDBCPersonajeDAO
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfiguration {

    @Bean
    fun personajeDao(): PersonajeDAO {
        return JDBCPersonajeDAO()
    }

}
