package NGP.view


import tornadofx.*
import view.LoginController
import view.LoginScreen
import view.StartingScreen

class AppController : Controller() {
    val loginScreen: LoginScreen by inject()
    val mainView: MainView by inject()
    val loginController: LoginController by inject()
    val tournamentView: TournamentView by inject()
    val startingScreen: StartingScreen by inject()

    fun init() {
        with(config) {
            showMainView()
        }
    }

    fun showHistoryInterface() {

    }

    fun showMainView() {
        loginScreen.replaceWith(mainView, sizeToScene = true, centerOnScreen = true)
    }

    fun showTournamentView() {
        mainView.replaceWith(tournamentView, sizeToScene = true, centerOnScreen = true)
    }

    fun tryLogin(username: String, password: String, remember: Boolean) {
        runAsync {
            username == "admin" && password == "secret"
        } ui { successfulLogin ->

            if (successfulLogin) {
                loginScreen.clear()

                if (remember) {
                    with(config) {
                        set(USERNAME to username)
                        set(PASSWORD to password)
                        save()
                    }
                }

                showMainView()
            } else {
                showStarterScreen()
            }
        }
    }

    fun showStarterScreen() {
        mainView.replaceWith(startingScreen, sizeToScene = true, centerOnScreen = true)
    }

    fun logout() {
        with(config) {
            remove(USERNAME)
            remove(PASSWORD)
            save()
        }

        showStarterScreen()
    }

    companion object {
        val USERNAME = "username"
        val PASSWORD = "password"
    }

}