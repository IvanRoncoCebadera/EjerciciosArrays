fun main(){
    val arrayChar: CharArray = CharArray (3)
    println(pedirCaden("Introduce un total de ${arrayChar.size} letras, y te dire si tú palabra es palímdroma o no.", arrayChar))
    println(comprobarCapicuos (arrayChar))
}
fun pedirCaden(mensaje: String, arrayChar: CharArray): String{
    println(mensaje)
    var mensaje = ""
    for(i in 0 until arrayChar.size){
        arrayChar[i] = readLine()!![0]
    }
    mensaje = "Su palabra es: "
    return mensaje
}
fun comprobarCapicuos(arrayChar: CharArray): String{
    var mensaje = ""
    if (arrayChar[arrayChar.size - 1] == arrayChar[0]){
        mensaje = "Es palímdroma."
    }else{
        mensaje = "No es palímdroma."
    }
    return mensaje
}