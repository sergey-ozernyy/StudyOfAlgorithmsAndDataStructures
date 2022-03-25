package algo_challenge

/**
«Правильная скобочная последовательность»
Проверить, является ли последовательность скобок сбалансированной .
Пример:
“()()” - true
“(())” - true
“(()” - false
 */


fun checkBalanceSequence(startArray: CharArray): Boolean {
    var count = 0
    for (char in startArray){
        if (char == ')'){
            count--
            if (count < 0) return false
        }
        else if (char == '('){
            count++
        }
    }
    return count == 0
}