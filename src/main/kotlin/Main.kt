fun main(args: Array<String>) {
    setBoardSize(8)
    generateSubsets(0, 0)
    val uniqueResult = deleteDublicates(resultList)
    for (i in uniqueResult){
        println(i.joinToString())
    }
    println(uniqueResult.size)

//    generatePermutations(lenght = 4, 0)
}






