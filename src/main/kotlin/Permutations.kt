
val startSet = listOf("A", "B", "C")
var resultSet = startSet.map { "" }.toMutableList()


fun generatePermutations(lenght:Int, i: Int){

    if (i == lenght) {
        println(resultSet.joinToString())
        return
    }

    for (j in 0..startSet.size-1){
        resultSet[i] = startSet[j]
        generatePermutations(lenght, i+1)
    }




}