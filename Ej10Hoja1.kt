import kotlin.system.measureNanoTime

fun main(){
    var mensaje = generarMensaje("Por favor, introduzca un mensaje, y lo escribire al reves.")
    println("Ese mensaje escrito al reves, queda como: ${generarMensajeInverso(mensaje)}")


}
/**
 * funcion para escribir mensajes
 * @param mensaje un texto informativo del proceso a llevar a cabo
 * @return el mensaje escrito
 */
fun generarMensaje(mensaje: String): String{
    println(mensaje)
    var texto = readln()
    return texto
}
/**
 * funcion para reescribir un mensaje, pero al reves
 * @param mensaje el texto al que debemos dar la vuelta
 * @return el mensaje dado la vuelta
 */
fun generarMensajeInverso(mensaje : String): String{
    var mensajeIBuilder = StringBuilder()

    for(i in mensaje.length - 1 downTo 0 ){
        mensajeIBuilder.append("${mensaje[i]}")
    }
    return mensajeIBuilder.toString()
}