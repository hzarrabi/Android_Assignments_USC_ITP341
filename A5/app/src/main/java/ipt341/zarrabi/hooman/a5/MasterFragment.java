package ipt341.zarrabi.hooman.a5;

import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
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
    private Button hooman_button;

    View.OnClickListener listener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        //this links the appearance of layout of fragment
        View view = inflater.inflate(R.layout.master_layout, container, false);

        rob_button = (Button) view.findViewById(R.id.rob_button);
        arjun_button = (Button) view.findViewById(R.id.arjun_button);
        hooman_button = (Button) view.findViewById(R.id.hooman_button);


        rob_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(rob_button);
            }
        });

        arjun_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(arjun_button);
            }
        });

        hooman_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(hooman_button);
            }
        });

        return view;
    }

    public void buttonListener(View.OnClickListener listener)
    {
        this.listener=listener;
    }

}
