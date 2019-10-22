package NGP.code

class Usuario(private var nombre: String,
              private var usuario: String,
              private var correo: String,
              private var password: String){

    private var saldo = 0
    private var historial = ""

    init{
        if(nombre.isBlank() || usuario.isBlank() || correo.isBlank() || password.isBlank())
            throw IllegalArgumentException("Ninguno de los atributos puede ser vacio")
    }
    fun getNombre(): String{
        return this.nombre
    }
    fun setNombre(nombre: String) {
        if(nombre.isBlank())
            throw IllegalArgumentException("Ninguno de los atributos puede ser vacio")
        this.nombre = nombre
    }
    fun getUsuario(): String {
        return this.usuario
    }
    fun setUsuario(usuario: String) {
        if(usuario.isBlank())
            throw IllegalArgumentException("Ninguno de los atributos puede ser vacio")
        this.usuario = usuario
    }
    fun getCorreo(): String {
        return this.correo
    }
    fun setCorreo(correo: String){
        if(correo.isBlank())
            throw IllegalArgumentException("Ninguno de los atributos puede ser vacio")
        this.correo = correo
    }
    fun getPassword(): String{
        return this.password
    }
    fun setPassword(password: String){
        if(password.isBlank())
            throw IllegalArgumentException("Ninguno de los atributos puede ser vacio")
        this.password = password
    }
    fun getSaldo(): Int{
        return this.saldo
    }
    fun aumentaSaldo(saldo: Int) {
        this.saldo += saldo
    }
    fun getHistorial():String{
        return historial
    }
    fun setHistorial(historial: String) {
        if(historial.isBlank())
            throw IllegalArgumentException("Ninguno de los atributos puede ser vacio")
        this.historial = historial
    }
}