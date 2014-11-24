package com.example.tictactoegame;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

public class MainActivityTTT extends ActionBarActivity {

    private int[][] cellIds = new int[3][3];
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_ttt);

        
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment()).commit();
        }
        // Prepare the tic tac toe table
        initCells();
    }
    
    /** Called when the user clicks the new game*/
    public void doNewGame(View view) {
        //TODO Tabelle löschen, farbzustand zurücksetzen
        setContentView(R.layout.activity_table);
    }
    
    /** Called when the user clicks the Startbutton on the startscreen */
    public void doStart(View view) {
        //TODO sollte nicht jedes mal neu angepasst werden...
        setContentView(R.layout.activity_table);
        prepareTable();
    }
    
    /** Called when the user clicks the Startbutton on the startscreen */
    public void doLogin(View view) {
        setContentView(R.layout.activity_login);
    }

    /** Called when the user clicks the Computerbutton on the startscreen */
    public void doStartComputerGame(View view) {
        setContentView(R.layout.activity_table);
    }
    
    /** Called when the user clicks the exit button */
    public void doExit(View view) {
        setContentView(R.layout.fragment_main_activity_ttt);
    }
    
    
    private void initCells(){
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

    private void prepareTable(){
        Log.v("start", "preparing table");
        View sudokuTableLayout=  findViewById(R.id.ttt_table);
        Log.v("start", ""+sudokuTableLayout);
        
        TableLayout tLayout = (TableLayout) sudokuTableLayout;
        tLayout.setClickable(false);

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                TextView cell = (TextView) this.findViewById(cellIds[row][column]);
                cell.setMinHeight(cell.getWidth());
                Log.v("start", "cell: "+cell);
                Log.v("start", cell.getWidth()+"-"+cell.getHeight());
            }
        }

    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity_ttt, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main_activity_ttt, container, false);
            return rootView;
        }
    }

}
