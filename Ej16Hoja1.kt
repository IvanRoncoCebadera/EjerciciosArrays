fun main(){
    val arrayInt: IntArray = intArrayOf(0,0,0,0,0,0,0,0,0,0,0,0)
    println("Introduzca primero un valor para la distancia a recorrer la piedra de 0 a ${arrayInt.size - 1}, y un valor de potencia de 1 a ${arrayInt.size}.")
    var distancia = readln().toInt()
    var potencia = readln().toInt()
    println(generarOnda(arrayInt, distancia, potencia))
}
fun generarOnda(arrayInt: IntArray, distancia: Int, potencia: Int){
    var pot = potencia
    var dis = distancia
    var pot1 = potencia - 1
    var dis1 = distancia + 1
    var pot2 = potencia - 1
    var dis2 = distancia - 1
    var contador1 = 1
    var contador2 = 1
    var mensaje = ""
    while(pot > 0) {
        for (i in 0..potencia) {
            arrayInt[dis] = pot
            pot = pot - 1
            if (distancia < arrayInt.size && distancia > 0 && potencia < arrayInt.size) {
                for (i in distancia + 1..arrayInt.size) {
                    while (dis1 < arrayInt.size && pot1 >= 0) {
                        arrayInt[dis1] = pot1
                        dis1 = dis1 + 1
                        pot1 = pot1 - 1
                    }
                }
                contador1 = contador1 + 1
                dis1 = distancia + 1
                pot1 = potencia - contador1
                for (i in 0 until distancia - 1) {
                    while (dis2 >= 0 && pot2 >= 0) {
                        arrayInt[dis2] = pot2
                        dis2 = dis2 - 1
                        pot2 = pot2 - 1
                    }
                }
                contador2 = contador2 + 1
                dis2 = distancia - 1
                pot2 = potencia - contador2
            }else {
                println("Hubo un error, lo datos metidos no valen, prueba de nuevo.")
            }
            println(arrayInt.joinToString())
            Thread.sleep(1000)
        }
    }
}