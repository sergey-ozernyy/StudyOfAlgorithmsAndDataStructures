

val set = mutableListOf<String>("A", "B", "C", "D")
val result = //set
            (0..32)
                .map { element -> false }.toMutableList()
var subsetCount = 0


fun generateSubsets(i: Int, lengthSubset:Int, countTrue:Int){
    if(i == result.size || countTrue == lengthSubset){
        if(countTrue == lengthSubset){
//            printSubset()
           subsetCount++
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




