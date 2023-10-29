package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class TestTask4 {

    @ParameterizedTest
    @DisplayName("Примеры к заданию")
    @CsvSource({"2,II", "12,XII", "16,XVI"})
    void Examples(int input, String expected) {
        // convertToRoman(2) ➞ "II"
        // convertToRoman(12) ➞ "XII"
        // convertToRoman(16) ➞ "XVI"

        // when
        String result = Task4.convertToRoman(input);

        // then
        assertThat(result)
            .isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("Некорректные входные данные")
    @CsvSource({"-1", "0", "4000", "4001"})
    void IncorrectInputTests(int input) {
        // then
        assertThatThrownBy(() -> Task4.convertToRoman(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Максимальное значение")
    void MaxValueTest() {
        // given
        int input = 3999;

        // when
        String result = Task4.convertToRoman(input);

        // then
        assertThat(result)
            .isEqualTo("MMMCMXCIX");
    }
}
