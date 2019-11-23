package code

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.dao.*
import code.Usuario
import org.jetbrains.exposed.exceptions.ExposedSQLException
import java.net.PasswordAuthentication

class BaseDeDatos(private var directorio: String){
    init {
        Database.connect("jdbc:h2:file:$directorio;DB_CLOSE_DELAY=-1;",
                "org.h2.Driver")
    }
    object Users : IntIdTable(){
        var usuario = varchar("usuario", length = 50).uniqueIndex()
        var password = varchar("password", length = 50)
        var nombre = varchar("nombre", length = 50)
        var historial = varchar("historial", length = 500)
        var saldo = integer("saldo")
    }
    class User(id: EntityID<Int>): IntEntity(id){
        companion object : IntEntityClass<User>(Users)

        var usuario by Users.usuario
        var password by Users.password
        var nombre by Users.nombre
        var historial by Users.historial
        var saldo by Users.saldo
    }
    fun agregaUsuario(us : Usuario){
        try {
            transaction     {
                SchemaUtils.create(Users)
                    User.new {
                        usuario = us.getUsuario()
                        password = us.getPassword()
                        nombre = us.getNombre()
                        historial = us.getHistorial()
                        saldo = us.getSaldo()
                    }
            }
        }catch (e: ExposedSQLException){
            throw IllegalArgumentException("Usuario Repetido")
        }
    }
    fun encuentraUsuario(us: String,password: String): Boolean{
        return true
    }
}