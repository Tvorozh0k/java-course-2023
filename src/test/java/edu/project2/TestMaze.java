package edu.project2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class TestMaze {

    static Stream<Arguments> ExamplesData1() {

        return Stream.of(
            Arguments.of(-1, 3),
            Arguments.of(3, -1),
            Arguments.of(2, 3),
            Arguments.of(3, 2)
        );
    }

    static Stream<Arguments> ExamplesData2() {

        return Stream.of(
            Arguments.of(-1, 0, 1, 1),
            Arguments.of(0, -1, 1, 1),
            Arguments.of(100, 0, 1, 1),
            Arguments.of(0, 100, 1, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("ExamplesData1")
    @DisplayName("Некорректные входные данные")
    void IncorrectInputTests1(int rows, int cols) {
        // then
        assertThatThrownBy(() -> new Maze(rows, cols, Maze.AlgorithmType.Prim))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("ExamplesData2")
    @DisplayName("Некорректные входные данные")
    void IncorrectInputTests2(int i1, int j1, int i2, int j2) {
        var maze = new Maze(5,5, Maze.AlgorithmType.Prim);
        var solver = new MazeSolver(maze);

        // then
        assertThatThrownBy(() -> solver.BFS(i1, j1, i2, j2))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
