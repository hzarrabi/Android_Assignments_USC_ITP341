package ipt341.zarrabi.hooman.a6;

import android.app.Activity;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends Activity {

    private RadioGroup sizeGroup;
    private Spinner brewSpinner;
    private Switch sugarSwitch;
    private CheckBox milkCheckBox;
    private EditText instructionsEdit;
    private Button loadButton;
    private Button saveButton;
    private Button orderButton;
    private Button clearButton;

    CoffeeOrder order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sizeGroup = (RadioGroup) findViewById(R.id.sizeRadioGroup);
        brewSpinner = (Spinner) findViewById(R.id.brewSpinner);
        sugarSwitch = (Switch) findViewById(R.id.sugarSwitch);
        milkCheckBox = (CheckBox) findViewById(R.id.milkCheckBox);
        instructionsEdit = (EditText) findViewById(R.id.instructionsEditText);
        loadButton = (Button) findViewById(R.id.loadButton);
        saveButton = (Button) findViewById(R.id.saveButton);
        orderButton = (Button) findViewById(R.id.orderButton);
        clearButton = (Button) findViewById(R.id.clearButton);


        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Favorite saved.", Toast.LENGTH_SHORT).show();
            }
        });

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Favorite loaded.", Toast.LENGTH_LONG).show();
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
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
