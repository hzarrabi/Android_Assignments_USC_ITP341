package ipt341.zarrabi.hooman.a5;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Hooman Z on 9/30/2015.
 */

//the following fragment class will hold the list of users
public class MasterFragment extends Fragment
{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        //this links the appearance of layout of fragment
        View view = inflater.inflate(R.layout.master_layout, container, false);
        return view;
    }


}
