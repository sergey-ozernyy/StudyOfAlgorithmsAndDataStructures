package algo_challenge

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class BracketSequences1KtTest {

    @ParameterizedTest
    @MethodSource("getArgumentsForCheckBalanceSequence")
    fun checkBalanceSequence(sequence:String, expected: Boolean) {
        //Arrange
        val bracketSequence = sequence.toCharArray()

        //Act and Assert
        assertEquals(expected, checkBalanceSequence(bracketSequence))
    }

    private companion object {
        @JvmStatic
        fun getArgumentsForCheckBalanceSequence():Stream<Arguments> = Stream.of(
            Arguments.of("()()", true),
            Arguments.of("(())", true),
            Arguments.of("(()", false),
            Arguments.of("))(", false),
        )
    }
}