val set = mutableListOf<String>("A", "B", "C", "D")
val result = //set
            (0..15)
                .map { element -> false }.toMutableList()
var subsetCount = 0


fun generateSubsets(i: Int, lengthSubset:Int, countTrue:Int){
    if(i == result.size || countTrue == lengthSubset){
        if(!isBeat()){
            printSubset()
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
        if(i % 4 == 0){
            resultString += "\n"
        }
        resultString += v
        resultString += "${i}, "
    }
    println(resultString)
}

fun isBeat():Boolean {
    result.forEachIndexed { i, v1 ->
        if (v1) {
            result.forEachIndexed { j, v2 ->
                if (v2 && i != j) {
                    return isHorizontalBeat(i, j)
                            ||
                            isVerticalBeat(i, j)
                            ||
                            isDiagonalBeat(i, j)
                }
            }
        }
    }
    return false
}

fun isHorizontalBeat(i:Int, j:Int):Boolean{
    return kotlin.math.abs(i - j) < 4
}

fun isVerticalBeat(i:Int, j:Int):Boolean{
    return kotlin.math.abs(i - j) % 4 == 0
}

fun isDiagonalBeat(i:Int, j:Int):Boolean{
    return kotlin.math.abs(i - j) % 3 == 0
           ||
           kotlin.math.abs(i - j) % 5 == 0
}


