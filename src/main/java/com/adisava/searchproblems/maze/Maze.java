package com.adisava.searchproblems.maze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Maze {

    public enum Cell {
        EMPTY(" "),
        BLOCKED("X"),
        START("S"),
        GOAL("G"),
        PATH("*");

        private final String code;

        Cell(String c) {
            code = c;
        }

        @Override
        public String toString() {
            return code;
        }
    }

    private final int rows, columns;
    private final MazeLocation start, goal;
    private Cell[][] grid;

    public Maze(int rows, int columns, MazeLocation start, MazeLocation goal,
                double sparseness) {

        // initialize basic instance variables
        this.rows = rows;
        this.columns = columns;
        this.start = start;
        this.goal = goal;

        // fill the grid with empty cells
        grid = new Cell[rows][columns];

        for (Cell[] row : grid) {
            Arrays.fill(row, Cell.EMPTY);
        }

        // populate the grid with blocked cells
        randomlyFill(sparseness);

        // fill the start and goal locations
        grid[start.row][start.column] = Cell.START;
        grid[goal.row][goal.column] = Cell.GOAL;
    }

    public Maze() {
        this(10, 10, new MazeLocation(0, 0), new MazeLocation(9, 9), 0.2);
    }

    private void randomlyFill(double sparseness) {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (Math.random() < sparseness) {
                    grid[row][column] = Cell.BLOCKED;
                }
            }
        }
    }

    public boolean goalTest(MazeLocation ml) {
        return goal.equals(ml);
    }

//    Simply checks each direction to see possible moves (assuming it is possible only
//    horizontally or vertically and one space at a time)
    public List<MazeLocation> successors(MazeLocation ml) {
        List<MazeLocation> locations = new ArrayList<>();
        if (ml.row + 1 < rows && grid[ml.row + 1][ml.column] != Cell.BLOCKED) {
            locations.add(new MazeLocation(ml.row + 1, ml.column));
        }
        if (ml.row - 1 >= 0 && grid[ml.row - 1][ml.column] != Cell.BLOCKED) {
            locations.add(new MazeLocation(ml.row - 1, ml.column));
        }
        if (ml.column + 1 < columns && grid[ml.row][ml.column + 1] != Cell.BLOCKED) {
            locations.add(new MazeLocation(ml.row, ml.column + 1));
        }
        if (ml.column - 1 >= 0 && grid[ml.row][ml.column - 1] != Cell.BLOCKED) {
            locations.add(new MazeLocation(ml.row, ml.column - 1));
        }
        return locations;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Cell[] row : grid) {
            for (Cell cell : row) {
                sb.append(cell.toString());
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Maze m = new Maze();
        System.out.println(m);
    }
}
