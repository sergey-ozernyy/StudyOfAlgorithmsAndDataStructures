package algo_challenge

import java.util.Deque
import java.util.LinkedList

/**
Дана несбалансированная последовательность круглых скобок.
Вернуть индекс скобки, заменив которую на противоположную последовательность станет сбалансированной. Если последовательность нельзя сделать сбалансированной заменой всего одной скобки, то вернуть -1.

Примеры:
«((« -> 1
«)())» -> 0
«()))» —> 1 или 2
«)(« -> -1
 */

fun getBracketIndex(startArray: CharArray):Pair<Int, Int?>{
    val template = listOf(
        "((".toCharArray(),
        "))".toCharArray()
    )
    var result:Pair<Int, Int?>
    var queue:Deque<Pair<Char, Int>> = LinkedList()


    for (i in 0..startArray.size-1){
        queue.add(
                Pair(startArray[i], i)
            )
        if (
            queue.last.first == '(' &&
            startArray[i] != queue.last.first
        ){
                queue.removeLast()
        }
    }

    when (queue.size){
        1 -> result = Pair(queue.first.second, null)
        2 -> result = Pair(queue.first.second, queue.last.second)
        else -> result = Pair(-1, null)
    }

    println(queue)


    return result

}