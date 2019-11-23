package view

import javafx.application.Platform
import javafx.geometry.Pos
import javafx.scene.text.Font
import tornadofx.*


class StartingScreen : View("Sistema de Apuestas") {
    val loginController: LoginController by inject()
    val registerController: RegisterController by inject()
    override val root = borderpane {
        setPrefSize(450.0, 300.0)

        top {
            label("Bienvenido, por favor inicia sesion") {
                font = Font.font(26.0)
                alignment = Pos.TOP_CENTER
            }
        }

        center {
            vbox(spacing = 15) {
                alignment = Pos.CENTER


                hbox {
                    alignment = Pos.CENTER

                    button("Inicia Sesion") {
                        useMaxWidth = true
                        setOnAction {
                            loginController.showLoginScreen("Inicia Sesion")
                        }
                    }

                    button("Registrate") {
                        useMaxWidth = true
                        setOnAction {
                            registerController.showRegisterScreen(("Registrate"))
                        }
                    }
                }
            }
        }
    }
}