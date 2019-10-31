package code

/**
 *Clase que calcula la apuesta por cada usuario y
 * la ganancia que tendra en caso de ganar
 */
class Apuesta constructor(habilidad_equipoA: Int, habilidad_equipoB: Int){
    var habilidad_equipoA: Int
    var habilidad_equipoB: Int

    init {
        this.habilidad_equipoA = habilidad_equipoA
        this.habilidad_equipoB = habilidad_equipoB
    }

    /**
     * Funcion que asigna la probailida
     * de que un equipo gane
     * @param key 1 probabilidad de equipoA, 2 probabilidad de equipo B
     * @return probabilidad
     */
    fun calculaProbabilidad(key: Int): Double{
        var probabilidad: Double = 0.0
        var a = habilidad_equipoA.toDouble()
        var b = habilidad_equipoB.toDouble()
        if (key == 1)
            probabilidad = a/(a+b)
        else if (key == 2)
            probabilidad= b/(b+a)
        else
            throw Exception("llave no valida")
        return probabilidad
    }

    /**
     * Calcula la cuota por apostar por el usuario
     * @param key 1: si se apuesta por equipoA, 2 si se apuesta por equipo B
     * @return cuota
     */
    fun calcularCuota(key: Int):Double{
        var cuota: Double = 0.0
        if (key == 1)
            cuota = 1.0/calculaProbabilidad(1)
        else if (key == 2)
            cuota = 1.0/calculaProbabilidad(2)
        else
            throw Exception("LLave invalida")
        return cuota
    }

    /**
     * Metodo que obtiene la ganancia correspondiente
     * para el jugador
     * @param apuesta cantidad apostada por el jugador
     * @param key equpo que el usuario selecciono y resulto ganador
     * @return ganancia
     */
    fun calculaGanancia(apuesta :Int, key:Int): Int{
        var ganancia: Int = 0
        if (key == 1)
            ganancia = Math.floor(apuesta * calcularCuota(1)).toInt()
        else if (key == 2)
            ganancia = Math.floor( apuesta * calcularCuota(2)).toInt()
        else
            throw Exception("LLave invalida de equipo seleccionado")
        return ganancia
    }

}