package code

import code.Team

fun main(args: Array<String>){
    val apuesta = Apuesta(140, 60)

    var proba:Double = apuesta.calculaProbabilidad(1)
    println("Probabilidad de que gane A: $proba")

    var cuota: Double = apuesta.calcularCuota(1)
    println("Cuota por apostar por A: $cuota")

    var ganancia: Int = apuesta.calculaGanancia(100, 1)
    println("La ganancia es de : $ganancia")
}