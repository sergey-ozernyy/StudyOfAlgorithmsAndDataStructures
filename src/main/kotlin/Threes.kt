import kotlin.math.abs

val set = mutableListOf<String>("A", "B", "C", "D")
val lengthSubset = 8
val result = //set
            (0..63)
                .map { element -> false }.toMutableList()
var subsetCount = 0


fun generateSubsets(i: Int, countTrue:Int){
    if (isBeat()) return
    if(i == result.size || countTrue == lengthSubset ){
        if(countTrue == lengthSubset){
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
    for (i in 0..result.size - 1 ){
        if (result[i]){
            for (j in i + 1..result.size - 1){
                if (result[j]){
                    if  (isHorizontalBeat(i, j)
                            ||
                            isVerticalBeat(i, j)
                            ||
                            isDiagonalBeat(i, j))
                        return true
                }
            }
        }
    }
    return false
}

fun isHorizontalBeat(i:Int, j:Int):Boolean{
    return getY(i) == getY(j)
}

fun isVerticalBeat(i:Int, j:Int):Boolean{
    return getX(i) == getX(j)
}

fun isDiagonalBeat(i:Int, j:Int):Boolean{
    return getWidth(i, j) == getHeight(i, j)
}

fun getY(index:Int):Int = index / lengthSubset

fun getX(index: Int):Int = index % lengthSubset

fun getHeight(i: Int, j: Int) = abs(getY(i) - getY(j))

fun getWidth(i: Int, j: Int) = abs(getX(i) - getX(j))
