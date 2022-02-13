

val set = mutableListOf<String>("A", "B", "C", "D")
val result = set.map { v -> false }.toMutableList()


fun generateSubsets(i: Int, lengthSubset:Int, countTrue:Int){
    if(i == result.size){
        if(countTrue == lengthSubset){
            printSubset()
        }
        return
    }


    result[i] = true
    generateSubsets(i+1, lengthSubset, countTrue+1)

    result[i] = false
    generateSubsets(i+1, lengthSubset, countTrue)
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


