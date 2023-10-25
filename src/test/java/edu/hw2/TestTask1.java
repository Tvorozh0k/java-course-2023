package edu.hw2;

import edu.hw2.Task1.Expr;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask1 {

    static Stream<Arguments> ExamplesData() {
        var two = new Expr.Constant(2);
        var four = new Expr.Constant(4);
        var negOne = new Expr.Negate(new Expr.Constant(1));
        var sumTwoFour = new Expr.Addition(two, four);
        var mult = new Expr.Multiplication(sumTwoFour, negOne);
        var exp = new Expr.Exponent(mult, 2);
        var res = new Expr.Addition(exp, new Expr.Constant(1));

        return Stream.of(
            Arguments.of(two, 2),
            Arguments.of(four, 4),
            Arguments.of(negOne, -1),
            Arguments.of(sumTwoFour, 6),
            Arguments.of(mult, -6),
            Arguments.of(exp, 36),
            Arguments.of(res, 37)
        );
    }

    @ParameterizedTest
    @MethodSource("ExamplesData")
    @DisplayName("Примеры к заданию")
    void Examples(Expr input, double expected) {
        // when
        double result = input.evaluate();

        // then
        assertThat(result)
            .isEqualTo(expected);
    }

    static Stream<Arguments> ConstantData() {
        return Stream.of(
            Arguments.of(1, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("ConstantData")
    @DisplayName("Проверка класса Constant")
    void CheckConstant(double input, double expected) {
        // when
        double result = new Expr.Constant(input).evaluate();

        // then
        assertThat(result)
            .isEqualTo(expected);
    }

    static Stream<Arguments> NegateData() {
        var one = new Expr.Constant(1);
        var two = new Expr.Constant(2);
        var three = new Expr.Constant(3);

        return Stream.of(
            Arguments.of(one, -1),
            Arguments.of(new Expr.Negate(two), 2),
            Arguments.of(new Expr.Exponent(three, 1), -3),
            Arguments.of(new Expr.Addition(two, two), -4),
            Arguments.of(new Expr.Multiplication(two, three), -6)
        );
    }

    @ParameterizedTest
    @MethodSource("NegateData")
    @DisplayName("Проверка класса Negate")
    void CheckNegate(Expr input, double expected) {
        // when
        double result = new Expr.Negate(input).evaluate();

        // then
        assertThat(result)
            .isEqualTo(expected);
    }

    static Stream<Arguments> ExponentData() {
        var one = new Expr.Constant(1);
        var two = new Expr.Constant(-2);
        var three = new Expr.Constant(3);

        return Stream.of(
            Arguments.of(one, 2, 1),
            Arguments.of(new Expr.Negate(two), 2, 4),
            Arguments.of(new Expr.Exponent(three, 1), 2, 9),
            Arguments.of(new Expr.Addition(two, two), 2, 16),
            Arguments.of(new Expr.Multiplication(two, three), 2, 36)
        );
    }

    @ParameterizedTest
    @MethodSource("ExponentData")
    @DisplayName("Проверка класса Exponent")
    void CheckExponent(Expr fst, double snd, double expected) {
        // when
        double result = new Expr.Exponent(fst, snd).evaluate();

        // then
        assertThat(result)
            .isEqualTo(expected);
    }

    static Stream<Arguments> AdditionData() {
        var one = new Expr.Constant(1);
        var two = new Expr.Constant(-2);
        var three = new Expr.Constant(3);

        return Stream.of(
            Arguments.of(one, new Expr.Multiplication(one, three), 4),
            Arguments.of(new Expr.Negate(two), new Expr.Addition(two, three), 3),
            Arguments.of(new Expr.Exponent(three, 1), new Expr.Exponent(two, 2), 7),
            Arguments.of(new Expr.Addition(one, three), new Expr.Negate(two), 6),
            Arguments.of(new Expr.Multiplication(one, two), three, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("AdditionData")
    @DisplayName("Проверка класса Addition")
    void CheckAddition(Expr fst, Expr snd, double expected) {
        // when
        double result = new Expr.Addition(fst, snd).evaluate();

        // then
        assertThat(result)
            .isEqualTo(expected);
    }

    static Stream<Arguments> MultiplicationData() {
        var one = new Expr.Constant(1);
        var two = new Expr.Constant(-2);
        var three = new Expr.Constant(3);

        return Stream.of(
            Arguments.of(one, new Expr.Multiplication(one, three), 3),
            Arguments.of(new Expr.Negate(two), new Expr.Addition(two, three), 2),
            Arguments.of(new Expr.Exponent(three, 1), new Expr.Exponent(two, 2), 12),
            Arguments.of(new Expr.Addition(one, three), new Expr.Negate(two), 8),
            Arguments.of(new Expr.Multiplication(one, two), three, -6)
        );
    }

    @ParameterizedTest
    @MethodSource("MultiplicationData")
    @DisplayName("Проверка класса Multiplication")
    void CheckMultiplication(Expr fst, Expr snd, double expected) {
        // when
        double result = new Expr.Multiplication(fst, snd).evaluate();

        // then
        assertThat(result)
            .isEqualTo(expected);
    }
}
