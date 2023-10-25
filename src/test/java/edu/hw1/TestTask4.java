package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask4 {

    @ParameterizedTest
    @DisplayName("Примеры к заданию")
    @CsvSource({"123456,214365", "hTsii  s aimex dpus rtni.g,This is a mixed up string.", "badce,abcde"})
    void Examples(String input, String expected) {
        // fixString("123456") ➞ "214365"
        // fixString("hTsii  s aimex dpus rtni.g") ➞ "This is a mixed up string."
        // fixString("badce") ➞ "abcde"

        // when
        String result = Task4.fixString(input);

        // then
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("Пример 4")
    void EmptyStringTest() {
        // fixString("") ➞ ""

        // given
        String str = "";

        // when
        String result = Task4.fixString(str);

        // then
        assertThat(result)
                .isEqualTo("");
    }
}
