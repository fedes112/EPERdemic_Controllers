package ar.edu.unq.eperdemic.persistencia.dao.jdbc


import ar.edu.unq.eperdemic.modelo.Patogeno
import ar.edu.unq.eperdemic.persistencia.dao.PatogenoDAO
import ar.edu.unq.eperdemic.persistencia.dao.jdbc.JDBCConnector.execute
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.Statement


class JDBCPatogenoDAO : PatogenoDAO {

    override fun crear(patogeno: Patogeno): Int {
        return execute { conn: Connection ->
            val ps =
                    conn.prepareStatement("INSERT INTO patogeno(tipo, cantidadDeEspecies) VALUES (?,?)",
                            Statement.RETURN_GENERATED_KEYS)
            ps.setString(1, patogeno.tipo)
            ps.setInt(2, patogeno.cantidadDeEspecies)
            ps.execute()
            val generatedKeys = ps.getGeneratedKeys()
            if (ps.updateCount != 1) {
                throw RuntimeException("No se inserto el patogeno $patogeno")
            }
            var id = 0
            if (generatedKeys.next()){
                id = generatedKeys.getInt(1) }
            ps.close()
            id
        }
    }

    override fun actualizar(patogeno: Patogeno) {
        TODO("not implemented")
    }

    override fun recuperar(patogenoId: Int): Patogeno {
        TODO("not implemented")
    }

    override fun recuperarATodos(): List<Patogeno> {
        return execute {conn:Connection ->
            val ps =
                     conn.prepareStatement("SELECT tipo, cantidadDeEspecies FROM patogeno ")
            val resultSet = ps.executeQuery()
            val lista = mutableListOf<Patogeno>()
            while (resultSet.next()){
                val patogeno = Patogeno(resultSet.getString("tipo"))
//                settear cant
                lista.add(patogeno) }
            ps.close()
            lista
        }
    }

    init {
        val initializeScript = javaClass.classLoader.getResource("createAll.sql").readText()
        execute {
            val ps = it.prepareStatement(initializeScript)
            ps.execute()
            ps.close()
            null
        }
    }
}