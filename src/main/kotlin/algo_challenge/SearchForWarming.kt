package algo_challenge

/**
Дан список температур по дням, все температуры разные. Для каждого дня найти, через сколько дней станет теплее.
in: [13, 12, 15, 11, 9, 12, 16]
out: [2, 1, 4, 2, 1, 1, 0]
 */

fun getNumbersOfDays(weatherList:List<Int>):List<Int>{
    val result = mutableListOf<Int>()
    for (i in 0..weatherList.size-1){
        for (j in i+1..weatherList.size-1){
            if (weatherList[i] < weatherList[j]) {
                result.add(j-i)
                break
            }
        }
    }
    result.add(0)
    return result
}

fun getNumbersOfDaysReverse(weatherList:List<Int>):List<Int>{
    var max = Pair(weatherList.last(), weatherList.lastIndex)
    var maxList:MutableList<Pair<Int, Int>> = MutableList(1){max}
    val result = MutableList(weatherList.size){0}

    for (i in weatherList.size-2 downTo 0 step 1){
        if (weatherList[i] < weatherList[i+1])
            result[i] = 1
        else if (weatherList[i] > weatherList[i+1]){
            if (weatherList[i] > max.first){
                max = Pair(weatherList[i], i)
                result[i] = 0
            }
            else
                maxList.add(Pair(weatherList[i], i))
                for (j in maxList.asReversed()){
                    if (weatherList[i] < j.first){
                        result[i] = j.second - i
                        break
                    }
                }

        }
    }
    return result
}

private lateinit var result:MutableList<Int>

fun getNumbersOfDaysWithRecursion(weatherList:List<Int>):List<Int>{
    println(weatherList)
    result = MutableList(weatherList.size){0}
    getNumbers(weatherList,0)
    println(result)
    return result
}

fun getNumbers(weatherList:List<Int>, index:Int){
    if (index == result.size-1) {
        result[index] = 0
        return
    }

    getNumbers(weatherList, index+1)


    if (weatherList[index] < weatherList[index+1]) {
        if (index+2 <= weatherList.size-1 &&
            weatherList[index+1] < weatherList[index+2]){
            result[index] = 1
        } else {
            result[index] = result[index+1] + 1
        }
    }
    else if (
        index+2 <= weatherList.size-1 &&
        weatherList[index] > weatherList[index+1] &&
        weatherList[index] < weatherList[index+2]
    ){
        result[index] = result[index+1] + 1
    }
    else {
        println("${weatherList[index]} > ${weatherList[index+1]}")
        result[index] = result[index+1]
    }


}

fun main() {
//    counter(0,0)
    println(getNumbersOfDaysReverse(listOf(1, 2, 3, 4, 5)))
}










val resultCounter = MutableList(3){0}

fun counter(index:Int, count:Int){
    if (index == resultCounter.size) return

    counter(index+1, count+1)
    resultCounter[index] = count
}
