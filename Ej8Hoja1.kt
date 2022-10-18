fun main(){
    var mensaje = ""
    println("Introduce una palabra y te dire si es palindroma: ")
    mensaje = readln()
    val mensajeArray: CharArray = mensaje.toCharArray()
    println(comprobarPalindromo (mensajeArray, mensaje))
}

/**
 * funcion para escribir al reves
 * @param mensajeArray el vector con los carcateres de la palabra o texto que introduzcamos
 * @retrun el mensaje escrito al reves
 */
fun  EscribirAlreve(mensajeArray: CharArray): String{
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
 * funcion para comprobar si una palabra es palidroma
 * @param mensajeArray el vector con los carcateres de la palabra o texto que introduzcamos
 * @param mensaje es la palabra que se pidio que escribiera al ususario
 * @retrun la respuesta a si es o no palindroma
 */
fun comprobarPalindromo (mensajeArray: CharArray, mensaje: String): String{
    var mensaje2 = EscribirAlreve(mensajeArray)
    var resultadoBuilder = StringBuilder()
    if (mensaje == mensaje2){
        resultadoBuilder.append("Es palindroma.")
    }else{
        resultadoBuilder.append("No es palindroma.")
    }
    return resultadoBuilder.toString()
}