package ipt341.zarrabi.hooman.a7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;

public class NoteEditActivity extends Activity {

    public static final String POSITION = "position";

    int position;//this will hold the position the note we clicked

    EditText title;
    EditText content;
    Button saveButton;
    Button deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_edit);

        title = (EditText) findViewById(R.id.titleEdit);
        content = (EditText) findViewById(R.id.contentEdit);
        saveButton = (Button)findViewById(R.id.saveButton);
        deleteButton= (Button)findViewById(R.id.deleteButton);

        //check if we pressed existing note or want to make a new one
        Intent i = getIntent();
        position = i.getIntExtra(POSITION, -1);

        //setting title and content of selected note
        if (position != -1) { //this means we are editing an existing listing
            Note editNote = NoteSingleton.get(this).getNote(position);
            if (editNote != null) { // this means we are editing old record
                loadData(editNote);
            }
        }
        //shouldn't be able to delete new entry
        else {deleteButton.setEnabled(false);}

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveAndClose();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteAndClose();
            }
        });



    }


    private void loadData(Note n)
    {
        title.setText(n.getTitle());
        content.setText(n.getContent());
    }


    private void saveAndClose()
    {
        Note n = new Note();

        n.setTitle(title.getText().toString());
        n.setContent(content.getText().toString());
        n.setDate(Calendar.getInstance().getTime());

        //we're updating the note object in array list
        if(position>-1)
        {
            NoteSingleton.get(this).updateNote(position,n);
        }
        else
        {
            NoteSingleton.get(this).addNote(n);//adding new note
        }
        setResult(RESULT_OK);
        finish();
    }

    private void deleteAndClose()
    {
        if (position != -1) {    //this was an existing list we should update
            NoteSingleton.get(this).removeNote(position);
        }
        //else --there is nothing to delete becaues this was a new entry       }

        setResult(RESULT_OK);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_note_edit, menu);
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
