fun main(){
    val arrayInt: IntArray = intArrayOf(0,0,0,0,0,0)
    println(generarLoteria(arrayInt))
}

/**
 * funcion para generar boletos de loteria de forma aleatoria, pero tiene un fallo, no se como evitar que se repitan los numeros a no ser que estan literalmente al lado.
 * @param arrayInt vector vacio sobre el que se crean los numeros del boleto de loteria
 * @return un mensaje donde pone los numeros del boleto de loteria
 */
fun generarLoteria(arrayInt: IntArray): String {
    val numMin = 0
    val numMax = 49
    var mensaje = ""
    for(i in 0 until arrayInt.size){
        arrayInt[i] = (numMin.. numMax).random()
        if(i > 0){
            var r = i - 1
            if(r > 0) {
                while(arrayInt[i] == arrayInt[r] && r > 0){
                    r = r - 1
                    arrayInt [i] = (numMin..numMax).random()
                }
            }
        }
        mensaje = "$mensaje ${arrayInt[i]}"
    }
    mensaje = "Su boleto de loteria es el: $mensaje"
    return mensaje
}
/**
 * No se hacer que no se repita si no esta al lado.
 */