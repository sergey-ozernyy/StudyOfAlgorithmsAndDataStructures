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
