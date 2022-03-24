/**
Есть матрица NxN, состоящая из 0 и 1
и отражающая расположения кораблей на поле для морского боя.

1. Корабли никак не соприкасаются
друг с другом.
2. Корабли располагаются
горизонтально и вертикально

Необходимо подсчитать
количество кораблей
 */

fun main() {
    println(
        getCountShips(testBoard)
    )
}

val testBoard = listOf<List<Int>>(
    listOf(1, 0, 0),
    listOf(1, 0, 1),
    listOf(1, 0, 1),
)

var count = 0

fun getCountShips(board: List<List<Int>>): Int {
    for (i in 0..board.size - 1) {
        for (j in 0..board.size - 1) {
            if (board[i][j] != 0) {
                calculateShips(i = i, j = j, board)
            }
        }
    }
    return count
}

/**
 * Первый способ, без рекурсии
 */
fun calculateShips(i: Int, j: Int, board: List<List<Int>>) {
    if (
        i == 0 &&
        j == 0
    ) {
        if (board[i][j] != 0) {
            count++
        }
    } else if (i == 0) {
        if (board[i][j - 1] == 0) {
            count++
        }
    } else if (j == 0) {
        if (board[i - 1][j] == 0) {
            count++
        }
    } else if (
        board[i - 1][j] == 0 &&
        board[i][j - 1] == 0
    ) {
        count++
    }
}
