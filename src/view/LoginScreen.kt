package view

import view.Styles.Companion.loginStyle
import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleStringProperty
import javafx.event.EventHandler
import javafx.util.Duration
import tornadofx.*

class LoginScreen : View("Inicia Sesión"){

    val loginController : LoginController by inject()
    val startingScreen : StartingScreen by inject()

    private val model = object : ViewModel(){
        val usuario = bind { SimpleStringProperty() }
        val password = bind { SimpleStringProperty() }
        val recuerda = bind { SimpleBooleanProperty() }
    }

    override val root = form {
        addClass(loginStyle)
        fieldset {
            field("Usuario")
            textfield(model.usuario) {
                required()
                        whenDocked { requestFocus() }
            }
            field("Password") {
                passwordfield(model.password).required()
            }
            field("Recuerdame") {
                checkbox(property = model.recuerda)
            }
        }
        button("Login") {
            isDefaultButton = true
            useMaxWidth = true
            action {
                model.commit {
                    loginController.tryLogin(
                            model.usuario.value,
                            model.password.value,
                            model.recuerda.value
                    )
                }
            }
        }
        button("Cancel"){
            action{
                loginController.showStartingScreen()
                useMaxWidth = true
            }
        }
    }

    override fun onDock() {
        model.validate(decorateErrors = false)
    }

    fun clear() {
        model.usuario.value = ""
        model.password.value = ""
        model.recuerda.value = false
    }
}

