package ipt341.zarrabi.hooman.a4;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends Activity {

    private EditText amount;
    private TextView percentText;
    private SeekBar percentBar;
    private TextView tipAmount;
    private TextView totalAmount;
    private Spinner spinner;
    private TextView perPersontText;
    private TextView amountPerPerson;

    double billAmount;
    double tax;
    double tip;
    double total;


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

        billAmount=0.00;
        tax=0.00;
        tip=0.00;
        total=0.00;


        //the following two should inititally  be invisible
        perPersontText.setVisibility(View.INVISIBLE);
        amountPerPerson.setVisibility(View.INVISIBLE);
    }

    private void setListeners()
    {

        amount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (amount.getText().toString().trim().length() == 0) billAmount=0.00;//in case the text edit is empty

                else billAmount = Double.parseDouble(amount.getText().toString());//changing the bill amount

                percentText.setText(Integer.toString(percentBar.getProgress()) + "%");
                tax = percentBar.getProgress() / 100.00;

                tip = billAmount * tax;
                tipAmount.setText(NumberFormat.getCurrencyInstance().format(tip));

                total = tip + billAmount;
                totalAmount.setText(NumberFormat.getCurrencyInstance().format(total));

                //changes per person amount if you change bill amount
                amountPerPerson.setText(NumberFormat.getCurrencyInstance().format(total/(spinner.getSelectedItemPosition()+1)));

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        percentBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                percentText.setText(Integer.toString(progress) + "%");
                tax = progress / 100.00;
                Log.d("checking percent", "tax is" + tax);

                tip = billAmount * tax;
                Log.d("checking percent", "tip is" + tip);
                tipAmount.setText(NumberFormat.getCurrencyInstance().format(tip));

                total = tip + billAmount;
                Log.d("checking percent", "total is" + tip);
                totalAmount.setText(NumberFormat.getCurrencyInstance().format(total));

                //changes the per person amount if you change tip percentage
                amountPerPerson.setText(NumberFormat.getCurrencyInstance().format(total/(spinner.getSelectedItemPosition()+1)));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    perPersontText.setVisibility(View.INVISIBLE);
                    amountPerPerson.setVisibility(View.INVISIBLE);
                }
                else
                {
                    perPersontText.setVisibility(View.VISIBLE);
                    amountPerPerson.setVisibility(View.VISIBLE);

                    amountPerPerson.setText(NumberFormat.getCurrencyInstance().format(total/(position+1)));
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                perPersontText.setVisibility(View.INVISIBLE);
                amountPerPerson.setVisibility(View.INVISIBLE);
            }
        });
    }
}
