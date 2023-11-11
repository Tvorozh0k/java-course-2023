package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask7 {

    static Stream<Arguments> examplesData1() {
        return Stream.of(
            Arguments.of("0000", true),
            Arguments.of("0001", true),
            Arguments.of("000", true),
            Arguments.of("010", true),
            Arguments.of("100", true),
            Arguments.of("110", true),
            Arguments.of("00", false),
            Arguments.of("0", false),
            Arguments.of("001", false),
            Arguments.of("", false)
        );
    }

    @ParameterizedTest
    @MethodSource("examplesData1")
    @DisplayName("Примеры к заданию 1")
    void examples1(String input, boolean expected) {
        // when
        var result = Task7.zeroOne1(input);

        // then
        assertThat(result)
            .isEqualTo(expected);
    }

    static Stream<Arguments> examplesData2() {
        return Stream.of(
            Arguments.of("0", true),
            Arguments.of("1", true),
            Arguments.of("000", true),
            Arguments.of("010", true),
            Arguments.of("0101010", true),
            Arguments.of("101", true),
            Arguments.of("111", true),
            Arguments.of("1010101", true),
            Arguments.of("", false),
            Arguments.of("01", false),
            Arguments.of("10", false),
            Arguments.of("100", false),
            Arguments.of("011", false)
        );
    }

    @ParameterizedTest
    @MethodSource("examplesData2")
    @DisplayName("Примеры к заданию 2")
    void examples2(String input, boolean expected) {
        // when
        var result = Task7.zeroOne2(input);

        // then
        assertThat(result)
            .isEqualTo(expected);
    }

    static Stream<Arguments> examplesData3() {
        return Stream.of(
            Arguments.of("0", true),
            Arguments.of("1", true),
            Arguments.of("00", true),
            Arguments.of("01", true),
            Arguments.of("10", true),
            Arguments.of("11", true),
            Arguments.of("000", true),
            Arguments.of("111", true),
            Arguments.of("101", true),
            Arguments.of("", false),
            Arguments.of("0000", false),
            Arguments.of("1111", false),
            Arguments.of("1010", false)
        );
    }

    @ParameterizedTest
    @MethodSource("examplesData3")
    @DisplayName("Примеры к заданию 3")
    void examples3(String input, boolean expected) {
        // when
        var result = Task7.zeroOne3(input);

        // then
        assertThat(result)
            .isEqualTo(expected);
    }
}
