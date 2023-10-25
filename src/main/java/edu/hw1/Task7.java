package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task7 {

    private final static Logger LOGGER = LogManager.getLogger();

    /**
     * Circular Left Shift. For example:
     * <pre>
     *     int ex1 = rotateLeft(14, 1); // ex1 = 13
     *     int ex2 = rotateLeft(14, -1); // ex2 = 7
     * </pre>
     * @param n The number for circular left shift (must be <i>positive</i>)
     * @param shift The number of bits to shift
     * @return A new number
     * @throws IllegalArgumentException In case if n is not positive
     */
    static int rotateLeft(int n, int shift) throws IllegalArgumentException {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be positive");
        }

        int countOfBits = 32 - Integer.numberOfLeadingZeros(n);

        // let shift = p * countOfBits + q
        // then rotateLeft(n, shift) = rotateLeft(n, q)
        shift %= countOfBits;

        // shift \in [1 - countOfBits, countOfBits - 1] ->
        // -> shift \in [0, countOfBits - 1]
        if (shift < 0) {
            shift = (shift + countOfBits) % countOfBits;
        }

        // rotateLeft(n, shift) = rotateRight(n, countOfBits - shift)
        shift = countOfBits - shift;

        // 2^(countOfBits - shift) * (n mod 2^shift) + (n div 2^shift)
        return (1 << (countOfBits - shift)) * (n % (1 << shift)) + (n / (1 << shift));
    }

    /**
     * Circular Right Shift. For example:
     * <pre>
     *     int ex1 = rotateRight(14, 1); // ex1 = 7
     *     int ex2 = rotateRight(14, -1); // ex2 = 13
     * </pre>
     * @param n The number for circular right shift (must be <i>positive</i>)
     * @param shift The number of bits to shift
     * @return A new number
     * @throws IllegalArgumentException In case if n is not positive
     */
    static int rotateRight(int n, int shift) throws IllegalArgumentException {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be positive");
        }

        int countOfBits = 32 - Integer.numberOfLeadingZeros(n);

        // let shift = p * countOfBits + q
        // then rotateRight(n, shift) = rotateRight(n, q)
        shift %= countOfBits;

        // shift \in [1 - countOfBits, countOfBits - 1] ->
        // -> shift \in [0, countOfBits - 1]
        if (shift < 0) {
            shift = (shift + countOfBits) % countOfBits;
        }

        // 2^(countOfBits - shift) * (n mod 2^shift) + (n div 2^shift)
        return (1 << (countOfBits - shift)) * (n % (1 << shift)) + (n / (1 << shift));
    }

    public static void main(String[] args) throws IllegalArgumentException {
        // rotateRight(8, 1) -> 4 // 1000 -> 0100
        LOGGER.info(rotateRight(8, 1));
        LOGGER.info(rotateLeft(8, -1));

        // rotateLeft(16, 1) -> 1 // 10000 -> 00001
        LOGGER.info(rotateLeft(16, -1));
        LOGGER.info(rotateLeft(16, -1));

        // rotateLeft(17, 2) -> 6 // 10001 -> 00110
        LOGGER.info(rotateLeft(17, 2));
        LOGGER.info(rotateLeft(17, -2));
        LOGGER.info(rotateLeft(17, 7));
        LOGGER.info(rotateLeft(17, -7));

        // rotateLeft(16, 0) -> 16
        LOGGER.info(rotateLeft(16, 0));
        LOGGER.info(rotateLeft(16, 0));

    }
}
