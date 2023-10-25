package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask1 {

    @ParameterizedTest
    @DisplayName("Примеры к заданию")
    @CsvSource({"01:00,60", "13:56,836", "10:60,-1"})
    void Examples(String input, int expected) {
        // minutesToSeconds("01:00") -> 60
        // minutesToSeconds("13:56") -> 836
        // minutesToSeconds("10:60") -> -1

        // when
        int result = Task1.minutesToSeconds(input);

        // then
        assertThat(result)
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("Некорректные символы в минутах")
    void IncorrectSymbolsMinutes() {
        // minutesToSeconds("aa:00") -> -1

        // given
        String str = "aa:00";

        // when
        int result = Task1.minutesToSeconds(str);

        // then
        assertThat(result)
                .isEqualTo(-1);
    }

    @Test
    @DisplayName("Некорректные символы в секундах")
    void IncorrectSymbolsSeconds() {
        // minutesToSeconds("00:bb") -> -1

        // given
        String str = "00:bb";

        // when
        int result = Task1.minutesToSeconds(str);

        // then
        assertThat(result)
                .isEqualTo(-1);
    }

    @Test
    @DisplayName("Отрицательные минуты")
    void NegativeMinutes() {
        // minutesToSeconds("-10:00") -> -1

        // given
        String str = "-10:00";

        // when
        int result = Task1.minutesToSeconds(str);

        // then
        assertThat(result)
                .isEqualTo(-1);
    }

    @Test
    @DisplayName("Отрицательные секунды")
    void NegativeSeconds() {
        // minutesToSeconds("00:-10") -> -1

        // given
        String str = "00:-10";

        // when
        int result = Task1.minutesToSeconds(str);

        // then
        assertThat(result)
                .isEqualTo(-1);
    }

    @Test
    @DisplayName("Переполнение минут 1")
    void MinutesOutOfRange1() {
        // minutesToSeconds("123456789:00") -> -1

        // given
        String str = "123456789:00";

        // when
        int result = Task1.minutesToSeconds(str);

        // then
        assertThat(result)
                .isEqualTo(-1);
    }

    @Test
    @DisplayName("Переполнение минут 2")
    void MinutesOutOfRange2() {
        // minutesToSeconds("99999999:00") -> -1

        // given
        String str = "99999999:00";

        // when
        int result = Task1.minutesToSeconds(str);

        // then
        assertThat(result)
                .isEqualTo(-1);
    }

    @Test
    @DisplayName("Переполнение минут и секунд")
    void OverallOutOfRange() {
        // minutesToSeconds("35791394:08") -> -1

        // given
        String str = "35791394:08";

        // when
        int result = Task1.minutesToSeconds(str);

        // then
        assertThat(result)
                .isEqualTo(-1);
    }

    @Test
    @DisplayName("Максимальное значение")
    void MaxVideoDuration() {
        // minutesToSeconds("35791394:07") -> 2147483647

        // given
        String str = "35791394:07";

        // when
        int result = Task1.minutesToSeconds(str);

        // then
        assertThat(result)
                .isEqualTo(2147483647);
    }
}
