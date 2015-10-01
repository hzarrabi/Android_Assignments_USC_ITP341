package ipt341.zarrabi.hooman.a5;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Hooman Z on 9/30/2015.
 */

//the following fragment class will hold the list of users
public class MasterFragment extends Fragment
{
    private Button rob_button;
    private Button arjun_button;
    private Button hooman_hooman;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        //this links the appearance of layout of fragment
        View view = inflater.inflate(R.layout.master_layout, container, false);

        rob_button=(Button) view.findViewById(R.id.rob_button);
        arjun_button=(Button) view.findViewById(R.id.arjun_button);
        hooman_hooman=(Button) view.findViewById(R.id.hooman_button);

        //getActivity();
        // TODO: 10/1/2015  connect listeners here

        return view;
    }


}
