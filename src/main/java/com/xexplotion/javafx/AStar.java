package com.xexplotion.javafx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Node {
    int row, col;
    int f, g, h;

    public Node(int row, int col, int f, int g, int h) {
        this.row = row;
        this.col = col;
        this.f = f;
        this.g = g;
        this.h = h;
    }
}

public class AStar {
    static int ROW = 3;
    static int COL = 3;
    static int[][] grid = new int[ROW][COL];
    static Node pinkNode = new Node(1,1,0,0,0);
    static Node greenNode = new Node(2,2,0,0,0);
    static Node redNode = new Node(0,0,0,0,0);
    static boolean pinkFound = false;
    static boolean redFound = false;

    // Check if the location is valid
    static boolean isValid(int row, int col) {
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL);
    }

    // Check if the location is blocked
    static boolean isBlocked(int row, int col) {
        return (grid[row][col]== 1);
    } static List<Node> findPath() {
        // Create a priority queue to store the open nodes
        PriorityQueue<Node> openList = new PriorityQueue<>((n1, n2) -> n1.f - n2.f);

        // Add the green room to the open list
        openList.add(greenNode);

        // Create a 2D array to store the closed nodes
        boolean[][] closedList = new boolean[ROW][COL];

        // Create a 2D array to store the came from information
        int[][] cameFrom = new int[ROW][COL];

        // Initialize the came from array
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                cameFrom[i][j] = -1;
            }
        }

        // While the open list is not empty
        while (!openList.isEmpty() && !redFound) {
            // Get the node with the lowest f value
            Node current = openList.poll();

            // If the current node is the pink room
            if (current.row == pinkNode.row && current.col == pinkNode.col) {
                pinkFound = true;
                pinkNode.g = current.g;
                pinkNode.h = current.h;
                pinkNode.f = current.f;
            }

            // If the current node is the red room
            if (current.row == redNode.row && current.col == redNode.col) {
                redFound = true;
                // Create a list to store the path
                List<Node> path = new ArrayList<>();

                // Trace back the path using the came from array
                while (cameFrom[current.row][current.col] != -1) {
                    int r = cameFrom[current.row][current.col] / COL;
                    int c = cameFrom[current.row][current.col] % COL;
                    current = new Node(r, c, 0, 0, 0);
                    path.add(current);
                }
//Add pink node to the path
                if(pinkFound) path.add(pinkNode);
// Reverse the path and return it
                Collections.reverse(path);
                return path;
            } // Add the current node to the closed list
            closedList[current.row][current.col] = true;

            // Check all 8 directions
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    // Skip if the direction is not a neighbor
                    if (Math.abs(i) == Math.abs(j)) {
                        continue;
                    }

                    // Get the neighbor coordinates
                    int r = current.row + i;
                    int c = current.col + j;

                    // Skip if the location is not valid or blocked
                    if (!isValid(r, c) || isBlocked(r, c) || closedList[r][c]) {
                        continue;
                    }

                    // Calculate the G cost
                    int g = current.g + 1;

                    // Calculate the H cost
                    int h = (Math.abs(r - redNode.row) + Math.abs(c - redNode.col));

                    // Calculate the F cost
                    int f = g + h;

                    // Create a new node
                    Node neighbor = new Node(r, c, f, g, h);

                    // Add the neighbor to the open list
                    openList.add(neighbor);

                    // Update the came from array
                    cameFrom[r][c] = current.row * COL + current.col;
                }
            }
        }
        return null;
    }
}

