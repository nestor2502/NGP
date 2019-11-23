package view

import view.Styles.Companion.registerStyle
import javafx.beans.property.SimpleStringProperty
import javafx.event.EventHandler
import javafx.util.Duration
import tornadofx.*

class RegisterScreen : View("Registrate!"){
    val registerController : RegisterController by inject()

    private val model = object : ViewModel(){
        val usuario = bind { SimpleStringProperty() }
        val nombre = bind { SimpleStringProperty() }
        val correo = bind { SimpleStringProperty() }
        val password = bind{ SimpleStringProperty() }
    }

    override val root = form {
        fieldset {
            field("Usuario")
            textfield(model.usuario) {
                required()
                whenDocked { requestFocus() }
            }
            field("Correo")
            textfield(model.correo) {
                required()
                whenDocked { requestFocus() }
            }
            field("Nombre")
            textfield(model.nombre) {
                required()
                whenDocked { requestFocus() }
            }
            field("Password") {
                passwordfield(model.password).required()
            }
        }
        button("Registrate") {
            isDefaultButton = true
            useMaxWidth = true
            action {
                model.commit {
                    registerController.tryRegister(
                            model.usuario.value,
                            model.password.value,
                            model.correo.value,
                            model.nombre.value
                    )
                }
            }
        }
        button("Cancelar"){
            action{
                registerController.showStartingScreen("Bienvenido")
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
        model.correo.value = ""
        model.nombre.value = ""
    }

}