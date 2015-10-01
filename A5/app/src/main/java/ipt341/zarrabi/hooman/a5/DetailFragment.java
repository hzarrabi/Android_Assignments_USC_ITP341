package ipt341.zarrabi.hooman.a5;

import android.app.Fragment;
import android.os.Bundle;
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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        //this links the appearance of layout of fragment
        View view = inflater.inflate(R.layout.detail_layout, container, false);

        name=(EditText) view.findViewById(R.id.name_field);
        picture=(ImageView) view.findViewById(R.id.profile_picture);
        email=(EditText) view.findViewById(R.id.email_field);
        phone= (EditText) view.findViewById(R.id.phone_field);
        address= (EditText) view.findViewById(R.id.address_field);
        notes= (EditText) view.findViewById(R.id.notes_field);

        return view;
    }


}
