package com.example.tictactoegame;

public class Player {

    private String name;
    private int id;
    private TTTSigns tttSign;

    public Player(String name, int id, TTTSigns tttSign) {
        this.name = name;
        this.id = id;
        this.tttSign = tttSign;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TTTSigns getTttSign() {
        return tttSign;
    }
}
