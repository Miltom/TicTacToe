package com.example.tictactoegame;

public enum TTTSigns {

    TTT_X("X"), TTT_O("O");

    private String sign;

    private TTTSigns(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    public static TTTSigns getSign(String text) {
        switch (text) {
        case "X":
            return TTT_X;
        case "O":
            return TTT_O;
        }
        
        return null;
    }

}
