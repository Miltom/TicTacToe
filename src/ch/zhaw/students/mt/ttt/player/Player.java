package ch.zhaw.students.mt.ttt.player;

import ch.zhaw.students.mt.ttt.field.TTTSigns;

public class Player extends APlayer{

    public Player(String name, int id, TTTSigns tttSign) {
       super(name, id, tttSign);
    }

    @Override
    public boolean automaticPlay() {
        return false;
    }


}
