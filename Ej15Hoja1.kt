fun main(){
    val arrayInt: IntArray = intArrayOf(1,2,4,5,2,5,4,1)
    println(encontraParejas(arrayInt, "Debes introducir un número del 0 al ${arrayInt.size - 1} para elegir una posición de las casillas diponibles."))
}
fun encontraParejas(arrayInt: IntArray, mensaje: String): String{
    var numero1 = 0
    var numero2 = 0
    var numero3 = 0
    var numero4 = 0
    var contador = 0
    var mensajes = "Fin"
    do{
        println(mensaje)
        var num = readln().toInt()
        println("La posicion elegida tiene el número: ${arrayInt[num]}. Vuelva a introducir otro número diferente para tratar de encontrar la casilla con el mismo número.")
        do {
            numero1 = readln().toInt()
            if (arrayInt[num] == arrayInt[numero1]) {
                println("Felicidades, has encontrado la pareja del número ${arrayInt[num]} ")
                contador = contador + 1
            } else {
                println("Has fallado el numero de la posicion $num era ${arrayInt[num]}.")
                Thread.sleep(1000)
            }
        }while(contador < 1)
        println("$mensaje, ten en cuenta que ya conoces los número de una pareja.")
        var nume = 0
        do {
            nume = readln().toInt()
            if (nume == num || nume == numero1) {
                println("Ese número ya lo has usado antes, no tiene sentido volver a usarlo." +
                        "Introduzca otro número:")
            }
        }while(nume == num || nume == numero1)
        println("La posicion elegida tiene el número: ${arrayInt[nume]}. Vuelva a introducir otro número diferente para tratar de encontrar la casilla con el mismo número.")
        do {
            numero2 = readln().toInt()
            if (arrayInt[nume] == arrayInt[numero2]) {
                println("Felicidades, has encontrado la pareja del número ${arrayInt[nume]} ")
                contador = contador + 1
            } else {
                println("Has fallado el numero de la posicion $nume era ${arrayInt[nume]}.")
                Thread.sleep(1000)
            }
        }while(contador < 2)
        println("$mensaje, ten en cuenta que ya conoces los número de una pareja.")
        var numer = 0
        do {
            numer = readln().toInt()
            if (numer == num || numer == numero1 || numer == nume || numer == numero2) {
                println("Ese número ya lo has usado antes, no tiene sentido volver a usarlo." +
                        "Introduzca otro número:")
            }
        }while(numer == num || numer == numero1 || numer == nume || numer == numero2)
        println("La posicion elegida tiene el número: ${arrayInt[numer]}. Vuelva a introducir otro número diferente para tratar de encontrar la casilla con el mismo número.")
        do {
            numero3 = readln().toInt()
            if (arrayInt[numer] == arrayInt[numero3]) {
                println("Felicidades, has encontrado la pareja del número ${arrayInt[numer]} ")
                contador = contador + 1
            } else {
                println("Has fallado el numero de la posicion $numer era ${arrayInt[numer]}.")
                Thread.sleep(1000)
            }
        }while(contador < 3)
        println("$mensaje, ten en cuenta que ya conoces los número de una pareja.")
        var numero = 0
        do {
            numero = readln().toInt()
            if (numero == num || nume == numero1 || numero == nume || numero == numero2 || numero == numer || numero == numero3) {
                println("Ese número ya lo has usado antes, no tiene sentido volver a usarlo." +
                        "Introduzca otro número:")
            }
        }while(numero == num || nume == numero1 || numero == nume || numero == numero2 || numero == numer || numero == numero3)
        println("La posicion elegida tiene el número: ${arrayInt[numero]}. Vuelva a introducir otro número diferente para tratar de encontrar la casilla con el mismo número.")
        do {
            numero4 = readln().toInt()
            if (arrayInt[numero] == arrayInt[numero4]) {
                println("Felicidades, has encontrado la pareja del número ${arrayInt[numero]} ")
                contador = contador + 1
            } else {
                println("Has fallado el numero de la posicion $numero era ${arrayInt[numero]}.")
                Thread.sleep(1000)
            }
        }while(contador < 4)
    }while(contador < 4)
    return mensajes
}