fun main(){
    val arrayInt: IntArray = intArrayOf (-1,7,-3,78,-23,89)
    var resultado = 0.0
    var izq = 0
    var der = arrayInt.size - 1
    var elemento = 78
    println("Ahora pondre todos los valores del array en orden de mayor a menor: ${generarNumerosOrdenMayorMenor(arrayInt)}")
    println("Ahora mostrare solo el máximo valor del array: ${encontrarMayor(arrayInt)}")
    println("Ahora mostrare solo el mínimo valor del array: ${encontrarMenor(arrayInt)}")
    println("La media de los números del array es: ${generarMediaVector(arrayInt)}")
    println("Con el metodo burbuja queda asi: ${burbuja(arrayInt).joinToString(",")}")
    println("Con el metodo seleccion queda asi: ${seleccion(arrayInt).joinToString(",")}")
    println("Con el metodo insercion queda asi: ${insercion(arrayInt).joinToString(",")}")
    println("Con el metodo shell queda asi: ${shell(arrayInt).joinToString(",")}")
    println("Con el metodo quicksort queda asi: ${quicksort(arrayInt, izq, der).joinToString(",")}")
    println("Buscamos el valor 78 con busqueda secuencial: esta en la posicion ${busquedaSecuencial(arrayInt, elemento) + 1}")
    println("Buscamos el valor 78 con busqueda binaria: esta en la posicion ${busquedaBinariaRecursiva(quicksort(arrayInt, izq, der), elemento, izq, der) + 1}")
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
fun burbuja(array: IntArray): IntArray {
    var aux: Int
    for (i in 0 until array.size) {
        for (j in 0 until array.size - 1) {
            if (array[j] > array[j + 1]) {
                aux = array[j]
                array[j] = array[j + 1]
                array[j + 1] = aux
            }
        }
    }
    return array
}
fun seleccion(array: IntArray): IntArray {
    var aux: Int
    var min: Int
    for (i in 0 until array.size) {
        min = i
        for (j in i + 1 until array.size) {
            if (array[j] < array[min]) {
                min = j
            }
        }
        aux = array[i]
        array[i] = array[min]
        array[min] = aux
    }
    return array
}
fun insercion(array: IntArray): IntArray {
    var aux: Int
    var j: Int
    for (i in 1 until array.size) {
        aux = array[i]
        j = i - 1
        while (j >= 0 && array[j] > aux) {
            array[j + 1] = array[j]
            j--
        }
        array[j + 1] = aux
    }
    return array
}
fun shell(array: IntArray): IntArray {
    var aux: Int
    var j: Int
    var intervalo = 1
    while (intervalo < array.size) {
        intervalo = intervalo * 3 + 1
    }
    while (intervalo > 0) {
        for (i in intervalo until array.size) {
            aux = array[i]
            j = i
            while (j > intervalo - 1 && array[j - intervalo] >= aux) {
                array[j] = array[j - intervalo]
                j -= intervalo
            }
            array[j] = aux
        }
        intervalo = (intervalo - 1) / 3
    }
    return array
}
fun pivote(array: IntArray, izq: Int, der: Int): Int {
    var i = izq
    var j = der
    var pivote = array[izq]
    while (i < j) {
        while (array[i] <= pivote && i < j) {
            i++
        }
        while (array[j] > pivote) {
            j--
        }
        if (i < j) {
            val aux = array[i]
            array[i] = array[j]
            array[j] = aux
        }
    }
    array[izq] = array[j]
    array[j] = pivote
    return j
}

fun quicksort(array: IntArray, izq: Int, der: Int): IntArray {
    var piv: Int
    if (izq < der) {
        piv = pivote(array, izq, der)
        quicksort(array, izq, piv - 1)
        quicksort(array, piv + 1, der)
    }
    return array
}
fun busquedaSecuencial(array: IntArray, elemento: Int): Int {
    for (i in array.indices) {
        if (array[i] == elemento) {
            return i
        }
    }
    return -1
}
fun busquedaBinariaRecursiva(array: IntArray, elemento: Int, inf: Int, sup: Int): Int {
    if (inf > sup) {
        return -1
    }
    val centro = (sup + inf) / 2
    return if (array[centro] == elemento) {
        centro
    } else if (elemento < array[centro]) {
        busquedaBinariaRecursiva(array, elemento, inf, centro - 1)
    } else {
        busquedaBinariaRecursiva(array, elemento, centro + 1, sup)
    }
}