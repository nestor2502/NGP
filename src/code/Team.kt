package code

/**
 * Equipos que participan en el torneo
 */
class Team constructor(nombre: String, habilidad: Int){
    private var nombre: String = ""
    private var habilidad: Int = 0
    init {
        this.nombre = nombre
        this.habilidad = habilidad
    }

    /**
     *Modifica el nombre del equipo
     * @param nombre que sele dará al equipo
     */
    fun setNombre(nombre: String){
        if(nombre.isBlank())
            throw IllegalArgumentException("Argumento invalido")
        else
            this.nombre = nombre
    }

    /**
     * Se obtiene el nombre del equipo
     * @return nombre
     */
    fun getNombre(): String{
        return nombre
    }

    /**
     * Se le añade una habilidad
     * @param habilidad
     */
    fun setHabilidad(habilidad: Int){
        this.habilidad = habilidad
    }

    /**
     * Se obtiene la habilidad
     */
    fun getHabilidad(): Int {
        return habilidad
    }




}