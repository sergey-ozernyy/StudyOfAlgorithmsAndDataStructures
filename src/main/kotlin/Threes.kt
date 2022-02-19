import kotlin.math.abs

val set = mutableListOf<String>("A", "B", "C", "D")
var lengthSubset = 8
var half = lengthSubset / 2
val result = //set
            (0..63)
                .map { element -> false }.toMutableList()
val resultList:MutableList<List<Boolean>> = mutableListOf<List<Boolean>>()
var subsetCount = 0


fun generateSubsets(i: Int, countTrue:Int){
    if (isBeat()) return
    if(i == result.size || countTrue == lengthSubset ){
        if(countTrue == lengthSubset){
//            printSubset()
//            subsetCount++
            resultList.add(result.toList())
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


fun deleteDublicates(resultList: MutableList<List<Boolean>>):MutableList<List<Boolean>>  {
    var trueResultList:MutableList<List<Boolean>> = mutableListOf<List<Boolean>>()
    for (i in 0..resultList.size-1){
        var isDublecate = false
        val rotations = getRotations(resultList[i])
        for (j in i+1..resultList.size-1){
            if (resultList[i].toBooleanArray() contentEquals resultList[j].toBooleanArray()){
                isDublecate = true
            }
        }
        if (!isDublecate) trueResultList.add(resultList[i])
    }

    return trueResultList
}

fun getRotations(original: List<Boolean>): List<List<Boolean>> {
    return listOf(
        rotate90(original),
        rotate90(rotate90(original)),
        rotate90(rotate90(rotate90(original)))
    )
}

fun rotate90(original: List<Boolean>): List<Boolean> {
    val result = original.map { false }.toList().toMutableList()
    for (i in 0..original.size-1){
        if (original[i]){
            result[rotateCell90(i)] = original[i]
        }
    }
    return result
}

fun rotateCell90(i: Int): Int {
    val (cx, cy) = getCenterCoords(i)

    return i //TODO()
//    return getIndexFromCoodrs()
}

fun getCenterCoords(i: Int): Pair<Int, Int> {
    val x = getX(i)
    val y = getY(i)
    var centerX = x - half
    if (centerX >= 0)
        centerX++
    var centerY = y - half
    if (centerY >= 0)
        centerY++

    return Pair(centerX, centerY)

}

