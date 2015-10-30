package ipt341.zarrabi.hooman.a7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class NoteList extends Activity {

    Button buttonAdd;
    ListView listView;

    private ArrayList<Note> notes;
    private ArrayAdapter<Note> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_list);


        //connect views
        buttonAdd = (Button) findViewById(R.id.button_add);
        listView = (ListView)findViewById(R.id.listView);

        //get notes and load into lists
        notes=NoteSingleton.get(this).getNotes();
        adapter=new ArrayAdapter<Note>(this,android.R.layout.simple_list_item_1, notes);
        listView.setAdapter(adapter);


        //listener for the button
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent i = new Intent(getApplicationContext(),
                        AddEditCoffeeShopListing.class);
                startActivityForResult(i, 0);*/
                //TODO go to other activity to display note details and or edit
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
