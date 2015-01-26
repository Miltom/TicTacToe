package com.example.tictactoegame;

import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

public class MainHelper {

    private static final String TAG = "TicTacToe::MainHelper";
    private MainActivityTTT mainActivityTTT;
    private int[][] cellIds;
    private TicTacToe ttt;
    private String playerText;
    private TextView playerTextView;

    public MainHelper(MainActivityTTT mainActivityTTT, int[][] cellIds) {
        this.mainActivityTTT = mainActivityTTT;
        this.cellIds = cellIds;
        this.ttt = new TicTacToe(mainActivityTTT);
    }

    public void workNames() {
        if (!validPlayersNames()) {
            // TODO textfelder rot markieren
            return;
        }

        setPlayerNames();
    }

    public void start() {

        prepareTable();
        this.ttt.fillCellIds(cellIds);
        this.playerTextView = ((TextView) mainActivityTTT.findViewById(R.id.playerText));
        this.playerText = playerTextView.getText().toString();
        playerTextView.setText(ttt.getCurrentPlayer().getName() + " " + playerText);

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                ((TextView) mainActivityTTT.findViewById(cellIds[row][column]))
                        .setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                change(v);
                            }
                        });
            }
        }

    }

    private void change(View v) {
        Log.i(TAG, "click");
        TextView view = (TextView) v;

        if (!view.getText().equals("")) {
            return;
        }
        view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 33);

        Log.i(TAG, ttt.getCurrentPlayer().getName() + " "
                + ttt.getCurrentPlayer().getTttSign().getSign());

        view.setText(ttt.getCurrentPlayer().getTttSign().getSign());
        if (ttt.check(view.getId()) != null) {
            win();
            return;
        }

        ttt.changeCurrentPlayer();

        Log.i(TAG, ttt.getCurrentPlayer().getName());

        playerTextView.setText(ttt.getCurrentPlayer().getName() + " " + playerText);

        if (ttt.getClicked() == 9) {
            iterateCells(false, Color.RED);
            playerTextView.setText("Niemand hat gewonnen");
        }

    }

    private void iterateCells(boolean enabled, int color) {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                TextView cell = (TextView) mainActivityTTT.findViewById(cellIds[row][column]);
                cell.setEnabled(enabled);
                cell.setBackgroundColor(color);
            }
        }
    }
    private void iterateCells(boolean enabled) {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                TextView cell = (TextView) mainActivityTTT.findViewById(cellIds[row][column]);
                cell.setEnabled(enabled);
            }
        }
    }

    private void win() {
        Log.i(TAG, "WIN");
        int row;
        int[] win = ttt.getWin();

        for (int i = 0; i < 3; i++) {
            row = win[i] / 3;
            mainActivityTTT.findViewById(cellIds[row][win[i] % 3]).setBackgroundColor(Color.GREEN);
        }


        playerTextView.setText(ttt.getCurrentPlayer().getName() + " hat gewonnen");
        iterateCells(false);
    }

    private void setPlayerNames() {
        Log.i(TAG, "Get the names");

        String firstPlayerName = ((TextView) mainActivityTTT.findViewById(R.id.firstPlayerName))
                .getText().toString();

        Log.i(TAG, "Get the names " + firstPlayerName);
        String secondPlayerName = ((TextView) mainActivityTTT.findViewById(R.id.secondPlayerName))
                .getText().toString();
        Log.i(TAG, "Get the names" + secondPlayerName);

        Log.i(TAG, "Creates players");
        ttt.setFirstPlayer(new Player(firstPlayerName, R.id.firstPlayerName, TTTSigns.TTT_X));
        ttt.setSecondPlayer(new Player(secondPlayerName, R.id.secondPlayerName, TTTSigns.TTT_O));
    }

    private boolean validPlayersNames() {
        Log.i(TAG, "validPlayersNames");
        View v = mainActivityTTT.findViewById(R.id.firstPlayerName);
        Log.i(TAG, "" + ((TextView) mainActivityTTT.findViewById(R.id.firstPlayerName)).getText());

        String firstPlayerName = ((TextView) mainActivityTTT.findViewById(R.id.firstPlayerName))
                .getText().toString();
        String secondPlayerName = ((TextView) mainActivityTTT.findViewById(R.id.secondPlayerName))
                .getText().toString();

        if (firstPlayerName.equals("")) {
            ((TextView) mainActivityTTT.findViewById(R.id.firstPlayerName)).setText("Spieler 1");
        }

        if (secondPlayerName.equals("")) {
            ((TextView) mainActivityTTT.findViewById(R.id.secondPlayerName)).setText("Spieler 2");
        }

        // TODO falls nicht nur aber zu langer text etc.
        return true;
    }

    public void initCells() {
        cellIds[0][0] = R.id.cell_11;
        cellIds[0][1] = R.id.cell_12;
        cellIds[0][2] = R.id.cell_13;

        cellIds[1][0] = R.id.cell_21;
        cellIds[1][1] = R.id.cell_22;
        cellIds[1][2] = R.id.cell_23;

        cellIds[2][0] = R.id.cell_31;
        cellIds[2][1] = R.id.cell_32;
        cellIds[2][2] = R.id.cell_33;
    }

    private void prepareTable() {
        Log.v(TAG, "preparing table");
        View sudokuTableLayout = mainActivityTTT.findViewById(R.id.ttt_table);
        Log.v(TAG, "" + sudokuTableLayout);

        TableLayout tLayout = (TableLayout) sudokuTableLayout;
        tLayout.setClickable(false);

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                TextView cell = (TextView) mainActivityTTT.findViewById(cellIds[row][column]);
                cell.setMinHeight(cell.getWidth());
                Log.v(TAG, "cell: " + cell);
                Log.v(TAG, cell.getWidth() + "-" + cell.getHeight());
            }
        }

    }

    public void restart() {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                TextView cell = (TextView) mainActivityTTT.findViewById(cellIds[row][column]);
                cell.setText("");
                cell.setBackgroundColor(Color.WHITE);
                cell.setEnabled(true);
                cell.setBackgroundColor(Color.WHITE);
            }
        }

        ttt.restart();
        playerTextView.setText(ttt.getCurrentPlayer().getName() + " " + playerText);
    }
}
