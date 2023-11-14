package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class TestTask1 {

    static Stream<Arguments> examplesData() {
        return Stream.of(
            Arguments.of(List.of("2022-03-12, 20:20 - 2022-03-12, 23:50", "2022-04-01, 21:30 - 2022-04-02, 01:20"), "3ч 40м"),
            Arguments.of(List.of("2022-03-12, 20:20 - 2022-03-12, 23:50", "2022-03-12, 20:20 - 2022-03-12, 23:51"), "3ч 31м"),
            Arguments.of(List.of("2022-03-12, 20:20 - 2022-03-12, 23:50", "2022-03-12, 20:20 - 2022-03-12, 23:50", "2022-03-12, 20:20 - 2022-03-12, 23:51"), "3ч 30м"),
            Arguments.of(List.of("2022-03-12, 20:20 - 2022-03-12, 23:50", "2022-03-12, 20:20 - 2022-03-12, 23:51", "2022-03-12, 20:20 - 2022-03-12, 23:51"), "3ч 31м")
        );
    }


    @ParameterizedTest
    @MethodSource("examplesData")
    @DisplayName("Примеры к заданию")
    void examples(List<String> sessions, String expected) {
        // when
        var result = Task1.averageTime(sessions);

        // then
        assertThat(result)
            .isEqualTo(expected);
    }

    static Stream<Arguments> errorTestData() {
        return Stream.of(
            Arguments.of(List.of("2022-03-12, 23:50 - 2022-03-12, 23:50")),
            Arguments.of(List.of("2022-03-12, 23:50 - 2022-03-12, 23:49")),
            Arguments.of(List.of("0000-03-12, 23:50 - 2022-03-12, 23:50")),
            Arguments.of(List.of("2022-13-12, 23:50 - 2022-03-12, 23:50")),
            Arguments.of(List.of("2022-03-50, 23:50 - 2022-03-12, 23:50")),
            Arguments.of(List.of("2022-03-12, 24:00 - 2022-03-12, 23:50")),
            Arguments.of(List.of("2022-03-12, 22:66 - 2022-03-12, 23:50")),
            Arguments.of(List.of("2022-03-12, 23:40 - 2022-03-12, 23:50 - 2022-03-12, 23:50"))
        );
    }

    @ParameterizedTest
    @MethodSource("errorTestData")
    @DisplayName("Некорректные входные данные")
    void incorrectInputTests(List<String> sessions) {
        // then
        assertThatThrownBy(() -> Task1.averageTime(sessions))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
