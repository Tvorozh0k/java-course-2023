package edu.hw5;

import edu.hw5.Task3.Main;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask3 {

    static Stream<Arguments> examplesData() {
        return Stream.of(
            Arguments.of("2020-10-10", Optional.of(LocalDate.of(2020, 10, 10))),
            Arguments.of("2020-12-2", Optional.of(LocalDate.of(2020, 12, 2))),
            Arguments.of("1/3/1976", Optional.of(LocalDate.of(1976, 3, 1))),
            Arguments.of("1/3/20", Optional.of(LocalDate.of(2020, 3, 1))),
            Arguments.of("day after tomorrow", Optional.of(LocalDate.now().plusDays(2))),
            Arguments.of("tomorrow", Optional.of(LocalDate.now().plusDays(1))),
            Arguments.of("today", Optional.of(LocalDate.now())),
            Arguments.of("yesterday", Optional.of(LocalDate.now().minusDays(1))),
            Arguments.of("day before yesterday", Optional.of(LocalDate.now().minusDays(2))),
            Arguments.of("1 day ago", Optional.of(LocalDate.now().minusDays(1))),
            Arguments.of("2234 days ago", Optional.of(LocalDate.now().minusDays(2234)))
        );
    }

    @ParameterizedTest
    @MethodSource("examplesData")
    @DisplayName("Примеры к заданию")
    void examples(String input, Optional<LocalDate> expected) {
        // when
        var result = Main.parseDate(input);

        // then
        assertThat(result)
            .isEqualTo(expected);
    }

    static Stream<Arguments> nullTestData() {
        return Stream.of(
            Arguments.of("-1-10-10", Optional.empty()),
            Arguments.of("99999-10-10", Optional.empty()),
            Arguments.of("2022--1-10", Optional.empty()),
            Arguments.of("2022-50-10", Optional.empty()),
            Arguments.of("2022-10--1", Optional.empty()),
            Arguments.of("2022-10-50", Optional.empty()),
            Arguments.of("-1 day ago", Optional.empty()),
            Arguments.of("0 days ago", Optional.empty()),
            Arguments.of("5 day ago", Optional.empty()),
            Arguments.of("yesterday tomorrow", Optional.empty())
        );
    }

    @ParameterizedTest
    @MethodSource("nullTestData")
    @DisplayName("Некорректные входные данные")
    void nullTest(String input, Optional<LocalDate> expected) {
        // when
        var result = Main.parseDate(input);

        // then
        assertThat(result)
            .isEqualTo(expected);
    }
}
