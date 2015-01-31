package ch.zhaw.students.mt.ttt.field;


import ch.zhaw.students.mt.ttt.main.MainActivityTTT;
import ch.zhaw.students.mt.ttt.player.Player;
import android.util.Log;
import android.widget.TextView;

public class TicTacToe {
    private Player firstPlayer;
    private Player secondPlayer;
    private Player currentPlayer;
    private MainActivityTTT mainActivityTTT;
    private int[] win;
    private int clicked;
    private static final String TAG = "TicTacToe::MainHelper";

    private TicTacToeCell[][] cells;

    public TicTacToe(MainActivityTTT mainActivityTTT) {
        this.mainActivityTTT = mainActivityTTT;
        this.cells = new TicTacToeCell[3][3];
        this.win = new int[3];
        this.clicked = 0;
    }

    private void initCells(int[][] cellsID) {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                cells[row][column] = new TicTacToeCell(row, column, cellsID[row][column],
                        (TextView) mainActivityTTT.findViewById(cellsID[row][column]));
            }
        }
    }

    public Player getCurrentPlayer() {
        if (currentPlayer == null) {
            currentPlayer = firstPlayer;
        }

        return currentPlayer;
    }

    public void changeCurrentPlayer() {

        if (currentPlayer.equals(secondPlayer)) {
            currentPlayer = firstPlayer;
        } else {
            currentPlayer = secondPlayer;
        }
        
    }

    public void restart() {
        this.currentPlayer = firstPlayer;
        this.win = new int [3];
        this.clicked = 0;
    }

    public void setFirstPlayer(Player firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public void setSecondPlayer(Player secondPlayer) {
        this.secondPlayer = secondPlayer;
    }

    public int[] check(int cellID) {
        clicked++;

        int row = -1, column = -1;
        TextView view = null;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j].getCellID() == cellID) {
                    row = i;
                    column = j;
                    view = cells[i][j].getView();
                    break;
                }
            }
        }

        if (row == -1) {
            return null;
        }

        TTTSigns sign = TTTSigns.getSign(view.getText().toString());

        if (checkColumn(sign, column)) {
            return win;
        }

        if (checkRow(sign, row)) {
            return win;
        }

        if (checkDiagonal(sign)) {
            return win;
        }

        return null;
    }

    private boolean checkDiagonal(TTTSigns sign) {
        String middle = cells[1][1].getView().getText().toString();
        if (middle.equals("")) {
            return false;
        }

        String topLeft = cells[0][0].getView().getText().toString();
        String bottomRight = cells[2][2].getView().getText().toString();

        if (topLeft.equals(middle) && bottomRight.equals(middle)) {
            win[0] = 0;
            win[1] = 4;
            win[2] = 8;
            return true;
        }

        String bottomLeft = cells[2][0].getView().getText().toString();
        String topRight = cells[0][2].getView().getText().toString();

        if (topRight.equals(middle) && bottomLeft.equals(middle)) {
            win[0] = 2;
            win[1] = 4;
            win[2] = 6;
            return true;
        }

        return false;
    }

    private boolean checkRow(TTTSigns sign, int row) {
        for (int column = 0; column < 3; column++) {
            if (!cells[row][column].getView().getText().toString().equals(sign.getSign())) {
                return false;
            }
        }
        win[0] = row*3;
        win[1] = row*3 + 1;
        win[2] = row*3 + 2;
        return true;
    }

    private boolean checkColumn(TTTSigns sign, int column) {
        for (int row = 0; row < 3; row++) {
            if (!cells[row][column].getView().getText().toString().equals(sign.getSign())) {
                return false;
            }
        }
        win[0] = column;
        win[1] = column + 3;
        win[2] = column + 6;
        return true;
    }

    public void fillCellIds(int[][] cellIds) {
        initCells(cellIds);
    }

    public int[] getWin() {
        return win;
    }
    
    public int getClicked() {
        return clicked;
    }
}
