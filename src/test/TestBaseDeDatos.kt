package test

import org.jetbrains.exposed.dao.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.Test
import code.BaseDeDatos
import code.Usuario

class TestBaseDeDatos {

    @Test
    fun testAgregaUsuario(){
        val bdd = BaseDeDatos("./src/resources/database/test")
        bdd.agregaUsuario(Usuario("Angel","ACPN","@.","jkfsa"))
    }
}
