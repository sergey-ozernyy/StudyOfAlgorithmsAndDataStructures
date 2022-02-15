import kotlin.math.abs

val set = mutableListOf<String>("A", "B", "C", "D")
val lengthSubset = 4
val result = //set
            (0..15)
                .map { element -> false }.toMutableList()
var subsetCount = 0


fun generateSubsets(i: Int, countTrue:Int){
    if(i == result.size || countTrue == lengthSubset){
        if(countTrue == lengthSubset && !isBeat()){
            printSubset()
            subsetCount++
        }
        return
    }


    result[i] = true
    generateSubsets(i+1, countTrue+1)

    result[i] = false
    generateSubsets(i+1, countTrue)
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
    for (i in 0..15){
        if (result[i]){
            for (j in 0..15){
                if (result[j] && i != j){
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
    return i / 4 == j / 4
}

fun isVerticalBeat(i:Int, j:Int):Boolean{
    return i % 4 == j % 4
}

fun isDiagonalBeat(i:Int, j:Int):Boolean{
    return abs(i % 4 - j % 4) == abs(i / 4 - j / 4)
}


