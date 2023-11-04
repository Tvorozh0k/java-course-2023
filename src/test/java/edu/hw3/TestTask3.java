package edu.hw3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask3 {

    static Stream<Object> ExamplesData() {
        return Stream.of(
            Arguments.of(new ArrayList<>(List.of("a", "bb", "a", "bb")), new HashMap<>(Map.of("a", 2, "bb", 2))),
            Arguments.of(new ArrayList<>(List.of("this", "and", "that", "and")), new HashMap<>(Map.of("and", 2, "this", 1, "that", 1))),
            Arguments.of(new ArrayList<>(List.of("код", "код", "код", "bug")), new HashMap<>(Map.of("bug", 1, "код", 3))),
            Arguments.of(new ArrayList<>(List.of(1, 1, 2, 2)), new HashMap<>(Map.of(1, 2, 2, 2)))
        );
    }

    @ParameterizedTest
    @MethodSource("ExamplesData")
    @DisplayName("Примеры к заданию")
    <T> void Examples(ArrayList<T> input, HashMap<T, Integer> expected) {
        // freqDict(["a", "bb", "a", "bb"]) → {"bb": 2, "a": 2}
        // freqDict(["this", "and", "that", "and"]) →   {"that": 1, "and": 2, "this": 1}
        // freqDict(["код", "код", "код", "bug"]) → {"код": 3, "bug": 1}
        // freqDict([1, 1, 2, 2]) → {1: 2, 2: 2}

        // when
        HashMap<T, Integer> result = Task3.freqDict(input);

        // then
        assertThat(result)
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Проверка пустого листа")
    void EmptyListTest() {
        // given
        ArrayList<Integer> input = new ArrayList<>();

        // when
        HashMap<Integer, Integer> result = Task3.freqDict(input);

        // then
        assertThat(result)
            .isEqualTo(new HashMap<Integer, Integer>());
    }
}
