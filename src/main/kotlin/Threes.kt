

val set = mutableListOf<String>("A", "B", "C")
val result = mutableListOf<Boolean>(false, false, false)

fun generateSubsets(i: Int){
    if(i == result.size){
        printSubset()
        return
    }

    result[i] = true
    generateSubsets(i+1)

    result[i] = false
    generateSubsets(i+1)
}

fun printSubset() {
    var resultString = ""
    result.forEachIndexed { i, v ->
        if(v){
            resultString += set[i]
        }
    }
    println(resultString)
}


