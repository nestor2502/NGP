package code
import java.util.Random
import code.Team
class Torneo {
    //Equipos participantes
    private val equipo1 = Team("Team Liquid", generaHabilidad())
    private val equipo2 = Team("Hong Kong Attitude", generaHabilidad())
    private val equipo3 = Team("G2 Esports", generaHabilidad())
    private val equipo4 = Team("Fnatic", generaHabilidad())
    private val equipo5 = Team("Griffin", generaHabilidad())
    private val equipo6 = Team("SK Telecom T1", generaHabilidad())
    private val equipo7 = Team("Royal Never Give Up", generaHabilidad())
    private val equipo8 = Team("Invictus Gaming", generaHabilidad())
    private val equipos = arrayOf(equipo1, equipo2, equipo3, equipo4, equipo5, equipo6, equipo7, equipo8)
    private var equipos_listos : MutableList<Team> = arrayListOf()//lista de equipos revueltos

    /**
     * Metodo que organiza los combates de manera aleatoria
     */
    fun organizaCombates(){
        var random = Random(equipos)
        val equipos_organizado = random.revuelve()
        var j = 0
        for (i in equipos_organizado){
            if(equipos_organizado[j] is Team){
                equipos_listos.add(equipos_organizado[j] as Team)
                j++
            }
        }
    }

    fun mostrar(){
        for (item in equipos_listos){
            if(item is Team){
                var temp = item as Team
                println(temp.getNombre())
            }

        }

    }

    /**
     * Metodo que genera una habilidad de manera aleatoria
     * entre 50 y 400
     */
    fun generaHabilidad(): Int{
        var random = Random()
        var habilidad = random.nextInt(400- 50) + 50;
        return habilidad
    }

    /**
     *Funcion que enfrenta todos los equipos
     */
    fun jugarCuartos(time: Boolean){
        if(time == true)
            Thread.sleep(3_000)
        var combate1 = Combate(equipos_listos[0], equipos_listos[1])
        var ganador1: Int =  combate1.determinaGanador()
        println("Ganador del primer combate 1 : $ganador1")
        var combate2 = Combate(equipos_listos[2], equipos_listos[3])
        var ganador2: Int =  combate2.determinaGanador()
        println("Ganador del primer combate 2 : $ganador2")
        var combate3 = Combate(equipos_listos[4], equipos_listos[5])
        var ganador3: Int =  combate3.determinaGanador()
        println("Ganador del primer combate 3 : $ganador3")
        var combate4 = Combate(equipos_listos[6], equipos_listos[7])
        var ganador4: Int =  combate4.determinaGanador()
        println("Ganador del primer combate 4 : $ganador4")
        if(ganador1==1)
            equipos_listos.remove(equipos_listos[1])
        else if (ganador1 == 2)
            equipos_listos.remove(equipos_listos[0])
        if(ganador2==1)
            equipos_listos.remove(equipos_listos[2])
        else if (ganador2 == 2)
            equipos_listos.remove(equipos_listos[1])
        if(ganador3==1)
            equipos_listos.remove(equipos_listos[3])
        else if (ganador3 == 2)
        equipos_listos.remove(equipos_listos[2])
        if(ganador4==1)
        equipos_listos.remove(equipos_listos[4])
        else if (ganador4 == 2)
        equipos_listos.remove(equipos_listos[3])
    }

    /**
     *Funcion que enfrenta los 2 equipos restantes
     */
    fun jugarSemifinal(time: Boolean){
        if(time == true)
            Thread.sleep(3_000)
        var combate1 = Combate(equipos_listos[0], equipos_listos[1])
        var ganador1: Int =  combate1.determinaGanador()
        println("Ganador del primer combate 1 : $ganador1")
        var combate2 = Combate(equipos_listos[2], equipos_listos[3])
        var ganador2: Int =  combate2.determinaGanador()
        println("Ganador del primer combate 2 : $ganador2")
        if(ganador1==1)
            equipos_listos.remove(equipos_listos[1])
        else if (ganador1 == 2)
            equipos_listos.remove(equipos_listos[0])
        if(ganador2==1)
            equipos_listos.remove(equipos_listos[2])
        else if (ganador2 == 2)
            equipos_listos.remove(equipos_listos[1])
    }

    /**
     *funcion que enfrenta a los dos equipos restantes
     */
    fun jugarFinal(time: Boolean){
        if(time == true)
            Thread.sleep(3_000)
        var combate1 = Combate(equipos_listos[0], equipos_listos[1])
        var ganador1: Int =  combate1.determinaGanador()
        println("Ganador del torneo es : $ganador1")
        if(ganador1==1)
            equipos_listos.remove(equipos_listos[1])
        else if (ganador1 == 2)
            equipos_listos.remove(equipos_listos[0])
    }

}





fun main(args: Array<String>){

    var test = Torneo()
    test.organizaCombates()
    test.mostrar()
    test.jugarCuartos(true)
    test.mostrar()
    test.jugarSemifinal(true)
    test.mostrar()
    test.jugarFinal(true)
    test.mostrar()
    print("\nFinish")

}