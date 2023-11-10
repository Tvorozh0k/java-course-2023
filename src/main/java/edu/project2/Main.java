package edu.project2;

public class Main {

    public static void main(String[] args) {
        System.out.println("Создаем лабиринт при помощи алгоритма RecursiveBacktracking:\n");

        var maze1 = new Maze(19, 19, Maze.AlgorithmType.RecursiveBacktracking);
        maze1.printMaze();

        System.out.println("\nСоздаем маршрут из точки А(1, 1) в точку B(17, 17):\n");

        var solver1 = new MazeSolver(maze1);
        solver1.bfs(1, 1, 17, 17);

        System.out.println("\nСоздаем лабиринт при помощи алгоритма Prim:\n");

        var maze2 = new Maze(13, 19, Maze.AlgorithmType.Prim);
        maze2.printMaze();

        System.out.println("\nСоздаем маршрут из точки А(1, 1) в точку B(11, 17):\n");

        var solver2 = new MazeSolver(maze2);
        solver2.bfs(1, 1, 11, 17);
    }
}
