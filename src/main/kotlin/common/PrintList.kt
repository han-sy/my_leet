package common

fun printList(array : IntArray) {
    var result = ""
    for( a in array) {
        if(result.isNotBlank()) {
            result += ", "
        }
        result += a
    }
    println(result)
}