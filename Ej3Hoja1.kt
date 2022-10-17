fun main(){
    val arrayInt1: IntArray = intArrayOf(0,1,2,3,4,5,6,7,8,9)
    val arrayInt2: IntArray = intArrayOf(0,1,2,3,4,5,6,7,8,9)
    var operacion = decirOperacion("""Por favor, eliga si desea "sumar", "restar" o calcular el "producto escalar".""")
    println("Usted ha elegido la operacion: $operacion")
    println("El resultado de la operación es: ${resultado(operacion, arrayInt1, arrayInt2)}")

}
/**
 *Es donde se determina que operación vamos a hacer
 * @param mensaje un mensaje explicativo que indica las posible operaciones
 * @return operacion el numero con el que se entendera que operacion hacer mas adelante
 */
fun decirOperacion(mensaje: String): Int{
    println(mensaje)
    var lectura = ""
    var operacion = 0
    if(leerOperacion(lectura) == "sumar") {
        operacion = 1
    }else{
        if(leerOperacion(lectura) == "restar") {
            operacion = 2
        }else{
            operacion = 3
        }
    }
    return operacion
}
/**
 *Calculo del resultado de la operacion
 * @param operacion Numero que indica la operacion a realizar
 * @param arrayInt1 El primero de los vectores con los que opero
 * @param arrayInt2 El segundo de los vectores con los que opero
 */
fun resultado(operacion: Int, arrayInt1: IntArray, arrayInt2: IntArray): Int {
    var posicion1 = 0
    var posicion2 = 0
    var resultado = 0
    if(operacion == 1){
        resultado = sumar(elegirNumero1(posicion1, arrayInt1), elegirNumero2(posicion2, arrayInt2))
    }
    if(operacion == 2){
        resultado = restar(elegirNumero1(posicion1, arrayInt1), elegirNumero2(posicion2, arrayInt2))
    }
    if(operacion == 3){
        resultado = productoEscalar(elegirNumero1(posicion1, arrayInt1),elegirNumero2(posicion2, arrayInt2))
    }
    return resultado
}
/**
 *La funcion sumar
 * @param num1 numero elegido del primer vector
 * @param num2 numero elegido del segundo vector
 * @return res resultado de la suma
 */
fun sumar(num1: Int,num2: Int): Int{
    var res = num1 + num2
    return res
}
/**
 *La funcion restar
 * @param num1 numero elegido del primer vector
 * @param num2 numero elegido del segundo vector
 * @return res resultado de la resta
 */
fun restar(num1: Int,num2: Int): Int{
    var res = num1 - num2
    return res
}
/**
 *La funcion producto escalar
 * @param num1 numero elegido del primer vector
 * @param num2 numero elegido del segundo vector
 * @return resultado del producto escalar
 */
fun productoEscalar(num1: Int,num2: Int): Int{
    var res = 1
    for(i in 0 until num2){
        res = res * num1
    }
    return res
}

/**
 * leemos que operacion vamos a realizar
 * @param lectura escrito la operacion en texto
 * @return lectura escrito la operacion en texto
 */
fun leerOperacion(lectura: String): String{
    var lectura = ""
    do{
        lectura = readln()
        if(lectura != "sumar" && lectura != "restar" && lectura != "producto escalar"){
            println("No ha introducido una operación disponible, pruebe de nuevo.")
        }
    }while(lectura != "sumar" && lectura != "restar" && lectura != "producto escalar")
    return lectura
}

/**
 * Donde elegimos el segundo numero para operar
 * @param posicion2 la posicion elegida del segundo vector
 * @param arrayInt2 el segundo vector
 */
fun elegirNumero2(posicion2: Int, arrayInt2: IntArray): Int{
    println("Ahora elige una posición del segundo array(del 0 al 9) para elegir un numero(del 0 al 9):")
    var posicion2 = readln().toInt()
    var num2 = arrayInt2[posicion2]
    return num2
}
/**
 * Donde elegimos el segundo numero para operar
 * @param posicion1 la posicion elegida del primer vector
 * @param arrayInt1 el primer vector
 */
fun elegirNumero1(posicion1: Int, arrayInt1: IntArray): Int{
    println("Elige una posición del primer array(del 0 al 9) para elegir un numero(del 0 al 9):")
    var posicion1 = readln().toInt()
    var num1 = arrayInt1[posicion1]
    return num1
}
