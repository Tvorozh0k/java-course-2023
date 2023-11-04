package edu.hw3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class TestTask2 {

    static Stream<Arguments> ExamplesData() {
        return Stream.of(
            Arguments.of("()()()", new ArrayList<String>(List.of("()", "()", "()"))),
            Arguments.of("((()))", new ArrayList<String>(List.of("((()))"))),
            Arguments.of("((()))(())()()(()())", new ArrayList<String>(List.of("((()))", "(())", "()", "()", "(()())")))
        );
    }

    @ParameterizedTest
    @MethodSource("ExamplesData")
    @DisplayName("Примеры к заданию")
    void Examples(String input, ArrayList<String> expected) {
        // clusterize("()()()") -> ["()", "()", "()"]
        // clusterize("((()))") -> ["((()))"]
        // clusterize("((()))(())()()(()())") -> ["((()))", "(())", "()", "()", "(()())"]

        // when
        ArrayList<String> result = Task2.clusterize(input);

        // then
        assertThat(result)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Лишние левые скобки")
    void LeftBracesTest() {
        // given
        String input = "((())((()))";

        // then
        assertThatThrownBy(() -> Task2.clusterize(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Лишние правые скобки")
    void RightBracesTest() {
        // given
        String input = "((()))(()))";

        // then
        assertThatThrownBy(() -> Task2.clusterize(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Неверный формат ввода")
    void IncorrectInputTest() {
        // given
        String input = "(()(abc))";

        // then
        assertThatThrownBy(() -> Task2.clusterize(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Проверка пустой строки")
    void EmptyStringTest() {
        // given
        String input = "";

        // when
        ArrayList<String> result = Task2.clusterize(input);

        // then
        assertThat(result)
            .isEqualTo(new ArrayList<String>());
    }
}
