package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask2 {

    @ParameterizedTest
    @DisplayName("Примеры к заданию")
    @CsvSource({"4666,4", "544,3", "0,1", "-544,3"})
    void Examples(int input, int expected) {
        // countDigits(4666) -> 4
        // countDigits(544) -> 3
        // countDigits(0) -> 1
        // countDigits(-544) -> 3

        // when
        int result = Task2.countDigits(input);

        // then
        assertThat(result)
                .isEqualTo(expected);
    }
}
