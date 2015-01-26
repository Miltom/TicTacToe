package com.example.tictactoegame;

import android.util.Log;


public class TicTacToe {
    private Player firstPlayer;
    private Player secondPlayer;
    private Player currentPlayer;

    private static final String TAG = "TicTacToe::MainHelper";
    
    private TicTacToeCell[][] cells;

    public TicTacToe(int[][] cellsID) {
        this.cells = new TicTacToeCell[3][3];
        initCells(cellsID);
    }

    private void initCells(int[][] cellsID) {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                cells[row][column] = new TicTacToeCell(row, column, cellsID[row][column]);
            }
        }
    }

    public Player getCurrentPlayer(){
        if(currentPlayer==null){
            currentPlayer=firstPlayer;
        }
        
        return currentPlayer;
    }
    
    public void changeCurrentPlayer(){
        

        Log.i(TAG, "changeCurrentPlayer: currentPlayer.equals(secondPlayer) "+currentPlayer.equals(secondPlayer));
        
        if(currentPlayer.equals(secondPlayer)){
            currentPlayer=firstPlayer;

            Log.i(TAG, "changeCurrentPlayer:"+currentPlayer.getName());
        }else{
            currentPlayer=secondPlayer;
            Log.i(TAG, "changeCurrentPlayer:"+currentPlayer.getName());
        }
    }
    
    public void setFirstPlayer(Player firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public void setSecondPlayer(Player secondPlayer) {
        this.secondPlayer = secondPlayer;
    }

    public void check(){
        //TODO spiellogik
    }
    
}
