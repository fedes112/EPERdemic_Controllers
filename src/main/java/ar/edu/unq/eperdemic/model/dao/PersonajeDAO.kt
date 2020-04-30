package ar.edu.unq.eperdemic.model.dao

import ar.edu.unq.eperdemic.model.modelo.Personaje
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.QueryByExampleExecutor


interface PersonajeDAO : JpaRepository<Personaje, Long>, QueryByExampleExecutor<Personaje> {

}