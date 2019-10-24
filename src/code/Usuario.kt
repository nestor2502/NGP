package code

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*

/**
 * Clase para representar usuarios.
 * Un usuario debe tener nombre, usuario, correo, password,
 * correo,password.
 * Utiliza {@link JavaFX} para su enlace con la interfaz grafica
 * junto con tornadoFX para su uso en Kotlin
 */

class Usuario(nombre: String,
              usuario: String,
              correo: String,
              password: String) {
    /*Nombre del usuario*/
    val nombreProperty = SimpleStringProperty(nombre)
    private var nombre by nombreProperty
    /* Usuario */
    val usuarioProperty = SimpleStringProperty(usuario)
    private var usuario by usuarioProperty
    /* Correo del Usuario*/
    val correoProperty = SimpleStringProperty(correo)
    private var correo by correoProperty
    /* Contraseña cifrada del usuario */
    val passwordProperty = SimpleStringProperty(password)
    private var password by passwordProperty
    /* Saldo del usuario*/
    val saldoProperty = SimpleIntegerProperty(0)
    private var saldo by saldoProperty
    /* Historial del Usuario*/
    val historialProperty = SimpleStringProperty("")
    private var historial by historialProperty

    /**
     * Inicializador de la clase Usuario
     * Llama a la funcion comprueba
     */
    init{
        comprueba()
    }

    /**
     * Funcion obtenUsuario, no se usó a convencion getUsuario
     * debido a un error de colisiones con el framewoork de
     * {@link TornadoFX}
     * @return usuario: El usuario
     */
    fun obtenUsuario(): String = usuario

    /**
     * Funcion cambiaUsuario, no se usó a convencion getUsuario
     * debido a un error de colisiones con el framewoork de
     * {@link TornadoFX}
     * Llama a la funcion comprueba
     * @param usuario: El nuevo usuario a guardar
     */
    fun cambiaUsuario(usuario: String){
        val temporal = this.usuario
        try {
            this.usuario = usuario
            comprueba()
        }catch (e: IllegalArgumentException){
            this.usuario = temporal
            throw IllegalArgumentException(e.message)
        }
    }
    /**
     * Funcion obtenNombre, no se usó a convencion getUsuario
     * debido a un error de colisiones con el framewoork de
     * {@link TornadoFX}
     * @return nombre: El nombre del usuario
     */
    fun obtenNombre(): String = nombre
    /**
     * Funcion cambiaNombre, no se usó a convencion getUsuario
     * debido a un error de colisiones con el framewoork de
     * {@link TornadoFX}
     * Llama a la funcion comprueba
     * @param nombre: El nuevo nombre a guardar
     */
    fun cambiaNombre(nombre: String){
        val temporal = this.nombre
        try {
            this.nombre = nombre
            comprueba()
        }catch (e: IllegalArgumentException){
            this.nombre = temporal
            throw IllegalArgumentException(e.message)
        }
    }
    /**
     * Funcion obtenCorreo, no se usó a convencion getUsuario
     * debido a un error de colisiones con el framewoork de
     * {@link TornadoFX}
     * @return correo: El correo del usuario
     */
    fun obtenCorreo():String = correo
    /**
     * Funcion cambiaCorreo, no se usó a convencion getUsuario
     * debido a un error de colisiones con el framewoork de
     * {@link TornadoFX}
     * Llama a la funcion comprueba
     * @param correo: El nuevo correo a guardar
     */
    fun cambiaCorreo(correo: String){
        val temporal = this.correo
        try {
            this.correo = correo
            comprueba()
        }catch (e: IllegalArgumentException){
            this.correo = temporal
            throw IllegalArgumentException(e.message)
        }
    }
    /**
     * Funcion obtenPassword, no se usó a convencion getUsuario
     * debido a un error de colisiones con el framewoork de
     * {@link TornadoFX}
     * @return password: El password del usuario
     */
    fun obtenPassword():String = password
    /**
     * Funcion cambiaPassword, no se usó a convencion getUsuario
     * debido a un error de colisiones con el framewoork de
     * {@link TornadoFX}
     * @param password: El nuevo password a guardar
     */
    fun cambiaPassword(password: String){
        this.password = password

    }
    /**
     * Funcion obtenSaldo, no se usó a convencion getUsuario
     * debido a un error de colisiones con el framewoork de
     * {@link TornadoFX}
     * @return saldo El saldo
     */
    fun obtenSaldo(): Int = saldo
    /**
     * Funcion cambiaSaldo, no se usó a convencion getUsuario
     * debido a un error de colisiones con el framewoork de
     * {@link TornadoFX}
     * @param saldo: Suma el saldo
     * */
    fun cambiaSaldo(saldo: Int){
        this.saldo += saldo
    }
    /**
     * Funcion obtenHistorial, no se usó a convencion getUsuario
     * debido a un error de colisiones con el framewoork de
     * {@link TornadoFX}
     * @return historial: El historial del usuario
     */
    fun obtenHistorial():String = historial
    /**
     * Funcion cambiaHistorial, no se usó a convencion getUsuario
     * debido a un error de colisiones con el framewoork de
     * {@link TornadoFX}
     * @param historial: El historial anterior se concatena al nuevo
     */
    fun cambiaHistorial(historial: String){
        this.historial += historial
    }
    /**
     *  Funcion comprueba
     *  Verifica si el usuario es válido
     *  Un usuario es valido si
     *  - nombre,usuario,correo,password no son vacios o son sólo espacios y son
     *      alfanumericos
     *  - Hay al menos un "@" y un "." en el correo
     *  @throws IllegalArgumentException en otro caso
     */
    @Throws(IllegalArgumentException::class)
    fun comprueba(){
        if(nombre.isBlank() || usuario.isBlank() || correo.isBlank() || password.isBlank())
            throw IllegalArgumentException("Ninguno de los atributos puede ser vacio")
        val stringPattern = """[a-zA-Z0-9]""".toRegex()
        if(!("@" in correo && "." in correo))
            throw IllegalArgumentException("Correo inválido")
        if(!stringPattern.containsMatchIn(nombre))
            throw IllegalArgumentException("Nombre inválido")
        if(!stringPattern.containsMatchIn(usuario))
            throw IllegalArgumentException("Usuario inválido")
    }
}

/**
 * UsuarioViewModel
 * Intermediario entre TornadoFX y la clase principal
 * Mas informacion:
 * @see https://github.com/edvin/tornadofx-guide/blob/master/part1/11.%20Editing%20Models%20and%20Validation.md
 */
class UsuarioModel(usuario: Usuario): ItemViewModel<Usuario>(usuario) {
    val nombre = bind(Usuario::nombreProperty)
    val usuario = bind(Usuario::usuarioProperty)
    val correo = bind(Usuario::correoProperty)
    val password = bind(Usuario::passwordProperty)
    val saldo = bind(Usuario::saldoProperty)
    val historial = bind(Usuario::historialProperty)
}
