package algo_challenge
import java.util.*

fun main() {
    println(checkComplexSequenceBalance("([{}])".toCharArray()))
}

/**
«Правильная скобочная последовательность»
Проверить, является ли последовательность скобок сбалансированной .
Пример:
“()()” - true
“(())” - true
“(()” - false
 */

fun checkSequenceBalance(startArray: CharArray): Boolean {
    var count = 0
    for (char in startArray) {
        if (char == ')') {
            count--
            if (count < 0) return false
        } else if (char == '(') {
            count++
        }
    }
    return count == 0
}

/**
Добавляется два вида скобок - { [
Пример:
“{}[]()” - true
“([{}])” - true
“(()]” - false
 */

fun checkComplexSequenceBalance(startArray: CharArray): Boolean {

    val result = mutableMapOf<Char, Int>(
        'a' to 0, // - ()
        'b' to 0, // - []
        'c' to 0  // - {}
    )

    val lastOpen: Deque<Char> = LinkedList<Char>()

    for (char in startArray) {
        when (char) {
            '(' -> {
                result['a'] = result['a']!! + 1
                lastOpen.add('a')
            }
            '[' -> {
                result['b'] = result['b']!! + 1
                lastOpen.add('b')
            }
            '{' -> {
                result['c'] = result['c']!! + 1
                lastOpen.add('c')
            }
            ')' -> {
                result['a'] = result['a']!! - 1
                if (lastOpen.removeLast() != 'a') return false
            }
            ']' -> {
                result['b'] = result['b']!! - 1
                if (lastOpen.removeLast() != 'b') return false
            }
            '}' -> {
                result['c'] = result['c']!! - 1
                val element = lastOpen.removeLast()
                if (element != 'c') return false
            }
        }

        if (result['a']!! < 0) return false
        if (result['b']!! < 0) return false
        if (result['c']!! < 0) return false

    }

    return  result.all { it.value == 0 }
}

/**
Дана несбалансированная последовательность круглых скобок.
Вернуть индекс скобки, заменив которую на противоположную последовательность станет сбалансированной. Если последовательность нельзя сделать сбалансированной заменой всего одной скобки, то вернуть -1.

Примеры:
«((« -> 1
«)())» -> 0
«()))» —> 1 или 2
«)(« -> -1
 */

fun checkBalanceAndFixBracket(startArray: CharArray):Int{
    var count = 0
    for (i in 0..startArray.size-1){
        if (startArray[i] == '(') count++
    }
    return 1
}