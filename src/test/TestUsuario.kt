package tests


import org.junit.Assert
import org.junit.Test
import code.Usuario

class UsuarioTest() {

    @Test
    fun datosNoValidos() {
        try {
            val usuario = Usuario("", "", "", "")
            assert(1 == 0)
        }catch(e: IllegalArgumentException){ }
    }
}
