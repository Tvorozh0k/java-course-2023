package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class TestTask7 {

    @Test
    @DisplayName("Пример 1")
    void Example1() {
        // rotateRight(8, 1) -> 4 // 1000 -> 0100

        // given
        int n = 8, shift = 1;

        // when
        int number = Task7.rotateRight(n, shift);

        // then
        assertThat(number)
            .isEqualTo(4);
    }

    @Test
    @DisplayName("Пример 2")
    void Example2() {
        // rotateLeft(16, 1) -> 1 // 10000 -> 00001

        // given
        int n = 16, shift = 1;

        // when
        int number = Task7.rotateLeft(n, shift);

        // then
        assertThat(number)
                .isEqualTo(1);
    }

    @Test
    @DisplayName("Пример 3")
    void Example3() {
        // rotateLeft(17, 2) -> 6 // 10001 -> 00110

        // given
        int n = 17, shift = 2;

        // when
        int number = Task7.rotateLeft(n, shift);

        // then
        assertThat(number)
                .isEqualTo(6);
    }

    @Test
    @DisplayName("rotateLeft с положительным сдвигом")
    void rotateLeftPositiveShift() {
        // rotateLeft(43, 3) -> 29 // 101011 -> 011101

        // given
        int n = 43, shift = 3;

        // when
        int number = Task7.rotateLeft(n, shift);

        // then
        assertThat(number)
                .isEqualTo(29);
    }

    @Test
    @DisplayName("rotateLeft с нулевым сдвигом")
    void rotateLeftZeroShift() {
        // rotateLeft(43, 0) -> 43

        // given
        int n = 43, shift = 0;

        // when
        int number = Task7.rotateLeft(n, shift);

        // then
        assertThat(number)
                .isEqualTo(43);
    }

    @Test
    @DisplayName("rotateLeft с отрицательным сдвигом")
    void rotateLeftNegativeShift() {
        // rotateLeft(43, -4) -> 46 // 101011 -> 101110

        // given
        int n = 43, shift = -4;

        // when
        int number = Task7.rotateLeft(n, shift);

        // then
        assertThat(number)
                .isEqualTo(46);
    }

    @Test
    @DisplayName("rotateLeft с нулевым числом")
    void rotateLeftZeroNumber() {
        // rotateLeft(0, 0) -> ошибка

        // given
        int n = 0, shift = 0;

        // then
        assertThatThrownBy(() -> Task7.rotateLeft(n, shift))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("rotateLeft с отрицательным числом")
    void rotateLeftNegativeNumber() {
        // rotateLeft(-5, 0) -> ошибка

        // given
        int n = -5, shift = 0;

        // then
        assertThatThrownBy(() -> Task7.rotateLeft(n, shift))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("rotateRight с положительным сдвигом")
    void rotateRightPositiveShift() {
        // rotateRight(43, 4) -> 46 // 101011 -> 101110

        // given
        int n = 43, shift = 4;

        // when
        int number = Task7.rotateRight(n, shift);

        // then
        assertThat(number)
                .isEqualTo(46);
    }

    @Test
    @DisplayName("rotateRight с нулевым сдвигом")
    void rotateRightZeroShift() {
        // rotateRight(43, 0) -> 43

        // given
        int n = 43, shift = 0;

        // when
        int number = Task7.rotateRight(n, shift);

        // then
        assertThat(number)
                .isEqualTo(43);
    }

    @Test
    @DisplayName("rotateRight с отрицательным сдвигом")
    void rotateRightNegativeShift() {
        // rotateRight(43, -3) -> 29 // 101011 -> 011101

        // given
        int n = 43, shift = -3;

        // when
        int number = Task7.rotateRight(n, shift);

        // then
        assertThat(number)
                .isEqualTo(29);
    }

    @Test
    @DisplayName("rotateRight с нулевым числом")
    void rotateRightZeroNumber() {
        // rotateRight(0, 0) -> ошибка

        // given
        int n = 0, shift = 0;

        // then
        assertThatThrownBy(() -> Task7.rotateRight(n, shift))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("rotateRight с отрицательным числом")
    void rotateRightNegativeNumber() {
        // rotateRight(-5, 0) -> ошибка

        // given
        int n = -5, shift = 0;

        // then
        assertThatThrownBy(() -> Task7.rotateRight(n, shift))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
