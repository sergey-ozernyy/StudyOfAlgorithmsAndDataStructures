package algo_challenge

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class BracketReplacementKtTest {

    @ParameterizedTest
    @MethodSource("getArgumentsForTest1")
    fun test1(sequence:String, expected:Pair<Int, Int?>) {
        // Arrange
        val testArray = sequence.toCharArray()

        // Act and Assert
        assertEquals(getBracketIndex(testArray), expected)
    }

    private companion object {
        @JvmStatic
        fun getArgumentsForTest1(): Stream<Arguments> = Stream.of(
                Arguments.of("((", Pair(1, null)),
                Arguments.of(")())", Pair(0, null)),
                Arguments.of("()))", Pair(1, 2)),
                Arguments.of(")()", Pair(-1, null)),
            )
    }
}