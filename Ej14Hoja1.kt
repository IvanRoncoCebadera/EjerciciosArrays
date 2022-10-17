fun main(){
    val arrayInt: IntArray = intArrayOf(0,0,0,0,0,0,0,0)
    println("Debes introducir un número del 0 al ${arrayInt.size - 1} para elegir una posición donde puede estar la mosca.")
    println(matarMosca(arrayInt))
}
fun matarMosca(arrayInt: IntArray): String{
    var mensaje = ""
    var i = (0..7).random()
    arrayInt[i] = 1
    do{
        var num = readln().toInt()
        if (arrayInt[num] == 1) {
            mensaje = "Felicidades has ganado, mataste a la mosca que estaba en la posicion $num."
        }else{
            if(arrayInt[num - 1] == 1 || arrayInt[num + 1] == 1) {
                for(i in 0 until arrayInt.size){
                    arrayInt[i] = 0
                }
                i = (0..7).random()
                arrayInt[i] = 1
                println("Has fallado, pero estuviste cerca y la mosca se alejó, prueba de nuevo.")
            }else{
                println("Has fallado, no estuviste ni cerca, prueba de nuevo.")
            }
        }
    }while(arrayInt[num] != 1)
    return "$mensaje"
}