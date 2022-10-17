fun main(){
    val arrayIntJugador: IntArray = IntArray(20){0}
    val arrayIntOrdenador: IntArray = IntArray(20){0}
    println(colocarBarcosJugador("Introduzca los barcos de una casilla entre las distintas posiciones posibles, que son de 0  a ${arrayIntJugador.size - 1}", arrayIntJugador))
    println(colocarBarcosOrdenador("Los barcos del ordenador se colocaran aleatoriamiente entre las casillas de 0 a ${arrayIntOrdenador.size - 1}", arrayIntOrdenador))
    println(jugar("Empieza el juego y es el turno del jugador, trata de golpear todos los barcos del rival y ganar, se te informara cuando des un tiro o uno de tus barcos reciba un tiro.", arrayIntJugador, arrayIntOrdenador))
}
fun colocarBarcosJugador(mensaje: String, arrayInt: IntArray){
    println(mensaje)
    var posicion = 0
    println("Introduzca la posicion del primer barco:")
    posicion = readln().toInt()
    arrayInt[posicion] = 1
    for(i in 1 .. 3){
        do {
            println("Vuelva a introducir una posicion para el sigueinte barco:")
            posicion = readln().toInt()
            if (arrayInt[posicion] == 1) {
                println("Esa posicion ya esta tomada, no sirve.")
            }
        }while(arrayInt[posicion] == 1)
        arrayInt[posicion] = 1
    }
}

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
fun jugar(mensaje: String, arrayIntJ: IntArray, arrayIntO: IntArray): String{
    println(mensaje)
    var turno = "jugador"
    var contadorJ = 0
    var contadorO = 0
    var posicionJ = 0
    var posicionO = 0
    var posicionJC = ""
    var mensaje = ""
    do{
        if(turno == "jugador"){
            println("Introduce la posición que deseas atacar:")
            posicionJ = readln().toInt()
            if(arrayIntO[posicionJ] == 1){
                contadorJ = contadorJ + 1
                if(contadorJ >= 4){
                    mensaje = "Felicidades, diste a todos los barcos enemigos y ganaste el juego."
                }else {
                    turno = "ordenador"
                    println("Felicidades le has dado a uno de los barcos del rival, le quedan ${4 - contadorJ} barcos. Ahora le toca al ordenador.")
                }
            }else{
                turno = "ordenador"
                println("Has fallado, no había ningún barco es esa posición, le quedan ${4 - contadorJ} barcos, ahora le toca al ordenador.")

            }
            posicionJC = "$posicionJC $posicionJ,"
            println("Llevas golpeadas las posiciones: $posicionJC ")
            Thread.sleep(2000)
        }
        if (turno == "ordenador") {
            posicionO = (0 until arrayIntO.size).random()
            if (arrayIntO[posicionO] == 1) {
                contadorO = contadorO + 1
                if (contadorO == 4) {
                    mensaje = "Perdiste, el ordenador golpeó todos tus barcos."
                } else {
                    turno = "jugador"
                    println("Maldición, el ordenador golpeó un barco, te quedán ${4 - contadorO} barcos. Ahora te toca a tí.")
                }
            } else {
                turno = "jugador"
                println("Bien, el ordenador falló al intentar golpear tus barcos,  te quedán ${4 - contadorO} barcos, ahora vas tú")

            }
        }

    }while(contadorJ < 4 && contadorO < 4)
    return mensaje
}