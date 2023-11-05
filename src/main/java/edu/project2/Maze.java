package edu.project2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Maze {

    private final int rows;
    private final int cols;
    private final ArrayList<ArrayList<PointType>> grid;

    private final int[] iDelta = {-2, 0, 0, 2};
    private final int[] jDelta = {0, -2, 2, 0};

    private void Prim() {
        ArrayList<ArrayList<Integer>> frontiers = new ArrayList<>();

        int i = 2 * new Random().nextInt((rows - 1) / 2) + 1;
        int j = 2 * new Random().nextInt((cols - 1) / 2) + 1;

        frontiers.add(new ArrayList<>(List.of(i, j, i, j)));

        while (!frontiers.isEmpty()) {
            int pos = new Random().nextInt(frontiers.size());
            ArrayList<Integer> val = frontiers.remove(pos);

            i = val.get(2);
            j = val.get(3);

            if (grid.get(i).get(j).equals(PointType.Wall)) {
                grid.get(val.get(0)).set(val.get(1), PointType.Empty);
                grid.get(i).set(j, PointType.Empty);

                for (int k = 0; k < 4; ++k) {
                    int iNew = i + iDelta[k];
                    int jNew = j + jDelta[k];

                    if (0 <= iNew && iNew < rows && 0 <= jNew && jNew < cols && grid.get(iNew).get(jNew).equals(PointType.Wall)) {
                        frontiers.add(new ArrayList<>(List.of(i + iDelta[k] / 2, j + jDelta[k] / 2, iNew, jNew)));
                    }
                }
            }
        }
    }

    private void RecursiveBacktracking(int i, int j) {
        grid.get(i).set(j, PointType.Empty);

        ArrayList<Integer> choices = new ArrayList<>();

        for (int k = 0; k < 4; ++k) {
            int iNew = i + iDelta[k];
            int jNew = j + jDelta[k];

            if (0 <= iNew && iNew < rows && 0 <= jNew && jNew < cols) {
                choices.add(k);
            }
        }

        Collections.shuffle(choices);

        for (Integer k : choices) {
            int iNew = i + iDelta[k];
            int jNew = j + jDelta[k];

            if (grid.get(iNew).get(jNew).equals(PointType.Wall)) {
                grid.get(i + iDelta[k] / 2).set(j + jDelta[k] / 2, PointType.Empty);
                RecursiveBacktracking(iNew, jNew);
            }
        }
    }

    public Maze(int rows, int cols, AlgorithmType type) throws IllegalArgumentException {
        if (rows < 3 || rows % 2 == 0)  {
            throw new IllegalArgumentException("Ошибка: число строк в лабиринте должно быть нечетным положительным числом >= 3");
        }

        if (cols < 3 || cols % 2 == 0)  {
            throw new IllegalArgumentException("Ошибка: число столбцов в лабиринте должно быть нечетным положительным числом >= 3");
        }

        this.rows = rows;
        this.cols = cols;

        this.grid = new ArrayList<>();

        for (int i = 0; i < rows; ++i) {
            this.grid.add(new ArrayList<>(Collections.nCopies(cols, PointType.Wall)));
        }

        switch (type) {
            case Prim -> Prim();
            case RecursiveBacktracking -> RecursiveBacktracking(1, 1);
        }
    }

    public void printMaze() {
        for (int i = 0; i < rows; ++i) {
            System.out.println(grid.get(i).stream().map(PointType::toString).collect(Collectors.joining()));
        }
    }

    public int rows() {
        return rows;
    }

    public int cols() {
        return cols;
    }

    public ArrayList<ArrayList<PointType>> grid() {
        return new ArrayList<>(grid);
    }

    public enum AlgorithmType {
        Prim, RecursiveBacktracking
    }

    public enum PointType {
        Empty("  "),
        Wall("██"),
        Start("ST"),
        Finish("FN"),
        Path("..");

        private final String view;

        PointType(String view) {
            this.view = view;
        }

        @Override
        public String toString() {
            return view;
        }
    }
}
