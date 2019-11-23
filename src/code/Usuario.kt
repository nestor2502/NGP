package code

/**
 * Clase para representar usuarios.
 * Un usuario debe tener nombre, usuario, correo, password,
 * correo,password.
 */

class Usuario(private var nombre: String,
              private var usuario: String,
              private var correo: String,
              private var password: String) {
    private var saldo = 0
    private var historial = ""
    /**
     * Inicializador de la clase Usuario
     * Llama a la funcion comprueba
     */
    init{
        comprueba()
    }

    /**
     * Funcion getUsuario, no se usó a convencion getUsuario
     * debido a un error de colisiones con el framewoork de
     * {@link TornadoFX}
     * @return usuario: El usuario
     */
    fun getUsuario(): String = usuario

    /**
     * Funcion setUsuario, no se usó a convencion getUsuario
     * debido a un error de colisiones con el framewoork de
     * {@link TornadoFX}
     * Llama a la funcion comprueba
     * @param usuario: El nuevo usuario a guardar
     */
    fun setUsuario(usuario: String){
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
     * Funcion getNombre, no se usó a convencion getUsuario
     * debido a un error de colisiones con el framewoork de
     * {@link TornadoFX}
     * @return nombre: El nombre del usuario
     */
    fun getNombre(): String = nombre
    /**
     * Funcion setNombre, no se usó a convencion getUsuario
     * debido a un error de colisiones con el framewoork de
     * {@link TornadoFX}
     * Llama a la funcion comprueba
     * @param nombre: El nuevo nombre a guardar
     */
    fun setNombre(nombre: String){
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
     * Funcion getCorreo, no se usó a convencion getUsuario
     * debido a un error de colisiones con el framewoork de
     * {@link TornadoFX}
     * @return correo: El correo del usuario
     */
    fun getCorreo():String = correo
    /**
     * Funcion setCorreo, no se usó a convencion getUsuario
     * debido a un error de colisiones con el framewoork de
     * {@link TornadoFX}
     * Llama a la funcion comprueba
     * @param correo: El nuevo correo a guardar
     */
    fun setCorreo(correo: String){
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
     * Funcion getPassword, no se usó a convencion getUsuario
     * debido a un error de colisiones con el framewoork de
     * {@link TornadoFX}
     * @return password: El password del usuario
     */
    fun getPassword():String = password
    /**
     * Funcion setPassword, no se usó a convencion getUsuario
     * debido a un error de colisiones con el framewoork de
     * {@link TornadoFX}
     * @param password: El nuevo password a guardar
     */
    fun setPassword(password: String){
        this.password = password

    }
    /**
     * Funcion getSaldo, no se usó a convencion getUsuario
     * debido a un error de colisiones con el framewoork de
     * {@link TornadoFX}
     * @return saldo El saldo
     */
    fun getSaldo(): Int = saldo
    /**
     * Funcion setSaldo, no se usó a convencion getUsuario
     * debido a un error de colisiones con el framewoork de
     * {@link TornadoFX}
     * @param saldo: Suma el saldo
     * */
    fun setSaldo(saldo: Int){
        val nuevo = this.saldo + saldo
        if(nuevo < 0)
            throw IllegalArgumentException("El saldo no puede ser negativo")
        this.saldo = nuevo
    }
    /**
     * Funcion getHistorial, no se usó a convencion getUsuario
     * debido a un error de colisiones con el framewoork de
     * {@link TornadoFX}
     * @return historial: El historial del usuario
     */
    fun getHistorial():String = historial
    /**
     * Funcion setHistorial, no se usó a convencion getUsuario
     * debido a un error de colisiones con el framewoork de
     * {@link TornadoFX}
     * @param historial: El historial anterior se concatena al nuevo
     */
    fun setHistorial(historial: String){
        val nuevo = this.historial + historial
        this.historial = nuevo
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
