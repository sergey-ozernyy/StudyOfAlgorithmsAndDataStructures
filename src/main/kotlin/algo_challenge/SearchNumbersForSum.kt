package algo_challenge

/**
Есть массив целых чисел и число K.
Найти два таких (не обязательно различных) числа в массиве,
сумма которых равна K,
либо вывести, что таких чисел нет.
[2, -4, 10], 6 → [-4, 10]
[3, 6, 3], 6 → [3, 3]
[3, 6], 6 → null
 */

fun getNumbersForSum(startList: List<Int>, sum:Int): List<Int>? {
    val result = mutableListOf<Int>()
    for (i in 0..startList.size-1){
        for (j in i+1..startList.size-1){
            if (startList[i] + startList[j] == sum) {
                result.add(startList[i])
                result.add(startList[j])
                return result
            }
        }
    }
    return null
}

