package com.xexplotion.javafx;

import java.util.List;
import java.util.Random;

public class DungeonGenerator {
    private int[][] grid;
    private int rows;
    private int cols;

    public DungeonGenerator(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new int[rows][cols];
    }

    public void generate() {
        Random rand = new Random();
        // Fill the grid with random values (0 or 1)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = rand.nextInt(2);
            }
        }
    }
}
