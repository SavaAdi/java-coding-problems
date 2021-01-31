package com.adisava.searchproblems.maze;

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
}
