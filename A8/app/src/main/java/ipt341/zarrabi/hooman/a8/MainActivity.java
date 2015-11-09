package ipt341.zarrabi.hooman.a8;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class MainActivity extends Activity {

    ArrayList<Stock> stocks;
    StockAdapter adapter;
    ListView stockList;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stocks = StockSingleton.get(this).getStocks();//connecting the stock array list to singleton
        adapter= new StockAdapter(this,stocks);

        stockList = (ListView) findViewById(R.id.stockListView);
        addButton = (Button) findViewById(R.id.button_add);

        //reading from stock.json
        byte[] buffer = null;
        InputStream is = null;
        String json = null;

        try {
            //read file and create string of json
            is = getAssets().open("stocks.json");
            int size = is.available();
            buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

            //make json object from string
            JSONObject jsonObject = new JSONObject(json);
            jsonObject = (JSONObject) jsonObject.get("stock");//we get the outer object json

            //iterate through the keys and grab each Json object by grabbing keys
            Iterator x = jsonObject.keys();//iterator for all objects in key

            while (x.hasNext()){
                String name = (String) x.next();
                JSONObject anObject = (JSONObject) jsonObject.get(name);
                String price = anObject.getString("price");
                int id = anObject.getInt("id");
                String color = anObject.getString("color");
                String brand = anObject.getString("brand");
                int numStocks = anObject.getInt("stock");
                Stock s = new Stock(name, brand, color, price,numStocks);
                stocks.add(s);//added to stocks list
                //alphabetize
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        //alphabetizing
        Collections.sort(stocks, new Comparator<Stock>() {
            @Override
            public int compare(Stock lhs, Stock rhs) {
                return (lhs.getName().toLowerCase()).compareTo(rhs.getName().toLowerCase());
            }
        });

        stockList.setAdapter(adapter);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), AddStock.class);
                startActivityForResult(i, 0);
            }
        });

        stockList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), ChangeStock.class);
                i.putExtra(ChangeStock.POSITION, position);//passing index of note pressed to next activity
                startActivityForResult(i, 0);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            Collections.sort(stocks, new Comparator<Stock>() {
                @Override
                public int compare(Stock lhs, Stock rhs) {
                    return (lhs.getName().toLowerCase()).compareTo(rhs.getName().toLowerCase());
                }
            });
            adapter.notifyDataSetChanged();
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
