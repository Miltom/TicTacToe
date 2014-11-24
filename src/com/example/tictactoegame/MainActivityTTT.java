package com.example.tictactoegame;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class MainActivityTTT extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_ttt);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment()).commit();
        }
    }
    
    /** Called when the user clicks the new game*/
    public void doNewGame(View view) {
        //TODO Tabelle löschen, farbzustand zurücksetzen
        setContentView(R.layout.activity_table);
    }
    
    /** Called when the user clicks the Startbutton on the startscreen */
    public void doStart(View view) {
        setContentView(R.layout.activity_table);
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
