val N = 3
val board = listOf<List<Int>>(
    listOf(1, 1, 1),
    listOf(0, 0, 0),
    listOf(0, 0, 1),
)

var count = 0

fun getCountShips(board: List<List<Int>>): Int {
    for (i in 0..board.size - 1) {
        for (j in 0..board.size - 1) {
            calculateShips(i = i, j = j)
        }
    }
    return count
}

fun calculateShips(i: Int, j: Int) {
    if (
        i == 0
    ) {
        if (
            board[i][j - 1] != 0
        ) {
            count++
        }
    } else if (
        j == 0
    ) {
        if (
            board[i - 1][j] != 0
        ) {
            count++
        }
    } else if (
        board[i - 1][j] != 0 &&
        board[i][j - 1] != 0
    ) {
        count++
    }
}


fun main() {
    println(
        getCountShips(board)
    )
}