package ipt341.zarrabi.hooman.a8;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ChangeStock extends Activity {

    public static String POSITION;

    int position;

    TextView product;
    TextView brand;
    TextView price;
    TextView color;
    TextView stock;

    Button buy;
    Button sell;
    Button allSell;
    Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_stock);

        product = (TextView) findViewById(R.id.product);
        brand = (TextView) findViewById(R.id.brand);
        price = (TextView) findViewById(R.id.price);
        color = (TextView) findViewById(R.id.color);
        stock = (TextView) findViewById(R.id.stock);

        buy = (Button) findViewById(R.id.button2);
        sell = (Button) findViewById(R.id.button);
        allSell = (Button) findViewById(R.id.button3);
        delete = (Button) findViewById(R.id.button4);

        Intent i = getIntent();
        position = i.getIntExtra(POSITION, -1);

        final Stock s = StockSingleton.get(this).getStock(position);

        if(s.getStockNumber()==0)
        {
            sell.setEnabled(false);
            allSell.setEnabled(false);
        }

        product.setText(s.getName());
        brand.setText(s.getBrand());
        price.setText(s.getPrice());
        color.setText(s.getColor());
        stock.setText(Integer.toString(s.getStockNumber()));


        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s.increaseStock();
                stock.setText(Integer.toString(s.getStockNumber()));
                sell.setEnabled(true);
                allSell.setEnabled(true);
                setResult(RESULT_OK);
            }
        });

        sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(s.getStockNumber()==1)
                {
                    sell.setEnabled(false);
                    allSell.setEnabled(false);
                }
                s.decreaseStock();
                stock.setText(Integer.toString(s.getStockNumber()));
                setResult(RESULT_OK);
            }
        });

        allSell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sell.setEnabled(false);
                allSell.setEnabled(false);
                s.setStockNumber(0);
                stock.setText(Integer.toString(s.getStockNumber()));
                setResult(RESULT_OK);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StockSingleton.get(ChangeStock.this).deleteStock(position);
                setResult(RESULT_OK);
                finish();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_change_stock, menu);
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
