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
        val rotateBoard = rotate90(originalBoard)

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
    fun mirrorHorizontal() {
        // Arrange
        val size = 2
        val totalCellsCount = size * size
        setBoardSize(size)

        val originalBoard = createBoard(totalCellsCount)
        putQueen(originalBoard, 3)

        // Act
        val mirroredBoard = mirrorHorizontal(originalBoard)

        val expectedBoard = createBoard(totalCellsCount)
        // Assert
        putQueen(expectedBoard, 2)

        assertArrayEquals(expectedBoard.toBooleanArray(), mirroredBoard.toBooleanArray())
    }

    @Test
    fun mirrorVertical() {
        // Arrange
        val size = 2
        val totalCellsCount = size * size
        setBoardSize(size)

        val originalBoard = createBoard(totalCellsCount)
        putQueen(originalBoard, 3)

        // Act
        val mirroredBoard = mirrorVertical(originalBoard)

        val expectedBoard = createBoard(totalCellsCount)
        // Assert
        putQueen(expectedBoard, 1)

        assertArrayEquals(expectedBoard.toBooleanArray(), mirroredBoard.toBooleanArray())
    }

    @Test
    fun mirror() {
        // Arrange
        val size = 2
        val totalCellsCount = size * size
        setBoardSize(size)

        val originalBoard = createBoard(totalCellsCount)
        putQueen(originalBoard, 3)

        // Act
        val mirroredBoard = mirror(originalBoard, false)

        val expectedBoard = createBoard(totalCellsCount)
        // Assert
        putQueen(expectedBoard, 1)

        assertArrayEquals(expectedBoard.toBooleanArray(), mirroredBoard.toBooleanArray())
    }

    private fun putQueen(originalBoard: MutableList<Boolean>, index: Int) {
        originalBoard[index] = true
    }
}