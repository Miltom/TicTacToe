package ch.zhaw.students.mt.ttt.player;

import ch.zhaw.students.mt.ttt.field.TTTSigns;

public class Computer extends APlayer{

    public Computer(String name, int id, TTTSigns tttSign) {
       super(name, id, tttSign);
    }

    @Override
    public boolean automaticPlay() {
        return true;
    }

}
