package NGP.code

import java.util.Random

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
        apuesta = Apuesta(equipo1.getHabilidad(), equipo2.getHabilidad())
        probailidad_equipo1 = apuesta.calculaProbabilidad(1)
        probailidad_equipo2 = apuesta.calculaProbabilidad(2)
    }

    /**
     * Metodo que determina a un ganador dependiendo de la probabilidad
     * de cada equipo
     */
    fun determinaGanador(time: Boolean):Int{
        var random = Random()
        var habilidad = random.nextInt(100- 0);
        if(time == true)
            Thread.sleep(15_000)
        return 1
    }

}
fun main(args: Array<String>){
    val equipo1 = Team("E1", 140)
    val equipo2 = Team("E2", 60)
    var combate = Combate(equipo1, equipo2)
    print("comienza")
    var ganador = combate.determinaGanador(true)
    print("\ntermina, ganador: $ganador")
}
