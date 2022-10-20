fun main(){
    val arrayInt: IntArray = intArrayOf(0,0,0,0,0,0,0,0,0)
    var numero = 0
    println("${generarCadena(arrayInt)}")
}

/**
 * funcion que crea un numero determinado de numeros, siendo cada numero nuevo el anterior mas el indice actual
 * @param arrayInt vector de numeros sobre el que generaremos la cadena
 * @return mensaje con la cadena creada
 */
fun generarCadena(arrayInt: IntArray): String {
    var mensaje = ""
    var res = generarNumero("Introduce un número para inicializar la cadena:")
    for (i in 0 until arrayInt.size) {
        arrayInt[i] = res
        if (i >= 1) {
            res = arrayInt[i] + arrayInt[i - 1]
        } else{
            res = arrayInt[i] + 1
        }
        mensaje = "$mensaje ${arrayInt[i]}"
    }
    mensaje = "su cadena es: $mensaje "
    return mensaje
}

/**
 * funcion que genera el numero para empezar la cadena
 * @param mensaje texto descriptivo del proceso ha seguir
 * @return el numero con el que se inicia la cadena
 */
fun generarNumero(mensaje: String): Int{
    println(mensaje)
    var numero = 0
    do {
        numero = readln().toInt()
        if(numero !in (-Int.MAX_VALUE .. Int.MAX_VALUE)){
            println("Ese valor introducido no vale.")
        }
    }while(numero !in (-Int.MAX_VALUE .. Int.MAX_VALUE))
    return numero
}
