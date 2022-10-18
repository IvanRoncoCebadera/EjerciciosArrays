import javax.swing.MenuSelectionManager

fun main(){
    var mensaje = ""
    println("Introduce un mensaje y te lo devolvere escrito del reves: ")
    mensaje = readln()
    val mensajeArray: CharArray = mensaje.toCharArray()
    println(escribirAlreves(mensajeArray))
}

/**
 * funcion para escribir al reves
 * @param mensajeArray el vector con los carcateres de la palabra o texto que introduzcamos
 * @retrun el mensaje escrito al reves
 */
fun escribirAlreves(mensajeArray: CharArray): String{
    val mensajeArray2: CharArray = CharArray(mensajeArray.size)
    var contador = 0
    for(i in mensajeArray.size - 1 downTo 0 ){
        mensajeArray2[i] = mensajeArray[contador]
        contador = contador + 1
    }
    var mensaje: String = mensajeArray2.joinToString ("")
    return mensaje
}