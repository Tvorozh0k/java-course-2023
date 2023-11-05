package edu.project2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.stream.Collectors;

public class MazeSolver {

    private final Maze maze;
    private final ArrayList<ArrayList<Maze.PointType>> grid;

    private final int[] iDelta = {-1, 0, 0, 1};
    private final int[] jDelta = {0, -1, 1, 0};

    public MazeSolver(Maze maze) {
        this.maze = maze;
        this.grid = new ArrayList<>();

        int i = 0;

        for (var list : maze.grid()) {
            grid.add(new ArrayList<>());

            for (var elem : list) {
                grid.get(i).add(elem);
            }

            ++i;
        }
    }

    public void BFS(int i1, int j1, int i2, int j2) throws IllegalArgumentException {
        int rows = maze.rows();
        int cols = maze.cols();

        if (!(0 <= i1 && i1 < rows && 0 <= j1 && j1 < cols)) {
            throw new IllegalArgumentException("Ошибка: индексы точки выходят за пределы лабиринта");
        }

        if (!(0 <= i2 && i2 < rows && 0 <= j2 && j2 < cols)) {
            throw new IllegalArgumentException("Ошибка: индексы точки выходят за пределы лабиринта");
        }

        if (grid.get(i1).get(j1).equals(Maze.PointType.Wall)) {
            throw new IllegalArgumentException("Ошибка: точка является стеной");
        }

        if (grid.get(i2).get(j2).equals(Maze.PointType.Wall)) {
            throw new IllegalArgumentException("Ошибка: точка является стеной");
        }

        ArrayList<ArrayList<Integer>> parent = new ArrayList<>();

        for (int i = 0; i < rows; ++i) {
            parent.add(new ArrayList<>(Collections.nCopies(cols, -1)));
        }

        Queue<Integer> points = new ArrayDeque<>();
        points.add(i1 * cols + j1);
        parent.get(i1).set(j1, i1 * cols + j1);

        while (!points.isEmpty()) {
            int cur = points.remove();

            int i = cur / cols;
            int j = cur % cols;

            for (int k = 0; k < 4; ++k) {
                int iNew = i + iDelta[k];
                int jNew = j + jDelta[k];

                if (0 <= iNew && iNew < rows && 0 <= jNew && jNew < cols &&
                    !grid.get(iNew).get(jNew).equals(Maze.PointType.Wall) &&
                    parent.get(iNew).get(jNew).equals(-1)) {
                    parent.get(iNew).set(jNew, i * cols + j);
                    points.add(iNew * cols + jNew);
                }
            }
        }

        if (parent.get(i2).get(j2).equals(-1)) {
            System.out.printf("Пути из точки (%d, %d) в точку (%d, %d) не нашлось\n\n", i1, j1, i2, j2);
            return;
        }

        int i = i2;
        int j = j2;

        while (i1 != i || j1 != j) {
            grid.get(i).set(j, Maze.PointType.Path);

            int p = parent.get(i).get(j);

            i = p / cols;
            j = p % cols;
        }

        grid.get(i1).set(j1, Maze.PointType.Start);
        grid.get(i2).set(j2, Maze.PointType.Finish);

        for (int ind = 0; ind < rows; ++ind) {
            System.out.println(grid.get(ind).stream().map(Maze.PointType::toString).collect(Collectors.joining()));
        }
    }
}
