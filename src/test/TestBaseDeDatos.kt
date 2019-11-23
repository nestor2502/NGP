package test

import org.jetbrains.exposed.dao.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.Test
import code.BaseDeDatos
import code.Usuario
import org.junit.Assert
import java.lang.IllegalArgumentException

class TestBaseDeDatos {

    @Test
    fun testAgregaUsuarioRepetido(){
        val bdd = BaseDeDatos("./src/resources/database/test")
        try {
            bdd.agregaUsuario(Usuario("Angel", "ACPN", "@.", "jkfsa"))
            assert(1 == 0)
        }catch(e : IllegalArgumentException){
        }
    }
}
