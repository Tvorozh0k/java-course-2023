package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask5 {

    static Stream<Arguments> examplesData() {
        return Stream.of(
            Arguments.of("А123ВЕ777", true),
            Arguments.of("О777ОО177", true),
            Arguments.of("А123ВЕ100", false),
            Arguments.of("А123ВЕ00", false),
            Arguments.of("А000ВЕ01", false),
            Arguments.of("А123ВЕ101", true),
            Arguments.of("123АВЕ777", false),
            Arguments.of("А123ВГ77", false),
            Arguments.of("А123ВЕ7777", false),
            Arguments.of("А001АА116", true),
            Arguments.of("К123ЕК177", true),
            Arguments.of("В234ОР190", true),
            Arguments.of("X777XX77", false),
            Arguments.of("777", false),
            Arguments.of("у111вк77", false),
            Arguments.of("AB123CD1234", false),
            Arguments.of("оОО77777", false)
        );
    }

    @ParameterizedTest
    @MethodSource("examplesData")
    @DisplayName("Примеры к заданию")
    void examples(String input, boolean expected) {
        // when
        var result = Task5.isValidCarNumber(input);

        // then
        assertThat(result)
            .isEqualTo(expected);
    }
}
