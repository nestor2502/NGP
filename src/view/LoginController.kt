package view

import tornadofx.*

class LoginController : Controller() {
    val loginScreen : LoginScreen by inject()
    val startingScreen : StartingScreen by inject()

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

    fun showStartingScreen(){
        loginScreen.replaceWith(startingScreen, sizeToScene = true, centerOnScreen = true)
    }

    fun tryLogin(username: String, password: String, remember: Boolean){
        runAsync {
            compruebaDatos()
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
                showStartingScreen()
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
    fun compruebaDatos(): Boolean = true

    companion object{
        val USERNAME = "username"
        val PASSWORD = "password"
    }
}