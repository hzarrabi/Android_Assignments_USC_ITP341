package ipt341.zarrabi.hooman.a4;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    private EditText amount;
    private TextView percentText;
    private SeekBar percentBar;
    private TextView tipAmount;
    private TextView totalAmount;
    private Spinner spinner;
    private TextView perPersontText;
    private TextView amountPerPerson;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    private void initialize()
    {
        amount = (EditText)findViewById(R.id.billAmount);
        percentText = (TextView)findViewById(R.id.percentAmount);
        percentBar= (SeekBar) findViewById(R.id.seekBar);
        tipAmount = (TextView)findViewById(R.id.TipAmount);
        totalAmount = (TextView)findViewById(R.id.TotalAmount);
        spinner = (Spinner)findViewById(R.id.spinner);
        perPersontText = (TextView) findViewById(R.id.PerPersonText);
        amountPerPerson = (TextView) findViewById(R.id.PerPerson);
    }
}
