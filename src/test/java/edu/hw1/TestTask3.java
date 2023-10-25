package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class TestTask3 {

    static Stream<Arguments> ExamplesData() {
        return Stream.of(
                Arguments.of(new int[] {1, 2, 3, 4}, new int[] {0, 6}, true),
                Arguments.of(new int[] {3, 1}, new int[] {4, 0}, true),
                Arguments.of(new int[] {9, 9, 8}, new int[] {8, 9}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("ExamplesData")
    @DisplayName("Примеры к заданию")
    void Examples(int[] fstArray, int[] sndArray, boolean expected) {
        // isNestable([1, 2, 3, 4], [0, 6]) -> true
        // isNestable([3, 1], [4, 0]) -> true
        // isNestable([9, 9, 8], [8, 9]) -> false

        // when
        boolean result = Task3.isNestable(fstArray, sndArray);

        // then
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("Проверка на строгость равенства левой границы")
    void CheckLeftBound() {
        // isNestable([2, 3, 4, 5], [1, 2]) -> false

        // given
        int[] mas1 = new int[] {2, 3, 4, 5};
        int[] mas2 = new int[] {1, 2};

        // when
        boolean result = Task3.isNestable(mas1, mas2);

        // then
        assertThat(result)
                .isEqualTo(false);
    }

    @Test
    @DisplayName("Проверка на строгость равенства правой границы")
    void CheckRightBound() {
        // isNestable([2, 3, 4, 5], [5, 6]) -> false

        // given
        int[] mas1 = new int[] {2, 3, 4, 5};
        int[] mas2 = new int[] {5, 6};

        // when
        boolean result = Task3.isNestable(mas1, mas2);

        // then
        assertThat(result)
                .isEqualTo(false);
    }

    @Test
    @DisplayName("Проверка на пустоту первого массива")
    void EmptyFirstArray() {

        // given
        int[] mas1 = new int[] {};
        int[] mas2 = new int[] {1};

        // then
        assertThatThrownBy(() -> Task3.isNestable(mas1, mas2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Проверка на пустоту второго массива")
    void EmptySecondArray() {

        // given
        int[] mas1 = new int[] {1};
        int[] mas2 = new int[] {};

        // then
        assertThatThrownBy(() -> Task3.isNestable(mas1, mas2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
