package view

import javafx.application.Platform
import javafx.geometry.Pos
import javafx.scene.text.Font
import tornadofx.*


class StartingScreen : View("Apuestas LOL") {
    val loginController: LoginController by inject()
    val registerController: RegisterController by inject()
    override val root = borderpane {
        setPrefSize(800.0, 600.0)

        top {
            label(title) {
                font = Font.font(22.0)
            }
        }

        center {
            vbox(spacing = 15) {
                alignment = Pos.CENTER


                hbox {
                    alignment = Pos.CENTER

                    button("Inicia Sesion") {
                        setOnAction {
                            loginController.showLoginScreen("Inicia Sesion")
                        }
                    }

                    button("Registrate") {
                        setOnAction {
                            registerController.showRegisterScreen(("Registrate"))
                        }
                    }
                }
            }
        }
    }
}