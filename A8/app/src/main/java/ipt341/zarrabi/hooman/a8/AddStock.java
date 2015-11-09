package ipt341.zarrabi.hooman.a8;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddStock extends Activity {

    EditText product;
    EditText brand;
    EditText price;
    EditText color;
    EditText stock;
    Button saveButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_stock);

        product = (EditText) findViewById(R.id.editProduct);
        brand = (EditText) findViewById(R.id.editBrand);
        price = (EditText) findViewById(R.id.EditPrice);
        color = (EditText) findViewById(R.id.editColor);
        stock = (EditText) findViewById(R.id.editStock);

        saveButton = (Button) findViewById(R.id.Save_button);


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Stock s = new Stock(product.getText().toString(),brand.getText().toString(),price.getText().toString(),color.getText().toString(),Integer.parseInt(stock.getText().toString()));
                StockSingleton.get(AddStock.this).addStock(s);//added new stock

                setResult(RESULT_OK);
                finish();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit, menu);
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
