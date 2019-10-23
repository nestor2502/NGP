package code
import java.util.Random
import code.Team
class Torneo {

    private val equipo1 = Team("E1", generaHabilidad())
    private val equipo2 = Team("E2", generaHabilidad())
    private val equipo3 = Team("E3", generaHabilidad())
    private val equipo4 = Team("E4", generaHabilidad())
    private val equipo5 = Team("E5", generaHabilidad())
    private val equipo6 = Team("E6", generaHabilidad())
    private val equipo7 = Team("E7", generaHabilidad())
    private val equipo8 = Team("E8", generaHabilidad())
    private val equipos = arrayOf(equipo1, equipo2, equipo3, equipo4, equipo5, equipo6, equipo7, equipo8)
    private var equipos_listos : MutableList<Team> = arrayListOf()


    /**
     * Metodo que organiza los combates de manera aleatoria
     */
    fun organizaCombates(equipos: Array<Team>){
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
     *
     */
    fun jugarCuartos(){


    }

    /**
     *
     */
    fun jugarSemifinal(){


    }

    /**
     *
     */
    fun jugarFinal(){


    }


}





fun main(args: Array<String>){
    var r = Random()
    var valor = r.nextInt(400- 50) + 50;
    println("Numero random: $valor\n")
    val equipo1 = Team("E1", 85)
   val equipo2 = Team("E2", 85)
  val equipo3 = Team("E3", 85)
    val equipo4 = Team("E4", 85)
   val equipo5 = Team("E5", 85)
    val equipo6 = Team("E6", 85)
   val equipo7 = Team("E7", 85)
   val equipo8 = Team("E8", 85)
    val equipos = arrayOf(equipo1, equipo2, equipo3, equipo4, equipo5, equipo6, equipo7, equipo8)
    var test = Torneo()
    test.organizaCombates(equipos)
    test.mostrar()
    print("\nFinish")


}