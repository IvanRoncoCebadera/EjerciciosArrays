fun main(){
    val arrayInt: IntArray = IntArray(20){0}
    println(generarMinas("Se van a generar aleatoriamente las minas.", arrayInt))
    println(jugarMinas("Una vez repartidas las minas es hora de jugar, el juego consiste en destapar todas las casillas de un vector menos las minas, si pisas las minas pierdes. Ademas, se te ayudará dandote pistas de donde estan las minas, indicando con un número el número de minas adyacentes a la posición seleccionada.", arrayInt))

}
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
        }while(arrayInt[posicion] == 9)
        arrayInt[posicion] = 9
    }
    println(arrayInt.joinToString())
}

fun jugarMinas(mensaje: String, arrayInt: IntArray) {
    println(mensaje)
    var posicion = 0
    var contador = 0
    var lista = ""
    do {
        println("Introduzca la posicion que desea mirar:")
        posicion = readln().toInt()
        if (arrayInt[posicion] == 9) {
            contador = contador + 14
            println("Perdiste, en esa posición había una mina.")
        } else {
            contador = contador + 1
            println("Esa posición no tenía minas, y el número de minas ayacentes asociado a esa posición es de ${arrayInt[posicion]}")
            lista = "$lista $posicion,"
            println("Las posiciones que ha probado por ahora son: $lista")
        }
    }while(contador < 14)
}
