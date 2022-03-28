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
    val brackets = mapOf(
        '(' to ')',
        '[' to ']',
        '{' to '}',
    )
    val lastOpen: Deque<Char> = LinkedList<Char>()

    for (char in startArray) {
        if (brackets.keys.contains(char)) {
            lastOpen.add(char)
        } else {
            if (brackets[lastOpen.removeLast()] != char) return false
        }
    }

    return lastOpen.size == 0
}
