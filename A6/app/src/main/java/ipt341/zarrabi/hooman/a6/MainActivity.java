package ipt341.zarrabi.hooman.a6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
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

    public static final String ORDER="YOUR ORDER";
    public static final String SIZE="SIZE";
    public static final String BREW="BREW";
    public static final String SUGAR="SUGAR";
    public static final String MILK="MILK";
    public static final String INSTRUCTIONS="INSTRUCTIONS";


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

        order=new CoffeeOrder(false,false,-1,"","");//instantiating order object

    //TODO for testing purposes delete later
   /*     sizeGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("dsfs","dfasdf");
                saveOrder();
            }
        });*/

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
                Intent i = new Intent(MainActivity.this, ViewOrderActivity.class);

                //size
                int radioButtonID = sizeGroup.getCheckedRadioButtonId();
                View radioButton = sizeGroup.findViewById(radioButtonID);
                int idx = sizeGroup.indexOfChild(radioButton);
                i.putExtra(MainActivity.SIZE, idx);

                //brew string
                i.putExtra(MainActivity.BREW, brewSpinner.getSelectedItem().toString());

                //sugar
                i.putExtra(MainActivity.SUGAR, sugarSwitch.isChecked());

                //milk
                i.putExtra(MainActivity.MILK, milkCheckBox.isChecked());

                //instructions
                i.putExtra(MainActivity.INSTRUCTIONS, instructionsEdit.getText().toString());

                startActivityForResult(i, 0);
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

    private void saveOrder()
    {
        //size
        int radioButtonID = sizeGroup.getCheckedRadioButtonId();
        View radioButton = sizeGroup.findViewById(radioButtonID);
        int idx = sizeGroup.indexOfChild(radioButton);
        Log.d("index", Integer.toString(idx));
        order.setSize(idx);

        //brew string
        order.setBrew(brewSpinner.getSelectedItem().toString());

        //sugar
        order.setSugar(sugarSwitch.isChecked());

        //milk
        order.setMilk(milkCheckBox.isChecked());

        //instructions
        order.setInstruction(instructionsEdit.getText().toString());
    }
}
