package algo_challenge

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class SearchNumbersForSumKtTest {

    @ParameterizedTest
    @MethodSource("getArguments")
    fun getNumbersForSum(testArguments:Pair<List<Int>, Int>, expected:List<Int>?) {
        // Arrange
        val startList = testArguments.first
        val sum = testArguments.second

        // Act and Assert
        assertEquals(expected, getNumbersForSum(startList, sum))
    }

    companion object {
        @JvmStatic
        fun getArguments(): Stream<Arguments> = Stream.of(
            Arguments.of(
                Pair(
                    listOf(2, -4, 10),
                    6),
                listOf(-4, 10)
            ),
            Arguments.of(
                Pair(
                    listOf(3, 6, 3),
                    6),
                listOf(3, 3)
            ),
            Arguments.of(
                Pair(
                    listOf(3, 6),
                    6),
                null
            ),
        )
    }

}