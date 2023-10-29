package edu.hw3;

import java.util.ArrayList;
import java.util.Stack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task2 {

    private final static Logger LOGGER = LogManager.getLogger();

    /**
     * Cluster strings
     * @param str The input string
     * @return The clustered strings
     */
    static ArrayList<String> clusterize(String str) throws IllegalArgumentException {
        if (!str.matches("[()]*")) {
            throw new IllegalArgumentException("Ошибка: строка не является правильной скобочной последовательностью");
        }

        // The clustered string (there is nothing now)
        ArrayList<String> result = new ArrayList<>();

        // Positions of the left braces
        Stack<Integer> leftPositions = new Stack<>();

        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == '(') {
                leftPositions.push(i);
            } else if (!leftPositions.isEmpty()) {
                int left = leftPositions.pop();

                if (leftPositions.isEmpty()) {
                    result.add(str.substring(left, i + 1));
                }
            } else {
                throw new IllegalArgumentException("Ошибка: строка не является правильной скобочной последовательностью");
            }
        }

        if (!leftPositions.isEmpty()) {
            throw new IllegalArgumentException("Ошибка: строка не является правильной скобочной последовательностью");
        }

        return result;
    }

    public static void main(String[] args) {
        // clusterize("()()()") -> ["()", "()", "()"]
        LOGGER.info(clusterize("()()()"));

        // clusterize("((()))") -> ["((()))"]
        LOGGER.info(clusterize("((()))"));

        // clusterize("((()))(())()()(()())") -> ["((()))", "(())", "()", "()", "(()())"]
        LOGGER.info(clusterize("((()))(())()()(()())"));
    }
}
