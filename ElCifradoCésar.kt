fun main(){
    var mensaje: String = ""
    val alfabeto = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ"
    val arrayAlfabeto: CharArray = alfabeto.toCharArray()
    println("Porfavor itroduzca el mensaje que quieras que cifremos usando cifrado césar:")
    mensaje = readln()
    var mensajes: CharArray = mensaje.toCharArray()
    var desplazamiento = generarDesplazamiento("Porfavor introduzaca un valor para el desplazamiento que usaremos en codigo césar ( como minimo 1 y como máximo ${arrayAlfabeto.size}:", arrayAlfabeto)
    println(generarMensajeCifrado(desplazamiento, arrayAlfabeto, mensajes, "El mensaje introducido, pasado por cifrado césar queda así: "))
    println(generarMensajeDescifrado(desplazamiento,arrayAlfabeto, mensajes, "El mensaje introducido, pasado por el descifrador césar queda así: "))
}

/**
 * función para generar el valor de desplazamiento
 * @param mensaje mensaje explicativo de la acción a realizar
 * @param arrayAlfabeto array con los caracteres del alfabeto, tanto en mayuscula como en minuscula
 * @return valor del desplazamiento
 */
fun generarDesplazamiento(mensaje: String, arrayAlfabeto: CharArray): Int{
    println(mensaje)
    var num = 0
    do{
        num = readln().toInt()
        if(num < 1 || num > arrayAlfabeto.size ){
            println("El valor de desplazamiento creado no nos sirve, por favor introduzcalo de nuevo.")
        }
    }while(num < 1 || num > arrayAlfabeto.size )
    return num
}
/**
 *funcion para pasar a codigo cesar
 * @param desplazamiento valor del desplazamiento
 * @param arrayAlfabeto array con los caracteres del alfabeto, tanto en mayuscula como en minuscula
 *  @param mensajes array con los caracteres del mensaje
 * @param texto mensaje explicativo de la acción a realizar
 * @return el mensaje en codigo cesar
 */
fun generarMensajeCifrado(desplazamiento: Int,arrayAlfabeto: CharArray, mensajes: CharArray, texto: String): String{
    println(texto)
    var desplazamientocifrado = 0
    var posicion2 = 0
    for(caracter: Char in mensajes){
        var posicion: Int = arrayAlfabeto.indexOf(caracter)
        if(posicion == -1){
        }else{
            if((posicion + desplazamiento) < arrayAlfabeto.size) {
                desplazamientocifrado = (posicion + desplazamiento) % arrayAlfabeto.size
                mensajes[posicion2] = arrayAlfabeto[desplazamientocifrado]
            }else{
                desplazamientocifrado = ((posicion + desplazamiento) - arrayAlfabeto.size) % arrayAlfabeto.size
                mensajes[posicion2] = arrayAlfabeto[desplazamientocifrado]
            }
        }
        posicion2 = posicion2 + 1
    }
    val mensaje: String = mensajes.joinToString("")
    return mensaje
}
/**
 *funcion para pasar de codigo cesar a normal
 * @param desplazamiento valor del desplazamiento
 * @param arrayAlfabeto array con los caracteres del alfabeto, tanto en mayuscula como en minuscula
 *  @param mensajes array con los caracteres del mensaje
 * @param texto mensaje explicativo de la acción a realizar
 * @return el mensaje decodificado
 */
fun generarMensajeDescifrado(desplazamiento: Int,arrayAlfabeto: CharArray, mensajes: CharArray, texto: String): String{
    println(texto)
    var desplazamientocifrado = 0
    var posicion2 = 0
    for(caracter: Char in mensajes){
        var posicion: Int = arrayAlfabeto.indexOf(caracter)
        if(posicion == -1){
        }else{
            if((posicion - desplazamiento) < 0) {
                desplazamientocifrado = (arrayAlfabeto.size + (posicion - desplazamiento)) % arrayAlfabeto.size
                mensajes[posicion2] = arrayAlfabeto[desplazamientocifrado]
            }else{
                desplazamientocifrado = (posicion - desplazamiento) % arrayAlfabeto.size
                mensajes[posicion2] = arrayAlfabeto[desplazamientocifrado]
            }
        }
        posicion2 = posicion2 + 1
    }
    val mensaje: String = mensajes.joinToString("")
    return mensaje
}