package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task8 {

    private final static Logger LOGGER = LogManager.getLogger();

    /**
     * Check if the knights are arranged on the chessboard in such a way
     * that no knight can capture another knight.
     * @param grid Chessboard, 1 means knight, 0 means empty square
     * @return <code>true</code> if the condition is satisfied, else <code>false</code>
     */
    static boolean knightBoardCapture(int[][] grid) throws IllegalArgumentException {
        if (grid.length != 8) {
            throw new IllegalArgumentException("The number of rows must be equal to 8");
        }

        for (int i = 0; i < 8; ++i) {
            if (grid[i].length != 8) {
                throw new IllegalArgumentException("The number of columns must be equal to 8");
            }
        }

        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (grid[i][j] != 0 && grid[i][j] != 1) {
                    throw new IllegalArgumentException("All elements of chessboard must be equal 0 or 1");
                }
            }
        }

        // The steps of the knight (8 possibilities)
        int[] di = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dj = {1, 2, 2, 1, -1, -2, -2, -1};

        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 8; ++k) {
                        // The position of attacking square
                        int iNew = i + di[k];
                        int jNew = j + dj[k];

                        // If this square exists and there is a knight
                        if (0 <= iNew && iNew < 8 && 0 <= jNew && jNew < 8 && grid[iNew][jNew] == 1) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IllegalArgumentException {
        int[][] grid1 = {{0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0}};

        LOGGER.info(knightBoardCapture(grid1));
    }
}
