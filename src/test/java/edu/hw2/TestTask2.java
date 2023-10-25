package edu.hw2;

import edu.hw2.Task2.Rectangle;
import edu.hw2.Task2.Square;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask2 {
    static Arguments[] ExamplesData() {
        return new Arguments[]{
                Arguments.of(new Rectangle(), 200),
                Arguments.of(new Square(), 200)
        };
    }

    @ParameterizedTest
    @MethodSource("ExamplesData")
    @DisplayName("Примеры к заданию")
    void Examples(Rectangle rectangle, double area) {
        // when
        double result = rectangle.setWidth(20).setHeight(10).area();

        // then
        assertThat(result)
                .isEqualTo(area);
    }

    static Arguments[] SquaresData() {
        return new Arguments[]{
                Arguments.of(new Rectangle().setWidth(10).setHeight(10), 100),
                Arguments.of(new Square().setWidth(20), 400)
        };
    }

    @ParameterizedTest
    @MethodSource("SquaresData")
    @DisplayName("Тесты с квадратами")
    void SquareTest(Rectangle rectangle, double area) {
        // then
        assertThat(rectangle.area())
                .isEqualTo(area);
    }
}
