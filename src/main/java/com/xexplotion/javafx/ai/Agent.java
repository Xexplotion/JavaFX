package com.xexplotion.javafx.ai;

import java.util.ArrayList;

public class Agent {
    private ArrayList<Move> movements;
    private String name;
    private int id;
    private Brain brain;
    private int[][] location;

    public Agent(String name, Brain brain, int id, ArrayList<Move> movements, int[][] location) {
        this.brain = brain;
        this.id = id;
        this.name = name;
        this.movements = movements;
        this.location = location;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Move> getMovements() {
        return this.movements;
    }

    public Brain getBrain() {
        return this.brain;
    }

    public int getId() {
        return this.id;
    }

    public int[][] getLocation() {
        return this.location;
    }
}
