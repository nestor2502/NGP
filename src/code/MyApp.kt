package code

import javafx.stage.Stage
import tornadofx.*
import view.LoginController
import view.LoginScreen

class MyApp : App(LoginScreen::class, Styles::class) {
    val loginController: LoginController by inject()

    override fun start(stage: Stage) {
        super.start(stage)
        loginController.init()
    }
}

fun main(args: Array<String>) {
    launch<MyApp>(args)
}