package algo_challenge

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

fun main() {
    println(checkComplexSequenceBalance("{[}]".toCharArray()))
}

fun checkComplexSequenceBalance(startArray: CharArray): Boolean {

    val result = mutableMapOf<Char, Int>(
        'a' to 0, // - ()
        'b' to 0, // - []
        'c' to 0  // - {}
    )

    var lastOpen:Char = ' '

    for (char in startArray) {
        when (char) {
            '(' -> {
                result['a'] = result['a']!! + 1
                lastOpen = 'a'
            }
            '[' -> {
                result['b'] = result['b']!! + 1
                lastOpen = 'b'
            }
            '{' -> {
                result['c'] = result['c']!! + 1
                lastOpen = 'c'
            }
            ')' -> {
                result['a'] = result['a']!! - 1
                if (lastOpen != 'a') return false
            }
            ']' -> {
                result['b'] = result['b']!! - 1
                if (lastOpen != 'b') return false
            }
            '}' -> {
                result['c'] = result['c']!! - 1
                if (lastOpen != 'c') return false
            }
        }

        if (result['a']!! < 0) return false
        if (result['b']!! < 0) return false
        if (result['c']!! < 0) return false

    }

    return  result.all { it.value == 0 }
}