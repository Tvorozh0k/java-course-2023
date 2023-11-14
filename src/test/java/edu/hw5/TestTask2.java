package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class TestTask2 {

    static Stream<Arguments> examplesData1() {
        return Stream.of(
            Arguments.of(1925, List.of("1925-02-13", "1925-03-13", "1925-11-13")),
            Arguments.of(2023, List.of("2023-01-13", "2023-10-13"))
        );
    }

    @ParameterizedTest
    @MethodSource("examplesData1")
    @DisplayName("Примеры к заданию 1)")
    void examples1(int year, List<String> expected) {
        // when
        var result = Task2.allFriday13(year);

        // then
        assertThat(result)
            .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"0", "-1"})
    @DisplayName("Некорректные входные данные")
    void incorrectInputTests(int year) {
        // then
        assertThatThrownBy(() -> Task2.allFriday13(year))
            .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> examplesData2() {
        return Stream.of(
            Arguments.of(LocalDate.of(2023, 10, 12), LocalDate.of(2023, 10, 13)),
            Arguments.of(LocalDate.of(2023, 10, 13), LocalDate.of(2023, 10, 13)),
            Arguments.of(LocalDate.of(2023, 10, 14), LocalDate.of(2024, 9, 13))
        );
    }

    @ParameterizedTest
    @MethodSource("examplesData2")
    @DisplayName("Примеры к заданию 2)")
    void examples1(LocalDate input, LocalDate expected) {
        // when
        var result = Task2.nextFriday13(input);

        // then
        assertThat(result)
            .isEqualTo(expected);
    }
}
