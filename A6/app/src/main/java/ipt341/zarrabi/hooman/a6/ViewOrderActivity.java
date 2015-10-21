package ipt341.zarrabi.hooman.a6;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ViewOrderActivity extends Activity {

    TextView brew;
    TextView size;
    TextView milk;
    TextView sugar;
    TextView instructions;
    Button confirm;
    Button cancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order);

        brew = (TextView) findViewById(R.id.brew);
        size = (TextView) findViewById(R.id.size);
        milk = (TextView) findViewById(R.id.milk);
        sugar = (TextView) findViewById(R.id.sugar);
        instructions = (TextView) findViewById(R.id.theInstructions);
        confirm = (Button) findViewById(R.id.confirm);
        cancel = (Button) findViewById(R.id.cancel);

        brew.setText(getIntent().getStringExtra(MainActivity.BREW));

        //size
        if(getIntent().getIntExtra(MainActivity.SIZE,-1)==0)
        {
            size.setText("(Small)");
        }
        else if(getIntent().getIntExtra(MainActivity.SIZE,-1)==1)
        {
            size.setText("(Medium)");
        }
        else if(getIntent().getIntExtra(MainActivity.SIZE,-1)==2)
        {
            size.setText("(Large)");
        }


        //milk
        if(getIntent().getBooleanExtra(MainActivity.MILK,false))
        {
            milk.setText("with milk");
        }
        else milk.setText("no milk");

        //sugar
        if(getIntent().getBooleanExtra(MainActivity.SUGAR,false))
        {
            sugar.setText("with sugar");
        }
        else sugar.setText("no sugar");


        instructions.setText(getIntent().getStringExtra(MainActivity.INSTRUCTIONS));

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK, null);
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_order, menu);
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
