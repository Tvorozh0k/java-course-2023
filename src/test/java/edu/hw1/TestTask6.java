package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class TestTask6 {

    @ParameterizedTest
    @DisplayName("Примеры к заданию")
    @CsvSource({"6621,5", "6554,4", "1234,3", "1112,5", "6174,0"})
    void Examples(int input, int expected) {
        // countK(6621) -> 5
        // countK(6554) -> 4
        // countK(1234) -> 3
        // countK(1112) -> 5
        // countK(6174) -> 0

        // when
        int result = Task6.countK(input);

        // then
        assertThat(result)
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("Не четырехзначное число")
    @ValueSource(ints = {100, 10000})
    void NotFourDigitNumber(int input) {
        // then
        assertThatThrownBy(() -> Task6.countK(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Одинаковые цифры в числе")
    void SameDigitsTest() {
        // given
        int number = 5555;

        // then
        assertThatThrownBy(() -> Task6.countK(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
