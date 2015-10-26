package ipt341.zarrabi.hooman.a6;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
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

    SharedPreferences orderPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.LTGRAY)); // set your desired color

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

        orderPreferences = getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);


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
                //load size
                int size = orderPreferences.getInt(MainActivity.SIZE,-1);
                Log.d("size is",Integer.toString(size));
                if(size>=0 && size <=2)
                {
                    ((RadioButton)sizeGroup.getChildAt(size)).setChecked(true);
                }

                //brew
                String brew = orderPreferences.getString(MainActivity.BREW,null);
                brewSpinner.setSelection(getIndex(brewSpinner, brew));

                //sugar
                sugarSwitch.setChecked(orderPreferences.getBoolean(MainActivity.SUGAR,false));

                //milk
                milkCheckBox.setChecked(orderPreferences.getBoolean(MainActivity.MILK,false));

                //instructions
                instructionsEdit.setText(orderPreferences.getString(MainActivity.INSTRUCTIONS,""));

                Toast.makeText(getApplicationContext(), "Favorite loaded.", Toast.LENGTH_SHORT).show();


            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = orderPreferences.edit();

                int radioButtonID = sizeGroup.getCheckedRadioButtonId();
                View radioButton = sizeGroup.findViewById(radioButtonID);
                int idx = sizeGroup.indexOfChild(radioButton);
                editor.putInt(MainActivity.SIZE, idx);

                //brew string
                editor.putString(MainActivity.BREW, brewSpinner.getSelectedItem().toString());

                //sugar
                editor.putBoolean(MainActivity.SUGAR, sugarSwitch.isChecked());

                //milk
                editor.putBoolean(MainActivity.MILK, milkCheckBox.isChecked());

                //instructions
                editor.putString(MainActivity.INSTRUCTIONS, instructionsEdit.getText().toString());

                editor.commit();

                Toast.makeText(getApplicationContext(), "Favorite saved.", Toast.LENGTH_SHORT).show();
            }
        });

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ViewOrderActivity.class);

                saveOrder();
                i.putExtra(MainActivity.ORDER,order);

                startActivityForResult(i, 0);
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Enjoy your order!", Toast.LENGTH_LONG).show();
                sizeGroup.clearCheck();
                brewSpinner.setSelection(0);
                sugarSwitch.setChecked(false);
                milkCheckBox.setChecked(false);
                instructionsEdit.setText("");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


            if(resultCode == Activity.RESULT_OK) {
                Toast.makeText(getApplicationContext(), "Enjoy your order!", Toast.LENGTH_LONG).show();
                sizeGroup.clearCheck();
                brewSpinner.setSelection(0);
                sugarSwitch.setChecked(false);
                milkCheckBox.setChecked(false);
                instructionsEdit.setText("");
            }

            else {Toast.makeText(getApplicationContext(), "Let's try it again", Toast.LENGTH_LONG).show();}

    }//onActivityResult


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


    private int getIndex(Spinner spinner, String myString)
    {
        int index = 0;

        for (int i=0;i<spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(myString)){
                index = i;
                break;
            }
        }
        return index;
    }
}
