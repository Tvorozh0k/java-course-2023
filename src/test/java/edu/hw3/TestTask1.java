package edu.hw3;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask1 {

    static Stream<Arguments> ExamplesData() {
        String longInput = "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler";
        String longAnswer = "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi";

        return Stream.of(
            Arguments.of("Hello world!", "Svool dliow!"),
            Arguments.of(longInput, longAnswer)
        );
    }

    @ParameterizedTest
    @MethodSource("ExamplesData")
    @DisplayName("Примеры к заданию")
    void Examples(String input, String expected) {
        // atbash("Hello world!") -> "Svool dliow!"
        // atbash("Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler") ->
        // "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi"

        // when
        String result = Task1.atbash(input);

        // then
        assertThat(result)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Проверка букв английского языка")
    void EnglishLettersTest() {
        // given
        String input = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // when
        String result = Task1.atbash(input);

        // then
        assertThat(result)
            .isEqualTo("zyxwvutsrqponmlkjihgfedcbaZYXWVUTSRQPONMLKJIHGFEDCBA");
    }

    @Test
    @DisplayName("Проверка прочих символов")
    void OtherSymbolsTest() {
        // given
        String input = "1234567890!@#$%^&*()_+-=|?\"<>,.;[{:}]'";

        // when
        String result = Task1.atbash(input);

        // then
        assertThat(result)
            .isEqualTo(input);
    }

    @Test
    @DisplayName("Проверка пустой строки")
    void EmptyStringTest() {
        // given
        String input = "";

        // when
        String result = Task1.atbash(input);

        // then
        assertThat(result)
            .isEqualTo(input);
    }
}
