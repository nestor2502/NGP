package NGP.tests


import org.junit.jupiter.api.Assert
import org.junit.jupiter.api.Test
import NGP.code.Usuario

class UsuarioTest() {

    @Test
    fun datosNoValidos(){
        try {
            val usuario = Usuario("", "", "", "")
            fail()
        }catch (){}
    }


}
