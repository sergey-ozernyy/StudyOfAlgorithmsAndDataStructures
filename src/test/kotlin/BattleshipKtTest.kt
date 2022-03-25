import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class BattleshipKtTest {

    @ParameterizedTest
    @MethodSource("getCountShipsArguments")
    fun getCountShips(board: MutableList<MutableList<Int>>, expected: Int) {
        // Arrange
        count = 0
        
        // Act and Assert
        assertEquals(expected, getCountShips(board))

    }

    private companion object {
        @JvmStatic
        fun getCountShipsArguments(): Stream<Arguments> = Stream.of(
            Arguments.of(
                mutableListOf(
                    mutableListOf(0, 0),
                    mutableListOf(0, 0)
                ),
                0
            ),
            Arguments.of(
                mutableListOf(
                    mutableListOf(1, 0, 0),
                    mutableListOf(1, 0, 1),
                    mutableListOf(1, 0, 0),
                ),
                2
            ),
            Arguments.of(
                mutableListOf(
                    mutableListOf(1, 1, 0, 1),
                    mutableListOf(0, 0, 0, 1),
                    mutableListOf(1, 1, 0, 1),
                    mutableListOf(0, 0, 0, 1),
                ),
                3
            ),
        )
    }

}