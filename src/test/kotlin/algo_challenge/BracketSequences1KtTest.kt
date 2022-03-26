package algo_challenge

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class BracketSequences1KtTest {

    @ParameterizedTest
    @MethodSource("getArgumentsCheckBalanceSequence")
    fun checkBalanceSequence(sequence:String, expected: Boolean) {
        //Arrange
        val bracketSequence = sequence.toCharArray()

        //Act and Assert
        assertEquals(expected, checkSequenceBalance(bracketSequence))
    }

    @ParameterizedTest
    @MethodSource("getArgumentsCheckComplexSequenceBalance")
    fun checkComplexSequenceBalance(sequence:String, expected: Boolean) {
        //Arrange
        val bracketSequence = sequence.toCharArray()

        //Act and Assert
        assertEquals(expected, checkComplexSequenceBalance(bracketSequence))
    }


    private companion object {
        @JvmStatic
        fun getArgumentsCheckBalanceSequence():Stream<Arguments> = Stream.of(
            Arguments.of("()()", true),
            Arguments.of("(())", true),
            Arguments.of("(()", false),
            Arguments.of("))(", false),
        )

        @JvmStatic
        fun getArgumentsCheckComplexSequenceBalance():Stream<Arguments> = Stream.of(
            Arguments.of("{}[]()", true),
            Arguments.of("([{}])", true),
            Arguments.of("(()]", false),
            Arguments.of("(()(()()))", true),
            Arguments.of("{[}]", false),
        )
    }


}

internal class BracketSequences2KtTest{

    @ParameterizedTest
    @MethodSource("getArgumentsCheckBalanceAndFixBracket")
    fun checkBalanceAndFixBracket(sequence:String, expected: Int) {
        //Arrange
        val bracketSequence = sequence.toCharArray()

        //Act and Assert
        assertEquals(expected, checkBalanceAndFixBracket(bracketSequence))
    }

    private companion object {
        @JvmStatic
        fun getArgumentsCheckBalanceAndFixBracket():Stream<Arguments> = Stream.of(
            Arguments.of("((", 1),
            Arguments.of(")())", 0),
            Arguments.of("()))", 1),
            Arguments.of("()))", 2),
            Arguments.of(")(", -1),
        )
    }
}