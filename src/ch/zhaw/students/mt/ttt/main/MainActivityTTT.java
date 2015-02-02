package ch.zhaw.students.mt.ttt.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.tictactoegame.R;

public class MainActivityTTT extends ActionBarActivity {
    private static final String TAG = "TicTacToe::MainActivityTTT";
    
    private int[][] cellIds = new int[3][3];
    private MainHelper mainHelper;

    //TODO ttt table should be fixed after clicking, abwechselnd starten
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_ttt);
        mainHelper = new MainHelper(this, cellIds);
        
        Log.i(TAG, "Initialyze mainHelper");
 
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment()).commit();
        }
        
        // init cells
        mainHelper.initCells();
    }

    /** Called when the user clicks the new game */
    public void doNewGame(View view) {
        mainHelper.restart();
    }

    /** Called when the user clicks the Startbutton on the loginscreen */
    public void doStart(View view) {
        mainHelper.createPlayer();
        setContentView(R.layout.activity_table);
        mainHelper.start();
    }

    /** Called when the user clicks the Startbutton on the startscreen */
    public void doLogin(View view) {
        setContentView(R.layout.activity_login);
    }

    /** Called when the user clicks the Computerbutton on the startscreen */
    public void doStartComputerGame(View view) {
        mainHelper.playAgainstComputer();
        setContentView(R.layout.activity_table);
        mainHelper.start();
    }

    /** Called when the user clicks the exit button */
    public void doExit(View view) {
        mainHelper.restart();
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
