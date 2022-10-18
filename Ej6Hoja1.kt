fun main(){
    val arrayInt: IntArray = intArrayOf(0,0,0,0,0,0,0,0,0,0,0)
    val arrayInt2: IntArray = intArrayOf(0,0,0,0,0,0)
    println(pedirCadenas("Porfavor introduzca el primer número para la cadena de ${arrayInt.size} números", arrayInt))
    println(pedirCadenas("Porfavor introduzca el primer número para la cadena de ${arrayInt2.size} números", arrayInt2))
    println("${ comprobarCadenaIncluida(arrayInt, arrayInt2) }")
}

/**
 * funcion para crear vectores de numeros según el primer numero dado
 * @param mensaje texto descriptivo de lo que hay que hacer
 * @param arrayInt el vector de numeros sobre el que escribiresmos nos nuevos numeros
 * @return la cadena de numeros
 */
fun pedirCadenas(mensaje: String, arrayInt: IntArray): String{
    println(mensaje)
    var numero = 0
    var mensajeBuilder = StringBuilder()
    mensajeBuilder.append("La cadena creada es: ")
    numero = readln().toInt()
    for(i in 0 until arrayInt.size){
        arrayInt[i] = numero
        numero = numero + 1
    }
    mensajeBuilder.append("${arrayInt.joinToString (",")}")
    return mensajeBuilder.toString()
}
/**
* funcion para decidir si el vector dos esta dentro del uno
 *@param arrayInt1 el primer vector de numeros sobre el que comprobaremos
* @param arrayInt2 el segundo vector de numeros sobre el que comprobaremos
* @return la respuesta a la pregunta original
*/
fun comprobarCadenaIncluida(arrayInt: IntArray, arrayInt2: IntArray): String{
    var mensaje = ""
    if(arrayInt[arrayInt.size - 1] >= arrayInt2[arrayInt2.size - 1] && arrayInt[0] <= arrayInt2[0]){
        mensaje = "Confirmo que el segundo array creado, está incluido en el primero."
    }else{
        mensaje = "Confirmo que el segundo array creado, nmensaje = \"Confirmo que el segundo array creado está incluido en el primero.\"o está incluido en el primero."
    }
    return mensaje
}