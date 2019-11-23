package view

import NGP.view.MainView
import code.Usuario
import code.BaseDeDatos
import tornadofx.*

class LoginController : Controller() {
    val loginScreen : LoginScreen by inject()
    val startingScreen : StartingScreen by inject()
    val mainView : MainView by inject()

    fun init(){
        with(config){
            if(containsKey(USERNAME) && containsKey(PASSWORD))
                tryLogin(string(USERNAME), string(PASSWORD), true)
            else
                showStartingScreen()
        }
    }
    fun showLoginScreen(message: String){
        startingScreen.replaceWith(loginScreen,sizeToScene = true, centerOnScreen = true)
    }
    fun showMainView(){
        loginScreen.replaceWith(mainView,sizeToScene = true, centerOnScreen = true)
    }
    fun showStartingScreen(){
        loginScreen.replaceWith(startingScreen, sizeToScene = true, centerOnScreen = true)
    }

    fun tryLogin(username: String, password: String, remember: Boolean){
        runAsync {
            compruebaDatos(username,password)
        } ui { succesfulLogin ->

            if(succesfulLogin) {
                loginScreen.clear()

                if (remember){
                    with(config){
                        set(USERNAME to username)
                        set(PASSWORD to password)
                        save()
                    }
                }
                showMainView()
            } else {
                showLoginScreen("Login failed")
            }

        }
    }
    fun logout(){
        with(config){
            remove(USERNAME)
            remove(PASSWORD)
            save()
        }
        showLoginScreen("Log in as another user")
    }
    fun compruebaDatos(usuario: String,password: String): Boolean{
        val bdd = BaseDeDatos("./src/resources/database/usuarios")
        return bdd.encuentraUsuario(usuario,password)
    }

    companion object{
        val USERNAME = "username"
        val PASSWORD = "password"
    }
}