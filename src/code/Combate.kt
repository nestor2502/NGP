package code

import java.util.Random
import code.Apuesta
import code.Team

class Combate constructor(equipo1: Team, equipo2: Team){
    private var equipo1 : Team
    private var equipo2 : Team
    private var probailidad_equipo1: Double
    private var probailidad_equipo2: Double
    private var apuesta: Apuesta

    /**
     * Se asignan equipos y se asigna la probabilidad
     * de cada equipo
     */
    init {
        this.equipo1 = equipo1
        this.equipo2 = equipo2
        apuesta = Apuesta(equipo1.obtenerHabilidad(), equipo2.obtenerHabilidad())
        probailidad_equipo1 = apuesta.calculaProbabilidad(1)
        probailidad_equipo2 = apuesta.calculaProbabilidad(2)
    }

    /**
     * Metodo que determina a un ganador dependiendo de la probabilidad
     * de cada equipo
     */
    fun determinaGanador():Int{
        var random = Random()
        var aleatorio = random.nextInt(100- 0);
        var selected = getMaximaProbabilidad()
        var not_selected: Int = 0
        if (selected == 1)
            not_selected = 2
        else if (selected == 2)
            not_selected = 1
        var probabilidad_base: Double
        if(selected==1)
            probabilidad_base = probailidad_equipo1
        else
            probabilidad_base = probailidad_equipo2
        if (aleatorio <= probabilidad_base*100)
            return selected
        else
            return not_selected
    }

    /**
     * Funcion que obtiene la mayor de las probabilidades
     *entre dos jugadores y retorna al jugador con la mayor probabilidad
     * @return 1: si el jugador 1 tiene la mayor probabilidad
     * @return 2: si el jugador 2 tiene la mayor probabilidad
     */
    private fun getMaximaProbabilidad():Int {
        var random = Random()
        var aleatorio: Int
        if (probailidad_equipo1>probailidad_equipo2)
            return 1
        else if (probailidad_equipo2>probailidad_equipo1)
            return  2
        else
            aleatorio = random.nextInt(2- 1);
        if (aleatorio==1)
            return 1
        else
            return 2
    }

}
