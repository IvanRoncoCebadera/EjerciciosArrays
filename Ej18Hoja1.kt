fun main(){
    var arrayInt: IntArray = IntArray(20){0}
    println(generarMinas("Se van a generar aleatoriamente las minas.", arrayInt))
    println(jugarMinas("Una vez repartidas las minas es hora de jugar, el juego consiste en destapar todas las casillas de un vector menos las minas, si pisas las minas pierdes. Ademas, se te ayudará dandote pistas de donde estan las minas, indicando con un número el número de minas adyacentes a la posición seleccionada.", arrayInt))

}

/**
 * funcion para generar la poscion de las minas aleatoriamente, las minas son el numero: 9
 * @param mensaje mensaje descriptivo de la operacion que se va a realizar
 * @param arrayInt el vector de numeros sobre el que crearemos las minas
 */
fun generarMinas(mensaje: String, arrayInt: IntArray){
    println(mensaje)
    var posicion = 0
    var posicion2 = 0
    for(i in 1 .. 6){
        do {
            do {
                posicion2 = posicion
                posicion = (0 until arrayInt.size).random()
            }while(posicion2 == posicion)
            generarNumeroAdyacente(posicion, arrayInt)
        }while(arrayInt[posicion] == 9)
        arrayInt[posicion] = 9
    }
    println(arrayInt.joinToString())
}

/**
 * funcion para generar la poscion de las minas aleatoriamente, las minas son el numero: 9
 * @param posicion es la poscion del vector de numeros
 * @param arrayInt el vector de numeros sobre el que crearemos las mina
 * @return el array de numeros tras colocar los 0, 1 o 2 correspondintes al lado de las minas
 */
fun generarNumeroAdyacente(posicion: Int, arrayInt: IntArray): IntArray{
    var arrayInt = arrayInt
    var texto = ""
    if(posicion > 0 || posicion < (arrayInt.size - 1)) {
        if(posicion == 0){
            if(arrayInt[posicion + 1] == 9){
            }else{
                if(arrayInt[posicion + 2] == 9){
                    arrayInt[posicion + 1] = 2
                }else{
                    arrayInt[posicion + 1] = 1
                }
            }
        }else {
            if (posicion == 1) {
                if (arrayInt[posicion + 1] == 9) {
                } else {
                    if (arrayInt[posicion + 2] == 9) {
                        arrayInt[posicion + 1] = 2
                    } else {
                        arrayInt[posicion + 1] = 1
                    }
                }
                if (arrayInt[posicion - 1] == 9) {
                } else {
                    arrayInt[posicion - 1] = 1
                }
            }else {
                if (posicion == arrayInt.size - 1) {
                    if (arrayInt[posicion - 1] == 9) {
                    } else {
                        if (arrayInt[posicion - 2] == 9) {
                            arrayInt[posicion - 1] = 2
                        } else {
                            arrayInt[posicion - 1] = 1
                        }
                    }
                }else {
                    if (posicion == (arrayInt.size - 2)) {
                        if (arrayInt[posicion - 1] == 9) {
                        } else {
                            if (arrayInt[posicion - 2] == 9) {
                                arrayInt[posicion - 1] = 2
                            } else {
                                arrayInt[posicion - 1] = 1
                            }
                        }
                        if (arrayInt[posicion + 1] == 9) {
                        } else {
                            arrayInt[posicion + 1] = 1
                        }
                    }else{
                        if (arrayInt[posicion - 1] == 9) {
                        } else {
                            if (arrayInt[posicion - 2] == 9) {
                                arrayInt[posicion - 1] = 2
                            } else {
                                arrayInt[posicion - 1] = 1
                            }
                        }
                        if (arrayInt[posicion + 1] == 9) {
                        } else {
                            if (arrayInt[posicion + 2] == 9) {
                                arrayInt[posicion + 1] = 2
                            } else {
                                arrayInt[posicion + 1] = 1
                            }
                        }
                    }
                }
            }
        }
    }
    return arrayInt
}

/**
 * funcion para jugar al buscaminas, las minas son el numero: 9
 * @param mensaje mensaje descriptivo de la operacion que se va a realizar
 * @param arrayInt el vector de numeros sobre el que crearemos las minas
 */
fun jugarMinas(mensaje: String, arrayInt: IntArray) {
    println(mensaje)
    var posicion = 0
    var contador = 0
    var lista = ""
    do {
        do {
            println("Introduzca la posicion que desea mirar, tienes de la 1 a la 20:")
            posicion = readln().toIntOrNull() ?: -1
            if(posicion !in (1 .. arrayInt.size)){
                println("Ese valor de posicion no esta permitido.")
            }
        }while(posicion !in (1 .. arrayInt.size))
        var posicion2 = posicion - 1
        if (arrayInt[posicion2] == 9) {
            contador = contador + 14
            println("Perdiste, en esa posición había una mina.")
        } else {
            contador = contador + 1
            println("Esa posición no tenía minas, y el número de minas ayacentes asociado a esa posición es de ${arrayInt[posicion2]}")
            lista = "$lista $posicion,"
            println("Las posiciones que ha probado por ahora son: $lista")
        }
        Thread.sleep(2000)
    }while(contador < 14)
}
