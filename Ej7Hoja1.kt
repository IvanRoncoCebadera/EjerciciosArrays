fun main(){
    val arrayInt: IntArray = intArrayOf(0,0,0,0,0)
    println(pedirCadena("Introduce un total de ${arrayInt.size} números, y te dire si tú cadena es capicua o no.", arrayInt))
    println(comprobarCapicuo (arrayInt))
}
fun pedirCadena(mensaje: String, arrayInt: IntArray): String{
    println(mensaje)
    var mensaje = ""
    for(i in 0 until arrayInt.size){
        arrayInt[i] = readln().toInt()
    }
    mensaje = "Su cadena es: "
    return mensaje
}
fun comprobarCapicuo (arrayInt: IntArray): String{
    var mensaje = ""
    if (arrayInt[arrayInt.size - 1] == arrayInt[0] && arrayInt[arrayInt.size - 2] == arrayInt[1]){
        mensaje = "Es capicua"
    }else{
        mensaje = "No es capicua."
    }
    return mensaje
}