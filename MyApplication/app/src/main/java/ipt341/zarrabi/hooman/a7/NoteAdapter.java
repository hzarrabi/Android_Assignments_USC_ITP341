package ipt341.zarrabi.hooman.a7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Hooman Z on 10/30/2015.
 */

public class NoteAdapter extends ArrayAdapter<Note> {
    public NoteAdapter(Context context, ArrayList<Note> notes) {
        super(context, 0, notes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Note note = NoteSingleton.get(getContext()).getNote(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.note_item_cell, parent, false);
        }
        // Lookup view for data population
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView date = (TextView) convertView.findViewById(R.id.date);
        // Populate the data into the template view using the data object
        title.setText(note.getTitle());
        date.setText(new SimpleDateFormat("MM/dd/yyyy").format(note.getDate()));
        // Return the completed view to render on screen
        return convertView;
    }
}