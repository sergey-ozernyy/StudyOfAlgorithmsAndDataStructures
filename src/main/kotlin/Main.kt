fun main(args: Array<String>) {
    generateSubsets(0, 0)
    val uniqueResult = deleteDublicates(resultList)
    for (i in uniqueResult){
        println(i.joinToString())
    }
    println(uniqueResult.size)
}






