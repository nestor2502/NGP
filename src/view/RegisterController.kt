package view

import tornadofx.*
import code.Usuario
import code.BaseDeDatos

class RegisterController : Controller() {

    val registerScreen: RegisterScreen by inject()
    val startingScreen: StartingScreen by inject()

    fun init() {
        showRegisterScreen("Registrate!")
    }

    fun showRegisterScreen(message: String) {
        startingScreen.replaceWith(registerScreen, sizeToScene = true, centerOnScreen = true)
    }

    fun showStartingScreen(message: String) {
        registerScreen.replaceWith(startingScreen, sizeToScene = true, centerOnScreen = true)
    }

    fun tryRegister(usuario: String, password: String, correo: String, nombre: String) {
        runAsync {
            compruebaDatos(usuario,password,correo,nombre)
        } ui { succesfulRegister ->

            if(succesfulRegister){
                showStartingScreen("Registro Exitoso")
                registerScreen.clear()
            }else{
                showRegisterScreen("Intentelo de nuevo")
            }

        }
    }

    fun compruebaDatos(usuario: String, password: String, correo: String, nombre: String):Boolean{
        try {
            val nuevo = Usuario(nombre, usuario, correo, password)
            val dbb = BaseDeDatos("./src/resources/database/usuarios")
            dbb.agregaUsuario(nuevo)
            return true
        } catch (e: IllegalArgumentException) {
            return false
        }
    }
}