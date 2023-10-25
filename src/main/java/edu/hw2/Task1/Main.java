package edu.hw2.Task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Main {

    private final static Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) throws Exception {
        var two = new Expr.Constant(2);
        var four = new Expr.Constant(4);

        LOGGER.info(String.format("two = %.2f", two.evaluate()));
        LOGGER.info(String.format("four = %.2f", four.evaluate()));

        var negOne = new Expr.Negate(new Expr.Constant(1));

        LOGGER.info(String.format("negOne = %.2f", negOne.evaluate()));

        var sumTwoFour = new Expr.Addition(two, four);

        LOGGER.info(String.format("sumTwoFour = %.2f", sumTwoFour.evaluate()));

        var mult = new Expr.Multiplication(sumTwoFour, negOne);

        LOGGER.info(String.format("mult = %.2f", mult.evaluate()));

        var exp = new Expr.Exponent(mult, 2);

        LOGGER.info(String.format("exp = %.2f", exp.evaluate()));

        var res = new Expr.Addition(exp, new Expr.Constant(1));

        LOGGER.info(String.format("res = %.2f", res.evaluate()));
    }
}
