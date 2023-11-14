package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask4 {

    static Stream<Arguments> examplesData() {
        return Stream.of(
            Arguments.of("lol!", true),
            Arguments.of("!lol", true),
            Arguments.of("l!ol", true),
            Arguments.of("!lol!", true),
            Arguments.of("lol!", true),
            Arguments.of("!", true),
            Arguments.of("lol", false),
            Arguments.of("abcde", false),
            Arguments.of("12345", false),
            Arguments.of("password", false),
            Arguments.of("Password!", true),
            Arguments.of("abc!@#", true),
            Arguments.of("!@#123", true),
            Arguments.of("$%^&*()|", true),
            Arguments.of("password123!", true)
        );
    }

    @ParameterizedTest
    @MethodSource("examplesData")
    @DisplayName("Примеры к заданию")
    void examples(String input, boolean expected) {
        // when
        var result = Task4.isValidPassword(input);

        // then
        assertThat(result)
            .isEqualTo(expected);
    }
}
