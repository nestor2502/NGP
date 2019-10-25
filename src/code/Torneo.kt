package code
import java.util.Random
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.value.ObservableValue
import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import tornadofx.*

class Torneo constructor(saldo_inicial: Int){

    //Equipos participantes
    private val equipo1 : Team
    private val equipo2 : Team
    private val equipo3 : Team
    private val equipo4 : Team
    private val equipo5 : Team
    private val equipo6 : Team
    private val equipo7 : Team
    private val equipo8 : Team
    private val equipos : Array<Team>
    private var equipos_listos : MutableList<Team>
    private var saldo_inicial : Int
    var saldo_generadoProperty = SimpleIntegerProperty(0)
    private var saldo_generado by saldo_generadoProperty
    var ganadorCuartosProperty = SimpleStringProperty("")
    private var ganadorCuartos by ganadorCuartosProperty
    var ganadorSemiProperty = SimpleStringProperty("")
    private var ganadorSemi by ganadorSemiProperty
    var ganadorFinalProperty = SimpleStringProperty("")
    private var ganadorFinal by ganadorFinalProperty

    init {

        equipo1 = Team("Team Liquid", generaHabilidad())
        equipo2 = Team("Hong Kong Attitude", generaHabilidad())
        equipo3 = Team("G2 Esports", generaHabilidad())
        equipo4 = Team("Fnatic", generaHabilidad())
        equipo5 = Team("Griffin", generaHabilidad())
        equipo6 = Team("SK Telecom T1", generaHabilidad())
        equipo7 = Team("Royal Never Give Up", generaHabilidad())
        equipo8 = Team("Invictus Gaming", generaHabilidad())
        equipos = arrayOf(equipo1, equipo2, equipo3, equipo4, equipo5, equipo6, equipo7, equipo8)
        equipos_listos = arrayListOf()//lista de equipos revueltos
        this.saldo_inicial  = saldo_inicial
        saldo_generado = 0 //saldo que se genera durante el torneo
        ganadorCuartos = ""
        ganadorSemi = ""
        ganadorFinal = ""
    }

    /**
     * Metodo que organiza los combates de manera aleatoria
     * Es el primero que se usa despues de crear el torneo
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

    /**
     *Funcion que enfrenta todos los equipos
     * y elimina a los perdedores
     * @param combate: seleccion de los 4 combates disponibles de 1 vs 1
     * @param seleccion: equipo apostado por el usuario
     * @param cantidad: cantidad apostada por el usuario por ese equipo
     */
    fun jugarCuartos( combate:Int, seleccion: Int, cantidad: Int){
        //try {
            val habilidades: Array<Int> = arrayOf(equipo1.obtenerHabilidad(), equipo2.obtenerHabilidad(), equipo3.obtenerHabilidad(), equipo4.obtenerHabilidad(),
                                                  equipo5.obtenerHabilidad(), equipo6.obtenerHabilidad(), equipo7.obtenerHabilidad(), equipo8.obtenerHabilidad())
            var resultado: Boolean
            var ganancia: Int = 0
            var ganador1 = realizarCombate(equipos_listos[0], equipos_listos[1])
            var ganador2 = realizarCombate(equipos_listos[1], equipos_listos[2])
            var ganador3 = realizarCombate(equipos_listos[2], equipos_listos[3])
            var ganador4 = realizarCombate(equipos_listos[3], equipos_listos[4])
            if (combate >= 1 && combate <= 4 && seleccion >= 1 && seleccion <= 2 && cantidad >= 1 && saldo_inicial > 0 && saldo_inicial >= cantidad) {
                if (combate == 1) {
                    resultado = ganador1 == seleccion
                    ganancia = calcularGanancia(habilidades[0], habilidades[1], cantidad, seleccion, resultado)
                }
                if (combate == 2) {
                    resultado = ganador2 == seleccion
                    ganancia = calcularGanancia(habilidades[2], habilidades[3], cantidad, seleccion, resultado)
                }
                if (combate == 3) {
                    resultado = ganador3 == seleccion
                    ganancia = calcularGanancia(habilidades[4], habilidades[5], cantidad, seleccion, resultado)
                }
                if (combate == 4) {
                    resultado = ganador4 == seleccion
                    ganancia = calcularGanancia(habilidades[6], habilidades[7], cantidad, seleccion, resultado)
                }
                saldo_generado += ganancia
                saldo_inicial += saldo_generado
                saldo_generado = 0
            }
        //}
        //catch (e: IllegalArgumentException){
          //  throw IllegalArgumentException(e.message)
        //}
        ganadorCuartos = obtenerGanadorParticular(combate)
    }

    /**
     *Funcion que enfrenta los 2 equipos restantes
     * y elimina a los perdedores
     *@param combate: seleccion de los 2 combates disponibles
     * @param seleccion: equipo apostado por el usuario
     * @param cantidad: cantidad apostada por el usuario en esta ronda
     * @return nombres: nombres de los ganadores por cada combate
     */
    fun jugarSemifinal(combate:Int, seleccion: Int, cantidad: Int){
        val habilidades : Array<Int> = arrayOf(equipos_listos[0].obtenerHabilidad(), equipos_listos[1].obtenerHabilidad(),
                                                equipos_listos[2].obtenerHabilidad(),equipos_listos[3].obtenerHabilidad())
        var ganador1 = realizarCombate(equipos_listos[0], equipos_listos[1])
        var ganador2 = realizarCombate(equipos_listos[1], equipos_listos[2])
        var resultado : Boolean = false
        var ganancia : Int = 0
        if(combate>=1 && combate <=2 && seleccion >=1 && seleccion<=2 && cantidad>=1 && saldo_inicial>0 && saldo_inicial>=cantidad){
            if (combate == 1){
                resultado = ganador1 == seleccion
                ganancia =  calcularGanancia(habilidades[0], habilidades[1], cantidad, seleccion,resultado)}
            if (combate == 2) {
                resultado = ganador2 == seleccion
                ganancia =  calcularGanancia(habilidades[2], habilidades[3], cantidad, seleccion,resultado)}
            saldo_generado += ganancia
            saldo_inicial+=saldo_generado}
        ganadorSemi = obtenerGanadorParticular(combate)
    }

    /**
     *funcion que enfrenta a los dos equipos restantes
     * y elimina al perdedor
     * @param seleccion: equipo apostado por el usuario
     * @param cantidad: cantidad apostada por el usuario en esta ronda
     * @return nombres: nombres de los ganadores por cada combate
     */
    fun jugarFinal( seleccion: Int, cantidad: Int){
        var nombres : Array<String>
        val habilidades : Array<Int> = arrayOf(equipos_listos[0].obtenerHabilidad(), equipos_listos[1].obtenerHabilidad())
        var ganador1 = realizarCombate(equipos_listos[0], equipos_listos[1])
        var resultado : Boolean = false
        var ganancia : Int = 0
        if(seleccion >=1 && seleccion<=2 && cantidad>=1 && saldo_inicial>0 && saldo_inicial>=cantidad){
            resultado = ganador1 == seleccion
            ganancia =  calcularGanancia(habilidades[0], habilidades[1], cantidad, seleccion,resultado)
            saldo_generado += ganancia}
        saldo_inicial+=saldo_generado
        //nombres = arrayOf(equipos_listos[0].obtenerNombre())
        ganadorFinal = obtenerGanadorParticular(1)
    }

    /**
     * Metodo que obtiene el nombre del equipo aganador del combate seleccionado por
     * el usuario
     * @param combate: partida seleccionada por el usuario
     * @return ganador: nombre del equipo ganador
     */
    private fun obtenerGanadorParticular(combate: Int):String{
        var ganador :String = ""
        if (combate == 1)
            ganador =  equipos_listos[0].obtenerNombre()
        if (combate == 2)
            ganador =  equipos_listos[1].obtenerNombre()
        if (combate == 3)
            ganador =  equipos_listos[2].obtenerNombre()
        if (combate == 4)
            ganador =  equipos_listos[3].obtenerNombre()
        return  ganador
    }

    /**
     * Funcion que devuelve a los jugadores activos
     * @return jugadores: jugadores activos
     */
    fun getJugadores(): MutableList<Team>{
        return equipos_listos
    }

    /**
     *Funcion que calcula la gananancia del usuario si apuesta en un torneo
     * la ganancia puede ser positiva o negativa
     * @param equipo1  equipos que se enfrentaran
     * @param equipo2 equipos que se enfrentan
     * @param cantidad cantidad apostada por el usuario
     * @param seleccion equipo apostado por el usuario
     * @param resultado resultado del combate entre los dos equipos
     * @return ganancia: ganancia del usuario al apostar por cierto equipo
     */
    private fun calcularGanancia(habilidad_equipo1: Int, habilidad_equipo2: Int, cantidad: Int,seleccion: Int, resultado: Boolean): Int{
        var apuesta = Apuesta(habilidad_equipo1, habilidad_equipo2)
        apuesta.calcularCuota(seleccion)
        var ganancia: Int
        if (resultado == true)
            ganancia = apuesta.calculaGanancia(cantidad, seleccion)
        else
            ganancia = -cantidad
        return ganancia
    }

    /**
     * Funcion que devuelve el saldo que se ha generado durante toda la partida
     * @return saldo_generado: saldo obtenido a lo largo del torneo
     */
    fun obtenerSaldoGenerado():Int{
        return  saldo_generado
    }

    /**
     * Metodo auxiliar para ver a los equipos
     * que continuan en el torneo
     */
    fun mostrar(){
        for (item in equipos_listos){
            if(item is Team){
                var temp = item as Team
                println(temp.obtenerNombre())
            }
        }
    }

    /**
     * Metodo que genera una habilidad de manera aleatoria
     * entre 50 y 400
     * @return habilidad: habilidad que se le asignara al equipo
     */
    private fun generaHabilidad(): Int{
        var random = Random()
        var habilidad = random.nextInt(400- 50) + 50;
        return habilidad
    }

    /**
     *Funcion que enfrenta dos equipos y elimina al perdedor
     * @param equipoA:  primer equipo en combatir
     * @param equipoB: rival del equipoA
     * @return 1: si gana el equipoA
     * @return 2: si gana el equipoB
     */
    private fun realizarCombate(equipoA: Team, equipoB: Team): Int{
        var combate = Combate(equipoA, equipoB)
        var ganador: Int =  combate.determinaGanador()
        println("Ganador del primer combate 1 : $ganador")
        if(ganador==1)
            equipos_listos.remove(equipoB)
        else if (ganador == 2)
            equipos_listos.remove(equipoA)

        return ganador
    }

    /**
     * Metodo que obtiene el ganador del combate donde participó el usuario en los cuartos
     * @return ganadorCuartos: ganador del combate donde participó el usuario
     */
    fun obtenerGanadorCuartos(): String{
        return ganadorCuartos
    }

    /**
     * Metodo que obtiene el ganador del combate donde participó el usuario en la semifinal
     * @return ganadorSemi: ganador del combate donde participó el usuario
     */
    fun obtenerGanadorSemifinal():String{
        return ganadorSemi
    }

    /**
     * Metodo que obtiene el ganador de la final
     * @return ganadorFinal: ganador del combate final
     */
    fun obtenerGanadorFinal():String{
        return ganadorFinal
    }

    /**
     * Metodo que obtiene el nombre de los ganadores de cada fase
     * @return nombre_de_equipos: nombre de todos los equipos ganadores por fase
     */
    fun obtenerGanadores(): MutableList<String>{
        val nombre_de_equipos = FXCollections.observableArrayList<String>()
        //var nombre_de_equipos by nombre_de_equiposProperty
        var i= 0
        for (equipo in equipos_listos){
            nombre_de_equipos.add(equipos_listos[i].obtenerNombre())
            i++
        }
        return nombre_de_equipos
    }

}

/**
 * TorneoViewModel
 * Intermediario entre TornadoFX y la clase principal
 * Mas informacion:
 * @see https://github.com/edvin/tornadofx-guide/blob/master/part1/11.%20Editing%20Models%20and%20Validation.md
 */
class TorneoModel(torneo: Torneo): ItemViewModel<Torneo>(torneo) {

    val saldo_generado = bind(Torneo::saldo_generadoProperty)
    var ganadorCuartos = bind(Torneo::ganadorCuartosProperty)
    var ganadorSemi = bind(Torneo::ganadorSemiProperty)
    var ganadorFinal = bind(Torneo::ganadorFinalProperty)

}

