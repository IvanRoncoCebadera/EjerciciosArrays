fun main(){
    val arrayInt: IntArray = intArrayOf(1,2,3,4,5,6)
    val arrayInt2: IntArray = intArrayOf(0,0,0,0,0,0)
    var cont = 0
    cont = arrayInt.size - 1
    for(i in 0 until  arrayInt.size){
        println("${arrayInt[i]} y ${arrayInt[cont]}")
        arrayInt2[cont] = arrayInt[i]
        if(cont > 0) {
            cont = cont - 1
        }
    }

}