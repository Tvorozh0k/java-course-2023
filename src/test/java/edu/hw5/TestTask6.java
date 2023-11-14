package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask6 {

    static Stream<Arguments> examplesData() {
        return Stream.of(
            Arguments.of("abc", "abc", true),
            Arguments.of("abc", "0a0b0c0", true),
            Arguments.of("abc", "0a0b00", false),
            Arguments.of("", "0a0b00", true),
            Arguments.of("a", "0a0b00", true),
            Arguments.of("a", "", false),
            Arguments.of("", "", true),
            Arguments.of("abc", "achfdbaabgabcaabg", true)
        );
    }

    @ParameterizedTest
    @MethodSource("examplesData")
    @DisplayName("Примеры к заданию")
    void examples(String s, String t, boolean expected) {
        // when
        var result = Task6.isSubsequence(s, t);

        // then
        assertThat(result)
            .isEqualTo(expected);
    }
}
