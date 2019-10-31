package code

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*

/**
 * Equipo que participan en el torneo
 */
class Team constructor(nombre: String, habilidad: Int){

    private var nombre: String
    private var habilidad : Int

    init {
        this.nombre = nombre
        this.habilidad = habilidad
    }

    /**
     *Modifica el nombre del equipo
     * @param nombre que sele dará al equipo
     */
    fun modificaNombre(nombre: String){
        if(nombre.isBlank())
            throw IllegalArgumentException("Argumento invalido")
        else
            this.nombre = nombre
    }

    /**
     * Se obtiene el nombre del equipo
     * @return nombre
     */
    fun obtenerNombre(): String{
        return nombre
    }

    /**
     * Se le añade una habilidad
     * @param habilidad
     */
    fun modificaHabilidad(habilidad: Int){
        this.habilidad = habilidad
    }

    /**
     * Se obtiene la habilidad
     */
    fun obtenerHabilidad(): Int {
        return habilidad
    }
}
