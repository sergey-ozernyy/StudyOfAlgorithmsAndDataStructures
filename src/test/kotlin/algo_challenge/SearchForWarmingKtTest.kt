package algo_challenge

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class SearchForWarmingKtTest {

    @ParameterizedTest
    @MethodSource("getArgumentsForGetNumbersOfDays")
    fun getNumbersOfDays(weatherList:List<Int>, expected:List<Int>) {
        assertArrayEquals(expected.toIntArray(), getNumbersOfDays(weatherList).toIntArray())
    }

    @ParameterizedTest
    @MethodSource("getArgumentsForGetNumbersOfDays")
    fun getNumbersOfDaysReverse(weatherList:List<Int>, expected:List<Int>) {
        assertArrayEquals(expected.toIntArray(), getNumbersOfDaysReverse(weatherList).toIntArray())
    }

    private companion object {

        @JvmStatic
        fun getArgumentsForGetNumbersOfDays() = Stream.of(
            Arguments.of(
                listOf(13, 12, 15, 11, 9, 16),
                listOf(2, 1, 3, 2, 1, 0)
            ),
            Arguments.of(
                listOf(5, 4, 3, 2, 1),
                listOf(0, 0, 0, 0, 0)
            ),
            Arguments.of(
                listOf(1, 2, 3, 4, 5),
                listOf(1, 1, 1, 1, 0)
            ),
            Arguments.of(
                listOf(0, 1, 6, 4, 3, 2, 5),
                listOf(1, 1, 0, 3, 2, 1, 0)
            ),
            Arguments.of(
                listOf(17, 12, 15, 11, 9, 12, 16),
                listOf(0, 1, 4, 2, 1, 1, 0)
            ),
        )
    }



}