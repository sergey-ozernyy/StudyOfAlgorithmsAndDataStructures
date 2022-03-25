package algo_challenge

/**
Есть матрица NxN, состоящая из 0 и 1
и отражающая расположения кораблей на поле для морского боя.

1. Корабли никак не соприкасаются
друг с другом.
2. Корабли располагаются
горизонтально и вертикально.

Необходимо подсчитать
количество кораблей.
 */

fun main() {
    println(getCountShips(testBoard))
//    AlgoChallenge.calculateShips2()
}

val testBoard = mutableListOf(
    mutableListOf(1, 0, 1),
    mutableListOf(0, 1, 0),
    mutableListOf(1, 0, 1),
)

var count = 0

fun getCountShips(board: MutableList<MutableList<Int>>): Int {
    addZero(board)
    for (i in 0..board.size - 1) {
        for (j in 0..board.size - 1) {
            if (board[i][j] != 0) {
                //Первый способ:
//                AlgoChallenge.calculateShips1(i = i, j = j, board)
                //Второй способ:
                count++
                calculateShips2(i = i, j = j, board = board)
            }
        }
    }
    return count
}

/**
 * Первый способ, без рекурсии.
 * Ищет корабли расположенные либо горизонтально, либо вертикально.
 */
fun calculateShips1(i: Int, j: Int, board: MutableList<MutableList<Int>>) {
    if (
        board[i - 1][j] == 0 &&
        board[i][j - 1] == 0
    ) {
        count++
    }
}

/**
 * Второй способ, с рекурисей.
 * Ищет корабли любой формы.
 */
fun calculateShips2(i:Int, j:Int, board: MutableList<MutableList<Int>>){
    board[i][j] = 0

    for (x in listOf(-1, 0, 1)){
        for (y in listOf(-1, 0, 1)){
            if (board[i+x][j+y] != 0){
                calculateShips2(i = i+x, j = j+y, board = board)
            }
        }
    }
}

fun addZero(board: MutableList<MutableList<Int>>){
    board.add(0, MutableList(board.size){0})
    board.add(MutableList(board.size-1){0})
    for (i in board){
        i.add(0,0)
        i.add(0)
    }
    println(board)
}

