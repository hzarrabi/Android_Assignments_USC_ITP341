package ipt341.zarrabi.hooman.a5;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

    User rob;
    User arjun;
    User hooman;

    FragmentManager manager;
    FragmentTransaction fragmentTransaction;

    MasterFragment left;
    DetailFragment right;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //fragment manager used to interact with fragments inside an activity
        manager=getFragmentManager();

        //fragment transaction used to perform operation such as add, remove, replace, hide

        if(savedInstanceState == null) {
            /*left = new MasterFragment();
            fragmentTransaction.add(left,"added left");//added the left fragment

            right = new DetailFragment();
            fragmentTransaction.add(right,"added right");

            fragmentTransaction.commit();*/

            initializeUsers();

            left=(MasterFragment) manager.findFragmentById(R.id.left);

            left.buttonListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentTransaction fragmentTransaction =manager.beginTransaction();

                    switch(v.getId())
                    {
                        case R.id.rob_button:
                            //if the right fragment doesn't exist (in the case of tablet
                            if(manager.findFragmentById(R.id.right)==null)
                            {
                                Log.d("right rob", "right frag");
                                right=new DetailFragment();
                                //Bundle bundle = new Bundle();

                                //right.setArguments(bundle);
                                fragmentTransaction.add(R.id.master_layout, right, "right");
                                fragmentTransaction.addToBackStack("Replace");
                                fragmentTransaction.commit();
                                right.getUser(rob);
                            }
                            //is in tablet mode
                            else
                            {
                                Log.d("what","what");
                                right=(DetailFragment) manager.findFragmentById(R.id.right);
                                right.changeUser(rob);
                            }

                            break;

                        case R.id.arjun_button:
                            Log.d("right arjun", "right frag");
                            if(manager.findFragmentById(R.id.right)==null)
                            {
                                Log.d("right rob", "right frag");
                                right=new DetailFragment();
                                //Bundle bundle = new Bundle();

                                //right.setArguments(bundle);
                                fragmentTransaction.add(R.id.master_layout, right, "right");
                                fragmentTransaction.addToBackStack("Replace");
                                fragmentTransaction.commit();
                                right.getUser(arjun);
                            }
                            else
                            {
                                Log.d("what","what");
                                right=(DetailFragment) manager.findFragmentById(R.id.right);
                                right.changeUser(arjun);
                            }



                            break;

                        case R.id.hooman_button:
                            Log.d("hooman","hooman");
                            if(manager.findFragmentById(R.id.right)==null)
                            {
                                Log.d("right rob", "right frag");
                                right=new DetailFragment();
                                //Bundle bundle = new Bundle();

                                //right.setArguments(bundle);
                                fragmentTransaction.add(R.id.master_layout, right, "right");
                                fragmentTransaction.addToBackStack("Replace");
                                fragmentTransaction.commit();
                                right.getUser(hooman);
                            }
                            else
                            {
                                Log.d("what","what");
                                right=(DetailFragment) manager.findFragmentById(R.id.right);
                                right.changeUser(hooman);
                            }
                            break;
                    }

                }
            });

        }




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

   /* @Override
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
    }*/

    public void initializeUsers()
    {
        String [] rob_array= getResources().getStringArray(R.array.rob);
        String [] hooman_array= getResources().getStringArray(R.array.hooman);
        String [] arjun_array= getResources().getStringArray(R.array.arjun);
        rob= new User(rob_array,R.drawable.rob_pic);
        arjun= new User(arjun_array,R.drawable.arjun_pic);
        hooman= new User(hooman_array,R.drawable.hooman_pic);
    }
}
