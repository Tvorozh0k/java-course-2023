package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class TestTask5 {

    @ParameterizedTest
    @DisplayName("Примеры к заданию")
    @CsvSource({"11211230,true", "13001120,true", "23336014,true", "11,true"})
    void Examples(int input, boolean expected) {
        // isPalindromeDescendant(11211230) -> true // 11211230 -> 2333 -> 56 -> 11
        // isPalindromeDescendant(13001120) -> true // 13001120 -> 4022 ➞ 44
        // isPalindromeDescendant(23336014) -> true // 23336014 -> 5665
        // isPalindromeDescendant(11) -> true

        // when
        boolean result = Task5.isPalindromeDescendant(input);

        // then
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("Тест с единицей")
    void OneDigitTest() {
        // isPalindromeDescendant(1) -> false

        // given
        int number = 1;

        // when
        boolean result = Task5.isPalindromeDescendant(number);

        // then
        assertThat(result)
                .isEqualTo(false);
    }

    @Test
    @DisplayName("Тест с нулем")
    void ZeroTest() {
        // isPalindromeDescendant(0) -> false

        // given
        int number = 0;

        // when
        boolean result = Task5.isPalindromeDescendant(number);

        // then
        assertThat(result)
                .isEqualTo(false);
    }

    @Test
    @DisplayName("Тест с отрицательным числом")
    void NegativeNumberTest() {
        // isPalindromeDescendant(-10) -> false

        // given
        int number = -10;

        // then
        assertThatThrownBy(() -> Task5.isPalindromeDescendant(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
