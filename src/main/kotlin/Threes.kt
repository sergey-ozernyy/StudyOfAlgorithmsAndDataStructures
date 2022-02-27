import kotlin.math.abs

val set = mutableListOf<String>("A", "B", "C", "D")

var N = 8
var half = N / 2
var result: MutableList<Boolean> = mutableListOf()

/**
 * Задает размер доски и инициализирует вспомогательные переменные.
 * @param size Ширина или высота доски, например 8 для доски с 64 клетками.
 */
fun setBoardSize(size: Int) {
    if (size % 2 != 0) {
        throw Exception("Длина и ширина доски должны быть кратны 2")
    }
    N = size
    half = N / 2
    result = createBoard(N * N)

}

fun createBoard(totalCellsCount: Int) = (1..totalCellsCount).map { element -> false }.toMutableList()


val resultList: MutableList<List<Boolean>> = mutableListOf<List<Boolean>>()
var subsetCount = 0


fun generateSubsets(i: Int, countTrue: Int) {
    if (isBeat()) return
    if (i == result.size || countTrue == N) {
        if (countTrue == N) {
//            printSubset()
//            subsetCount++
            resultList.add(result.toList())
        }
        return
    }


    result[i] = true
    generateSubsets(i + 1, countTrue + 1)

    result[i] = false
    generateSubsets(i + 1, countTrue)
}

fun printSubset() {
    var resultString = ""
    result.forEachIndexed { i, v ->
        if (i % 4 == 0) {
            resultString += "\n"
        }
        resultString += v
        resultString += "${i}, "
    }
    println(resultString)
}

fun isBeat(): Boolean {
    for (i in 0..result.size - 1) {
        if (result[i]) {
            for (j in i + 1..result.size - 1) {
                if (result[j]) {
                    if (isHorizontalBeat(i, j) || isVerticalBeat(i, j) || isDiagonalBeat(i, j)) return true
                }
            }
        }
    }
    return false
}

fun isHorizontalBeat(i: Int, j: Int): Boolean {
    return getY(i) == getY(j)
}

fun isVerticalBeat(i: Int, j: Int): Boolean {
    return getX(i) == getX(j)
}

fun isDiagonalBeat(i: Int, j: Int): Boolean {
    return getWidth(i, j) == getHeight(i, j)
}

fun getY(index: Int): Int = index / N

fun getX(index: Int): Int = index % N

fun getHeight(i: Int, j: Int) = abs(getY(i) - getY(j))

fun getWidth(i: Int, j: Int) = abs(getX(i) - getX(j))


fun deleteDublicates(resultList: MutableList<List<Boolean>>): MutableList<List<Boolean>> {
    var trueResultList: MutableList<List<Boolean>> = mutableListOf<List<Boolean>>()
    for (i in 0..resultList.size - 1) {
        var isDublecate = false
        val rotations = getSymmetricalBoards(resultList[i])
        for (j in i + 1..resultList.size - 1) {
            for (k in 0..rotations.size - 1) {
                if (rotations[k].toBooleanArray() contentEquals resultList[j].toBooleanArray()) {
                    isDublecate = true
                }
            }
        }
        if (!isDublecate) trueResultList.add(resultList[i])
    }

    return trueResultList
}

fun getSymmetricalBoards(original: List<Boolean>): List<List<Boolean>> {
    return listOf(
        transformBoard(original, 1),
        transformBoard(original, 2),
        transformBoard(original, 3),

        transformBoard(original, mirrorAxisX = true),
        transformBoard(original, mirrorAxisX = true, rotateCount = 1),
        transformBoard(original, mirrorAxisX = true, rotateCount = 2),
        transformBoard(original, mirrorAxisX = true, rotateCount = 3),

        transformBoard(original, mirrorAxisY = true),
        transformBoard(original, mirrorAxisY = true, rotateCount = 1),
        transformBoard(original, mirrorAxisY = true, rotateCount = 2),
        transformBoard(original, mirrorAxisY = true, rotateCount = 3),

        transformBoard(original, mirrorAxisX = true, mirrorAxisY = true),
        transformBoard(original, mirrorAxisX = true, mirrorAxisY = true, rotateCount = 1),
        transformBoard(original, mirrorAxisX = true, mirrorAxisY = true, rotateCount = 2),
        transformBoard(original, mirrorAxisX = true, mirrorAxisY = true, rotateCount = 3),
        )
}

fun transformBoard(
    original: List<Boolean>,
    rotateCount: Int = 0,
    mirrorAxisX: Boolean = false,
    mirrorAxisY: Boolean = false
): List<Boolean> {
    val result = original.map { false }.toList().toMutableList()
    for (i in 0..original.size - 1) {
        if (original[i]) {
            var targetIndex: Int = transformCell(i, rotateCount, mirrorAxisX, mirrorAxisY)
            result[targetIndex] = original[i]
        }
    }
    return result
}

fun transformCell(i: Int,
                  rotateCount: Int = 0,
                  mirrorAxisX: Boolean = false,
                  mirrorAxisY: Boolean = false): Int {
    val (cx, cy) = getCenterCoords(i)
    var rcx:Int = cx
    var rcy:Int = cy

    if (mirrorAxisX) {
        rcx = rcx
        rcy = -rcy
    }
    if (mirrorAxisY){
        rcx = -rcx
        rcy = rcy
    }
    for (i in 1..rotateCount){
        val p = Pair(rcy, -rcx)
        rcx = p.first
        rcy = p.second
    }
    val (zx, zy) = getZeroCoords(rcx, rcy)
    val ri = zy * N + zx
    return ri
}

fun getZeroCoords(rcx: Int, rcy: Int): Pair<Int, Int> {
    var zeroX = if (rcx < 0) rcx + half
    else rcx + half - 1
    var zeroY = if (rcy < 0) rcy + half
    else rcy + half - 1
    return Pair(zeroX, zeroY)
}

fun getCenterCoords(i: Int): Pair<Int, Int> {
    val x = getX(i)
    val y = getY(i)
    var centerX = x - half
    if (centerX >= 0) centerX++
    var centerY = y - half
    if (centerY >= 0) centerY++

    return Pair(centerX, centerY)

}

