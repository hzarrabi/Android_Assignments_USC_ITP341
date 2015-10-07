package ipt341.zarrabi.hooman.a5;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by Hooman Z on 10/1/2015.
 */
public class DetailFragment extends Fragment
{
    EditText name;
    ImageView picture;
    EditText email;
    EditText phone;
    EditText address;
    EditText notes;

    String the_name;
    ImageView the_picture;
    String the_email;
    String the_phone;
    String the_address;
    String the_notes;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);



        //this links the appearance of layout of fragment
        View view = inflater.inflate(R.layout.detail_layout, container, false);

        name=(EditText) view.findViewById(R.id.name_field);
        name.setText(the_name);
        picture=(ImageView) view.findViewById(R.id.profile_picture);
        //// TODO: 10/6/2015
        email=(EditText) view.findViewById(R.id.email_field);
        email.setText(the_email);
        phone= (EditText) view.findViewById(R.id.phone_field);
        phone.setText(the_phone);
        address= (EditText) view.findViewById(R.id.address_field);
        address.setText(the_address);
        notes= (EditText) view.findViewById(R.id.notes_field);
        notes.setText(the_notes);

        return view;
    }

    public void getUser(User user)
    {
        the_name=user.name;
        the_email=user.email;
        the_phone=user.phone;
        the_address=user.address;
        the_notes=user.notes;
    }

    public void changeUser(User user)
    {
        name.setText(user.name);
        email.setText(user.email);
        phone.setText(user.phone);
        address.setText(user.address);
        notes.setText(user.notes);
    }


}
