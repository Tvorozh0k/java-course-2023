package edu.hw2.Task1;

public sealed interface Expr {
    double evaluate();

    public record Constant(double num) implements Expr {
        @Override
        public double evaluate() {
            return num;
        }
    }

    public record Negate(Expr fst) implements Expr {
        @Override
        public double evaluate() {
            return -fst.evaluate();
        }
    }

    public record Exponent(Expr fst, double snd) implements Expr {
        @Override
        public double evaluate() {
            return Math.pow(fst.evaluate(), snd);
        }
    }

    public record Addition(Expr fst, Expr snd) implements Expr {
        @Override
        public double evaluate() {
            return fst.evaluate() + snd.evaluate();
        }
    }

    public record Multiplication(Expr fst, Expr snd) implements Expr {
        @Override
        public double evaluate() {
            return fst.evaluate() * snd.evaluate();
        }
    }
}
