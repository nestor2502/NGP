package code

import code.Team
/**
 * Clase que revuelve un arreglo de equipos aleatoriamente
 */
class Random constructor(equipos: Array<Team>){

    var equipos= arrayOfNulls<Team>(8)

    /**
     * Se llena el arreglo con el nombre de los equipos
     */
    init {
        var i : Int= 0
        for (posicion in equipos){
            this.equipos[i]= equipos[i]
            i++
        }
    }

    /**
     * Metodo que revuelve el arreglo
     * @return revuelto, arreglo con los equipos ordenados aleatoriamente
     */
    fun revuelve(): Array<Team?>{
        //arreglo con los numeros del 0 al 7 los cuales se ordenan de manera aleatoria
        val numeros = IntArray(8)
        //arreglo con los eqipos ordenados de manera aleatoria
        val revuelto = arrayOfNulls<Team>(8)
        //primer contador
        var i = 0
        //Se generan numeros aleatorios
        while(i<8){
            val aleatorio = (Math.random() * 8).toInt() + 1
            //si el numero no está en el arreglo revuelto se agrega a este
            if(!contiene(aleatorio,numeros)){
                numeros[i]=aleatorio;
                i++;}
        }
        //se llena el arreglo con los equipos ordenanos de manera aleatoria
        var j = 0
        for(elemento in revuelto){
            revuelto[j]= equipos[numeros[j]-1];
            j++
        }
        return  revuelto

    }

    /**
     * Metodo que te dice si el numero buscado
     * ya se encentra en el array
     * @param num, numero a buscar
     * @param arr, array donde se buscará
     */
    fun contiene(num: Int, arr: IntArray): Boolean {
        var j = 0
        for (i in arr) {
            if (num == arr[j])
                return true
            j++
        }
        return false
    }
}