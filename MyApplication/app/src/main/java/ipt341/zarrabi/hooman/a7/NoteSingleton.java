package ipt341.zarrabi.hooman.a7;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by Hooman Z on 10/27/2015.
 */
public class NoteSingleton {

    private ArrayList<Note> notes;//array of Note objects for all the notes we save

    private static NoteSingleton sNoteSingleton;//the static singleton for all notes

    private Context appContext;

    //private constructor for Singleton
    private NoteSingleton (Context context)
    {
        appContext = context;
    }

    private static NoteSingleton get(Context c)
    {
        if(sNoteSingleton==null)
        {
            sNoteSingleton = new NoteSingleton(c.getApplicationContext());
        }
        return sNoteSingleton;
    }

    public ArrayList<Note> getNotes() {return notes;}//returns whole array list of notes

    public Note getNote(int index) {return notes.get(index);}//returns specific note at index

    public void addNote(Note n) {notes.add(n);}//add a new note

    //when we want to delete a note
    public void removeNote(int index)
    {
        if(index>-1 && index<notes.size())
        {
            notes.remove(index);
        }
    }

    //when we make a change/edit to a note
    public void updateNote(int index, Note n)
    {
        notes.set(index,n);
    }

}
