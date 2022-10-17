fun main(){
    val arrayInt: IntArray = intArrayOf (-1,7,-3,78,-23,89)
    var resultado = 0.0
    println("Ahora pondre todos los valores del array en orden de mayor a menor: ${generarNumerosOrdenMayorMenor(arrayInt)}")
    println("Ahora mostrare solo el máximo valor del array: ${encontrarMayor(arrayInt)}")
    println("Ahora mostrare solo el mínimo valor del array: ${encontrarMenor(arrayInt)}")
    println("La media de los números del array es: ${generarMediaVector(arrayInt)}")
}

/**
 * Para generar el orden de mayor a menor de los números de un vector. ***No funciona***.
 * @param arrayInt
 * @return mensaje Es la cadena de los números ordenados de mayor a menor
 */
fun generarNumerosOrdenMayorMenor(arrayInt: IntArray): String{
    var mensaje = ""
    var i = 0
    mensaje = "${arrayInt[i]}"
    for(i in 1 until arrayInt.size){
        if(arrayInt[i] > arrayInt[i - 1]){
            mensaje = "${arrayInt[i]}, $mensaje"
        }else{
            mensaje = "$mensaje, ${arrayInt[i]}"
        }
    }
    return mensaje
}

/**
 * Nos imprime el valor maximo de todos los del array
 * @param arrayInt
 * @return max el numero maximo del array
 */
fun encontrarMayor(arrayInt: IntArray): Int{
    var max = 0
    for(i in 0 until arrayInt.size){
        if(arrayInt[i] > max){
            max = arrayInt[i]
        }
    }
    return max
}
/**
 * Nos imprime el valor minimo de todos los del array
 * @param arrayInt
 * @return min el numero minimo del array
 */
fun encontrarMenor(arrayInt: IntArray): Int {
    var min = 0
    for (i in 0 until arrayInt.size) {
        if (arrayInt[i] < min) {
            min = arrayInt[i]
        }
    }
    return min
}

/**
 * Nos genera la media de todos los valores del array
 * @param arrayInt
 * @return media es el resultado de la operacion para calcular la media
 */
fun generarMediaVector(arrayInt: IntArray): Int{
    var resultado = 0
    var media = 0
    for(i in 0 until arrayInt.size){
        resultado = resultado + arrayInt[i]
    }
    media = resultado / arrayInt.size
    return media
}