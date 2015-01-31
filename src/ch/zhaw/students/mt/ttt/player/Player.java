package ch.zhaw.students.mt.ttt.player;

import ch.zhaw.students.mt.ttt.field.TTTSigns;

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
