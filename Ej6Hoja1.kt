fun main(){
    val arrayInt: IntArray = intArrayOf(0,0,0,0,0,0,0,0,0,0,0)
    val arrayInt2: IntArray = intArrayOf(0,0,0,0,0,0)
    println(pedirCadenas("Porfavor introduzca el primer número para la cadena de ${arrayInt.size} números", arrayInt))
    for(i in 0 until arrayInt.size){
        println(arrayInt[i])
    }
    println(pedirCadenas("Porfavor introduzca el primer número para la cadena de ${arrayInt2.size} números", arrayInt2))
    for(i in 0 until arrayInt2.size){
        println(arrayInt2[i])
    }
    println("${ comprobarCadenaIncluida(arrayInt, arrayInt2) }")
}
fun pedirCadenas(mensaje: String, arrayInt: IntArray): String{
    println(mensaje)
    var numero = 0
    var mensaje = "Sú cadena de números es:"
    numero = readln().toInt()
    for(i in 0 until arrayInt.size){
        arrayInt[i] = numero
        numero = numero + 1
    }
    return mensaje
}
fun comprobarCadenaIncluida(arrayInt: IntArray, arrayInt2: IntArray): String{
    var mensaje = ""
    if(arrayInt[arrayInt.size - 1] >= arrayInt2[arrayInt2.size - 1] && arrayInt[0] <= arrayInt2[0]){
        mensaje = "Confirmo que el segundo array creado, está incluido en el primero."
    }else{
        mensaje = "Confirmo que el segundo array creado, nmensaje = \"Confirmo que el segundo array creado está incluido en el primero.\"o está incluido en el primero."
    }
    return mensaje
}