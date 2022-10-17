fun main(){
    val arrayInt: IntArray = intArrayOf(0,0,0,0,0,0,0,0,0)
    var numero = 0
    println("Introduce un número para inicializar la cadena:")
    numero = readln().toInt()
    println("${generarCadena(arrayInt, numero)}")
}
fun generarCadena(arrayInt: IntArray, numero: Int): String {
    var mensaje = ""
    var res = numero
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
