package tests


import org.junit.Assert
import org.junit.Test
import org.junit.Before
import code.Usuario

class UsuarioTest() {

    @Test
    fun datosNoValidos() {
        try {
            val usuario = Usuario("", "", "", "")
            assert(1 == 0)
        }catch(e: IllegalArgumentException){ }
    }

    @Test
    fun getNombre(){
        var user = Usuario("Angel","CNN","pemail@example.com","1234567P")
        assert(user.obtenNombre() == "Angel")
    }

    @Test
    fun setNombre(){
        var user = Usuario("Angel","CNN","pemail@example.com ","1234567P")
        user.cambiaNombre("otro")
        assert(user.obtenNombre() == "otro" )
    }

    @Test
    fun correoInvalido() {
        try {
            var user = Usuario("Angel", "CNN", "error", "1234567P")
            assert(1 == 0)
        }catch(e: IllegalArgumentException){ }
    }

    @Test
    fun usuarioInvalido(){
        try{
            var user = Usuario("Angel","!!!","prueba@gmail.com","1234567P")
            assert(1 == 0)
        }catch(e: IllegalArgumentException){ }
    }


}
