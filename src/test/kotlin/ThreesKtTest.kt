import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ThreesKtTest {

    @Test
    fun rotate90() {
        val originalBoard = (0..63)
            .map { element -> false }.toMutableList()
        originalBoard[50] = true

        val expectedBoard = (0..63)
            .map { element -> false }.toMutableList()
        expectedBoard[46] = true


        val rotateBoard = rotate90(originalBoard)


        assertArrayEquals(
            expectedBoard.toBooleanArray(),
            rotateBoard.toBooleanArray()
        )
    }
}