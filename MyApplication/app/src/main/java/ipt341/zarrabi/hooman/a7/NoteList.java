package ipt341.zarrabi.hooman.a7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

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
        listView = (ListView)findViewById(R.id.noteListView);

       /* //get notes and load into lists
        notes=NoteSingleton.get(this).getNotes();
        adapter=new ArrayAdapter<Note>(this,android.R.layout.simple_list_item_1, notes);
        listView.setAdapter(adapter);*/

        //get notes and load into lists
        notes=NoteSingleton.get(this).getNotes();
        NoteAdapter adapter2 =new NoteAdapter(this,notes);
        listView.setAdapter(adapter2);
        registerForContextMenu(listView);


        //listener for the  add button
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), NoteEditActivity.class);
                startActivityForResult(i, 0);//activity is for new note so no index needed to pass through
            }
        });


        //listener when note pressed
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                /*Toast.makeText(getApplicationContext(),
                        "Id: " + id + ", position: " + position, Toast.LENGTH_SHORT)
                        .show();*/

                Intent i = new Intent(getApplicationContext(), NoteEditActivity.class);
                i.putExtra(NoteEditActivity.POSITION, position);//passing index of note pressed to next activity
                startActivityForResult(i, 0);
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
