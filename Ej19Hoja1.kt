import java.util.StringJoiner

fun main(){
    var saldo = 500
    var continuar = ""
    var caso = ' '
    var resultado = ""
    do {
        var apuesta = generarApuestaJugador("Por favor, introduzca su apuesta, no puede ser un valor negativo, ni estar por encima de su saldo que es: $saldo", saldo)
        val cartas: IntArray = intArrayOf(0, 2, 3, 4, 5, 6, 7, 8, 9, 10, -10, -10, -10)
        val cartasBarajadas: IntArray = intArrayOf(4, 7, 2, 10, -10, 3, 2, -10, 0, 6, -10, 5, 8)
        val jugador: IntArray = IntArray(8)
        val ordenador: IntArray = IntArray(8)
        resultado = "${jugar(cartasBarajadas, jugador, ordenador, saldo, apuesta)}"
        println(resultado)
        caso = resultado[resultado.length - 1].toChar()
        saldo = generarSaldo(saldo, caso, apuesta)
        println("Su saldo ahora es de: $saldo")
        continuar = continuar("Deseas continuar jugando?(s/n)")
    }while(continuar == "s" && saldo > 0)
    if(continuar == "s"){
        println("No puedes continuar, porque no tienes suficiente saldo.")
    }
    println("Cerrando juego...")
    Thread.sleep(1000)
    println("Juego cerrado.")
}

/**
 * funcion que sirve para que el jugador introduzca su apuesta
 * @param mensaje texto informativo del proceso a realizar
 * @param saldo dinero que le queda al jugador
 * @return el dinero apostado
 */
fun generarApuestaJugador(mensaje: String, saldo: Int): Int{
    println(mensaje)
    var apuesta = 0
    do{
        apuesta = readln().toInt()
        if(apuesta > saldo || apuesta <= 0){
            println("Te dije que el numero no podia ser ni negativo , ni mayor que tu saldo actual que es: $saldo. Prueba de nuevo con tu apuesta: ")
        }
    }while(apuesta > saldo || apuesta <= 0)
    return apuesta
}
fun jugar(cartasB: IntArray, jugador: IntArray, ordenador: IntArray, saldo: Int, apuesta: Int): String{
    var posicion = 0
    var contO = 0
    var contJ = 0
    var turno = "jugador"
    var valorJ = 0
    var valorO = 0
    var continuar = ""
    do {
        turno = "jugador"
        if (turno == "jugador" && valorJ < 21) {
            posicion = generarPosicion(cartasB)
            jugador[contJ] = cartasB[posicion]
            cartasB[posicion] = -1
            if (jugador[contJ] == 0) {
                valorJ = valorJ + generarValor("Sacaste una carta especial, el as, ahor elige si quires que se le sume un 1 o un 11 a tus puntos:")
                println("Ahora tienes $valorJ puntos.")
            }
            if(jugador[contJ] == -10){
                println("Ha salido una figura, la cual vale 10 puntos.")
                valorJ = valorJ + 10
                println("Ahora tienes $valorJ puntos.")
            }
            if(jugador[contJ] != 0 && jugador[contJ] != -10){
                println("Ha salido una carta normal de valor: ${jugador[contJ]}.")
                valorJ = valorJ + jugador[contJ]
                println("Ahora tienes $valorJ puntos.")
            }
            contJ = contJ + 1
            turno = "ordenador"
        }
        if (turno == "ordenador" && valorO < 21) {
            posicion = generarPosicion(cartasB)
            ordenador[contO] = cartasB[posicion]
            cartasB[posicion] = -1
            if (ordenador[contO] == 0) {
                valorO = valorO + 1
            }
            if(ordenador[contO] == -10){
                valorO = valorO + 10
            }
            if(ordenador[contO] != 0 && ordenador[contO] != -10){
                valorO = valorO + ordenador[contO]
            }
            contO = contO + 1
            turno = "Jugador"
        }
        continuar = continuar("Deseas continuar sacando cartas?(s/n)")
    }while(continuar == "s" && valorJ < 21)
    if(continuar == "s"){
        println("Aunque deses continuar, no puedes seguir jugando.")
    }
    var caso = generarCaso(valorJ, valorO)
    var mensajeBuilder = StringBuilder()
    if(caso == 1){
        mensajeBuilder.append("Ha ganado el jugador. Es el caso = 1")
    }else{
        if(caso == 2){
            mensajeBuilder.append("Ha ganado el ordenador. Es el caso = 2")
        }else{
            mensajeBuilder.append("El jugador y el ordenador, han empatado en puntos. Es el caso = 3")
        }
    }
    return "$mensajeBuilder"
}
fun generarPosicion(cartasB: IntArray): Int{
    var posicion = (0 until cartasB.size).random()
    do {
        if (cartasB[posicion] == -1) {
            posicion = (0 until cartasB.size).random()
        }
    }while(cartasB[posicion] == -1)
    return posicion
}
fun generarValor(mensaje: String): Int{
    println(mensaje)
    var numero = 0
    do {
        numero = readln().toInt()
        if(numero !== 1 && numero != 11){
            println("Ese no es un valor permitido. Prueba de nuevo:")
        }
    }while(numero !== 1 && numero != 11)
    return numero
}
fun continuar(mensaje: String): String{
    println(mensaje)
    var continuar = readln().lowercase()
    return continuar
}
fun generarCaso(valorJ: Int, valorO: Int): Int{
    var caso = 0
    if(valorJ > 21 && valorO > 21){
        caso = 3
    }
    if(valorJ == 21 && valorO == 21){
        caso = 3
    }
    if(valorJ == valorO){
        caso = 3
    }
    if(valorJ < 21 && valorO > 21){
        caso = 1
    }
    if(valorJ > 21 && valorO < 21){
        caso = 2
    }
    if(valorJ == 21 && valorO < 21){
        caso = 1
    }
    if(valorJ < 21 && valorO == 21){
        caso = 2
    }
    if(valorJ < 21 && valorO < 21){
        if(valorJ > valorO){
            caso = 1
        }else{
            caso = 2
        }

    }
    return caso
}
fun generarSaldo(saldo: Int, caso: Char, apuesta: Int): Int{
    var saldos = saldo
    if(caso == '1'){
        saldos = saldos + apuesta
    }else{
        if(caso == '2'){
            saldos = saldos - apuesta
        }else{
        }
    }
    return saldos
}
/**
 * No consigo que funcione una funcion que me permita barajar el array si que se repitan posiciones.
 * fun barajarCartas(cartas: IntArray): IntArray{
    val barajar: IntArray = intArrayOf(-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9,-9)
    var pos = (0..12).random()
    for(i in cartas) {
        while(barajar[pos] != 9){
            barajar[pos] = i
            pos = (0..12).random()
        }
    }
    return barajar
}
 */
