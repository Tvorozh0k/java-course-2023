package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask8 {

    static Stream<Arguments> examplesData1() {

        return Stream.of(
            Arguments.of("0", true),
            Arguments.of("1", true),
            Arguments.of("000", true),
            Arguments.of("111", true),
            Arguments.of("100", true),
            Arguments.of("00000", true),
            Arguments.of("11111", true),
            Arguments.of("", false),
            Arguments.of("00", false),
            Arguments.of("11", false),
            Arguments.of("0000", false),
            Arguments.of("1111", false)
        );
    }

    @ParameterizedTest
    @MethodSource("examplesData1")
    @DisplayName("Примеры к заданию 1")
    void examples1(String input, boolean expected) {
        // when
        var result = Task8.zeroOne1(input);

        // then
        assertThat(result)
            .isEqualTo(expected);
    }

    static Stream<Arguments> examplesData2() {
        return Stream.of(
            Arguments.of("0", true),
            Arguments.of("010", true),
            Arguments.of("01010", true),
            Arguments.of("10", true),
            Arguments.of("1010", true),
            Arguments.of("101010", true),
            Arguments.of("", false),
            Arguments.of("00", false),
            Arguments.of("0011", false),
            Arguments.of("001100", false),
            Arguments.of("1", false),
            Arguments.of("100", false),
            Arguments.of("10011", false)
        );
    }

    @ParameterizedTest
    @MethodSource("examplesData2")
    @DisplayName("Примеры к заданию 2")
    void examples2(String input, boolean expected) {
        // when
        var result = Task8.zeroOne2(input);

        // then
        assertThat(result)
            .isEqualTo(expected);
    }

    static Stream<Arguments> examplesData3() {
        return Stream.of(
            Arguments.of("", true),
            Arguments.of("0", true),
            Arguments.of("1", true),
            Arguments.of("01", true),
            Arguments.of("10", true),
            Arguments.of("000", true),
            Arguments.of("101", true),
            Arguments.of("0000", true),
            Arguments.of("1111", true),
            Arguments.of("1010", true),
            Arguments.of("11", false),
            Arguments.of("111", false)
        );
    }

    @ParameterizedTest
    @MethodSource("examplesData3")
    @DisplayName("Примеры к заданию 3")
    void examples3(String input, boolean expected) {
        // when
        var result = Task8.zeroOne3(input);

        // then
        assertThat(result)
            .isEqualTo(expected);
    }

    static Stream<Arguments> examplesData4() {
        return Stream.of(
            Arguments.of("", true),
            Arguments.of("0", true),
            Arguments.of("1", true),
            Arguments.of("01", true),
            Arguments.of("11", true),
            Arguments.of("010", true),
            Arguments.of("011", true),
            Arguments.of("0101", true),
            Arguments.of("00", false),
            Arguments.of("10", false),
            Arguments.of("000", false),
            Arguments.of("001", false),
            Arguments.of("01001", false)
        );
    }

    @ParameterizedTest
    @MethodSource("examplesData4")
    @DisplayName("Примеры к заданию 4")
    void examples4(String input, boolean expected) {
        // when
        var result = Task8.zeroOne4(input);

        // then
        assertThat(result)
            .isEqualTo(expected);
    }

    static Stream<Arguments> examplesData5() {
        return Stream.of(
            Arguments.of("00", true),
            Arguments.of("000", true),
            Arguments.of("001", true),
            Arguments.of("010", true),
            Arguments.of("100", true),
            Arguments.of("", false),
            Arguments.of("0", false),
            Arguments.of("1", false),
            Arguments.of("01", false),
            Arguments.of("10", false),
            Arguments.of("11", false),
            Arguments.of("011", false),
            Arguments.of("101", false),
            Arguments.of("110", false),
            Arguments.of("111", false)
        );
    }

    @ParameterizedTest
    @MethodSource("examplesData5")
    @DisplayName("Примеры к заданию 5")
    void examples5(String input, boolean expected) {
        // when
        var result = Task8.zeroOne5(input);

        // then
        assertThat(result)
            .isEqualTo(expected);
    }
}
