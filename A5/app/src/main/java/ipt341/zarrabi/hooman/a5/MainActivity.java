package ipt341.zarrabi.hooman.a5;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //fragment manager used to interact with fragments inside an activity
        FragmentManager manager=getFragmentManager();

        //fragment transaction used to perform operation such as add, remove, replace, hide
        FragmentTransaction fragmentTransaction= manager.beginTransaction();//before adding transaction you begin it!

        if(savedInstanceState == null) {
            MasterFragment left = new MasterFragment();
            fragmentTransaction.add(R.id.left,left,"added left");//added the left fragment

            DetailFragment right = new DetailFragment();
            fragmentTransaction.add(R.id.right,right,"added right");

            fragmentTransaction.commit();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
