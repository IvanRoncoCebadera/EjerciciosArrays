fun main(){
    val arrayIntJugador: IntArray = IntArray(20){0}
    val arrayIntOrdenador: IntArray = IntArray(20){0}
    println(colocarBarcosJugador("Introduzca los barcos de una casilla entre las distintas posiciones posibles, que son de 1  a ${arrayIntJugador.size}", arrayIntJugador))
    println(colocarBarcosOrdenador("Los barcos del ordenador se colocaran aleatoriamiente entre las casillas de 1 a ${arrayIntOrdenador.size}", arrayIntOrdenador))
    println(jugar("Empieza el juego y es el turno del jugador, trata de golpear todos los barcos del rival y ganar, se te informara cuando des un tiro o uno de tus barcos reciba un tiro.", arrayIntJugador, arrayIntOrdenador))
}

/**
 * procedimiento para colocar los barcos del jugador segun el decida
 * @param mensaje texto descriptivo de la accion a elavorar
 * @param arrayInt vector de numero donde colocaremos los barcos, los barcos se representan con el numero 1
 */
fun colocarBarcosJugador(mensaje: String, arrayInt: IntArray){
    println(mensaje)
    var posicion2 = 0
    var posicion = 0
    posicion2 = readln().toIntOrNull() ?: -1
    if(posicion2 !in (1 .. arrayInt.size)){
        println("Ese valor de posicion no esta permitido.")
    }
    posicion = posicion2 - 1
    arrayInt[posicion] = 1
    for(i in 1 .. 3){
        do {
            println("Vuelva a introducir una posicion para el siguiente barco:")
            posicion2 = readln().toIntOrNull() ?: -1
            if(posicion2 !in (1 .. arrayInt.size)){
                println("Ese valor de posicion no esta permitido.")
            }
            posicion = posicion2 - 1
            if (arrayInt[posicion] == 1) {
                println("Esa posicion ya esta tomada, no sirve.")
            }
        }while(arrayInt[posicion] == 1)
        arrayInt[posicion] = 1
    }
}
/**
 * procedimiento para colocar los barcos del ordenador aleatoriamente
 * @param mensaje texto descriptivo de la accion a elavorar
 * @param arrayInt vector de numero donde colocaremos los barcos, los barcos se representan con el numero 1
 */
fun colocarBarcosOrdenador(mensaje: String, arrayIntS: IntArray){
    println(mensaje)
    var posicion = (0 until  arrayIntS.size).random()
    arrayIntS[posicion] = 1
    for(i in 1 .. 3){
        do {
            posicion = (0 until  arrayIntS.size).random()
        }while(arrayIntS[posicion] == 1)
        arrayIntS[posicion] = 1
    }
}
/**
 * procedimiento para colocar los barcos del jugador segun el decida
 * @param mensaje texto descriptivo de la accion a elavorar
 * @param arrayIntJ vector de numero donde estan los barcos del jugador, los barcos se representan con el numero 1
 * @param arrayIntO vector de numero donde estan los barcos del ordenador, los barcos se representan con el numero 1
 * return mensaje de quien es el ganador
 */
fun jugar(mensaje: String, arrayIntJ: IntArray, arrayIntO: IntArray): String{
    println(mensaje)
    var turno = "jugador"
    var contadorJ = 0
    var contadorO = 0
    var posicionJ = 0
    var posicionJ2 = 0
    var posicionO = 0
    var posicionJC = ""
    var mensajeBuilder = StringBuilder()
    do{
        if(turno == "jugador"){
            println("Introduzca la posicion en la que desea colocar su barco, tienes de la 1 a la 20:")
            posicionJ2 = readln().toIntOrNull() ?: -1
            if(posicionJ2 !in (1 .. arrayIntJ.size)){
                println("Ese valor de posicion no esta permitido.")
            }
            posicionJ = posicionJ2 - 1
            if(arrayIntO[posicionJ] == 1){
                contadorJ = contadorJ + 1
                if(contadorJ >= 4){
                    mensajeBuilder.append("Felicidades, diste a todos los barcos enemigos y ganaste el juego.")
                }else {
                    turno = "ordenador"
                    println("Felicidades le has dado a uno de los barcos del rival, le quedan ${4 - contadorJ} barcos. Ahora le toca al ordenador.")
                }
            }else{
                turno = "ordenador"
                println("Has fallado, no hab??a ning??n barco es esa posici??n, le quedan ${4 - contadorJ} barcos, ahora le toca al ordenador.")

            }
            posicionJC = "$posicionJC $posicionJ2,"
            println("Llevas golpeadas las posiciones: $posicionJC ")
            Thread.sleep(2000)
        }
        if (turno == "ordenador") {
            posicionO = (0 until arrayIntO.size).random()
            if (arrayIntO[posicionO] == 1) {
                contadorO = contadorO + 1
                if (contadorO == 4) {
                    mensajeBuilder.append("Perdiste, el ordenador golpe?? todos tus barcos.")
                } else {
                    turno = "jugador"
                    println("Maldici??n, el ordenador golpe?? un barco, te qued??n ${4 - contadorO} barcos. Ahora te toca a t??.")
                }
            } else {
                turno = "jugador"
                println("Bien, el ordenador fall?? al intentar golpear tus barcos,  te qued??n ${4 - contadorO} barcos, ahora vas t??")

            }
        }

    }while(contadorJ < 4 && contadorO < 4)
    return mensajeBuilder.toString()
}