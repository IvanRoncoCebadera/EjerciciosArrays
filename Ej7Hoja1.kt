fun main(){
    var mensaje = ""
    println("Introduce un numero y te dire si es capicuo: ")
    mensaje = readln()
    val mensajeArray: CharArray = mensaje.toCharArray()
    println(comprobarCapicuo (mensajeArray, mensaje))
}

/**
 * funcion para escribir al reves
 * @param mensajeArray el vector con los carcateres del numero que introduzcamos
 * @retrun el mensaje escrito al reves
 */
fun  EscribirAlreves(mensajeArray: CharArray): String{
    val mensajeArray2: CharArray = CharArray(mensajeArray.size)
    var contador = 0
    for(i in mensajeArray.size - 1 downTo 0 ){
        mensajeArray2[i] = mensajeArray[contador]
        contador = contador + 1
    }
    var mensaje: String = mensajeArray2.joinToString ("")
    return mensaje
}
/**
 * funcion para comprobar si un numero es capicua
 * @param mensajeArray el vector con los carcateres del numero que introduzcamos
 * @param mensaje es el numero que se pidio que escribiera al ususario
 * @retrun la respuesta a si es o no capicua
 */
fun comprobarCapicuo (mensajeArray: CharArray, mensaje: String): String{
    var mensaje2 = EscribirAlreves(mensajeArray)
    var resultadoBuilder = StringBuilder()
    if (mensaje == mensaje2){
        resultadoBuilder.append("Es capicua.")
    }else{
        resultadoBuilder.append("No es capicua.")
    }
    return resultadoBuilder.toString()
}