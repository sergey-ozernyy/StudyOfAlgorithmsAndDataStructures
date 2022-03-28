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

    private companion object {
        @JvmStatic
        fun getArgumentsForGetNumbersOfDays() = Stream.of(
            Arguments.of(
                listOf(13, 12, 15, 11, 9, 12, 16),
                listOf(2, 1, 4, 2, 1, 1, 0)
            )
        )
    }


}