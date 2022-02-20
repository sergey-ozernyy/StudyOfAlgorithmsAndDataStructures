
val startSet = listOf("A", "B", "C", "D")
var resultSet = startSet.map { "" }.toMutableList()


fun generatePermutations(lenght:Int, i: Int){

    if (i == lenght) {
        println(resultSet.joinToString())
        return
    }

    val candidates = getCandidates(resultSet, i-1)

    for (candidate in candidates){
        resultSet[i] = candidate
        generatePermutations(lenght, i+1)
    }




}

fun getCandidates(usedSet:MutableList<String>, index:Int):MutableList<String>{
    val result = mutableListOf<String>()
    for (candidate in startSet){
        var add = true
        for (i in 0..index){
            if (candidate == usedSet[i]){
                add = false
                break
            }
        }
        if (add) result.add(candidate)
    }
    return result
}