package com.example.tictactoegame;

import android.widget.TextView;

public class TicTacToeCell {

    private int row;
    private int column;
    private boolean hasText;
    private TTTSigns content;
    private Player player;
    private int cellID;
    private TextView view;

    public TicTacToeCell(int row, int column, int cellID, TextView view) {
        this.row = row;
        this.column = column;
        this.cellID = cellID;
        this.view = view;

    }

    public int getCellID() {
        return cellID;
    }

    public void setCellID(int cellID) {
        this.cellID = cellID;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isHasText() {
        return hasText;
    }

    public void setHasText(boolean hasText) {
        this.hasText = hasText;
    }

    public TTTSigns getContent() {
        return content;
    }

    public void setContent(TTTSigns content) {
        this.content = content;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public TextView getView() {
        return view;
    }

}
