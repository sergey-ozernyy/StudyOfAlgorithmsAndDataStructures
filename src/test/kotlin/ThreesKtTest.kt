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

    @Test
    fun getCenterCoords() {

//        assertEquals(Pair(-1, -2), Pair(-1, -1))
        lengthSubset = 4
        half = lengthSubset / 2

        assertEquals(Pair(-1, -1), getCenterCoords(5))
        assertEquals(Pair(-1, 1), getCenterCoords(9))
        assertEquals(Pair(1, 1), getCenterCoords(10))
        assertEquals(Pair(1, -1), getCenterCoords(6))

        assertEquals(Pair(2, -2), getCenterCoords(3))
        assertEquals(Pair(-2, 2), getCenterCoords(12))
    }

    @Test
    fun getZeroCoords(){
        lengthSubset = 4
        half = lengthSubset / 2

        assertEquals(Pair(1, 1), getZeroCoords(-1, -1))
        assertEquals(Pair(1, 2), getZeroCoords(-1, 1))
        assertEquals(Pair(2, 2), getZeroCoords(1, 1))
        assertEquals(Pair(2, 1), getZeroCoords(1, -1))

        assertEquals(Pair(3, 0), getZeroCoords(2, -2))
    }
}