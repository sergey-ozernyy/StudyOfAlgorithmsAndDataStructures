import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ThreesKtTest {
    @Test
    fun rotate90() {
        // Arrange
        val size = 8
        val totalCellsCount = size * size
        setBoardSize(size)

        val originalBoard = createBoard(totalCellsCount)
        putQueen(originalBoard, 50)

        val expectedBoard = createBoard(totalCellsCount)
        putQueen(expectedBoard, 46)

        // Act
        val rotateBoard = transformBoard(originalBoard, rotateCount = 1)

        // Assert
        assertArrayEquals(
            expectedBoard.toBooleanArray(), rotateBoard.toBooleanArray()
        )
    }

    @Test
    fun getCenterCoords() {
        // Arrange

        setBoardSize(4)

        // Act and Assert

        assertEquals(Pair(-1, -1), getCenterCoords(5))
        assertEquals(Pair(-1, 1), getCenterCoords(9))
        assertEquals(Pair(1, 1), getCenterCoords(10))
        assertEquals(Pair(1, -1), getCenterCoords(6))

        assertEquals(Pair(2, -2), getCenterCoords(3))
        assertEquals(Pair(-2, 2), getCenterCoords(12))
    }

    @Test
    fun getZeroCoords() {
        // Arrange
        setBoardSize(4)

        // Act and Assert

        assertEquals(Pair(1, 1), getZeroCoords(-1, -1))
        assertEquals(Pair(1, 2), getZeroCoords(-1, 1))
        assertEquals(Pair(2, 2), getZeroCoords(1, 1))
        assertEquals(Pair(2, 1), getZeroCoords(1, -1))

        assertEquals(Pair(3, 0), getZeroCoords(2, -2))
    }

    @Test
    fun mirrorBoardAxisY() {
        // Arrange
        val size = 2
        val totalCellsCount = size * size
        setBoardSize(size)

        val originalBoard = createBoard(totalCellsCount)
        putQueen(originalBoard, 3)

        // Act
        val mirroredBoard = transformBoard(originalBoard, mirrorAxisY = true)

        val expectedBoard = createBoard(totalCellsCount)
        // Assert
        putQueen(expectedBoard, 2)

        assertArrayEquals(expectedBoard.toBooleanArray(), mirroredBoard.toBooleanArray())
    }

    @Test
    fun mirrorBoardAxisX() {
        // Arrange
        val size = 2
        val totalCellsCount = size * size
        setBoardSize(size)

        val originalBoard = createBoard(totalCellsCount)
        putQueen(originalBoard, 3)

        // Act
        val mirroredBoard = transformBoard(originalBoard, mirrorAxisX = true)

        val expectedBoard = createBoard(totalCellsCount)
        // Assert
        putQueen(expectedBoard, 1)

        assertArrayEquals(expectedBoard.toBooleanArray(), mirroredBoard.toBooleanArray())
    }

    @Test
    fun mirrorCellAxisY(){
        // Arrange
        setBoardSize(2)

        // Act and Assert
        assertEquals(0, transformCell(1, mirrorAxisY = true))
    }

    @Test
    fun mirrorCellAxisX(){
        // Arrange
        setBoardSize(2)

        // Act and Assert
        assertEquals(3, transformCell(1, mirrorAxisX = true))
    }

    @Test
    fun rotateCell90(){
        // Arrange
        setBoardSize(4)

        // Act and Assert
        assertEquals(7, transformCell(14, 1))
    }


    private fun putQueen(originalBoard: MutableList<Boolean>, index: Int) {
        originalBoard[index] = true
    }
}