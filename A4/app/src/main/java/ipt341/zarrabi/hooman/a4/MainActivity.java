package ipt341.zarrabi.hooman.a4;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.math.BigDecimal;

public class MainActivity extends Activity {

    private EditText amount;
    private TextView percentText;
    private SeekBar percentBar;
    private TextView tipAmount;
    private TextView totalAmount;
    private Spinner spinner;
    private TextView perPersontText;
    private TextView amountPerPerson;

    BigDecimal billAmount;
    BigDecimal tax;
    BigDecimal tip;
    BigDecimal total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        setListeners();
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
        percentBar.setMax(30);

        tipAmount = (TextView)findViewById(R.id.TipAmount);
        totalAmount = (TextView)findViewById(R.id.TotalAmount);
        spinner = (Spinner)findViewById(R.id.spinner);
        perPersontText = (TextView) findViewById(R.id.PerPersonText);
        amountPerPerson = (TextView) findViewById(R.id.PerPerson);

        billAmount= new BigDecimal("0.00");
        tax=new BigDecimal("0.00");
        tip=new BigDecimal("0.00");
        total=new BigDecimal("0.00");


        //the following two should inititally  be invisible
        perPersontText.setVisibility(View.INVISIBLE);
        amountPerPerson.setVisibility(View.INVISIBLE);
    }

    private void setListeners()
    {

        amount.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                billAmount=new BigDecimal(amount.getText().toString());//changing the bill amount

                return false;
            }
        });

        percentBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                percentText.setText(Integer.toString(progress)+"%");
                tax= new BigDecimal(progress/(100.00));
                Log.d("checking percent", "tax is" + tax.doubleValue());

                //tip=new BigDecimal(billAmount.)

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
