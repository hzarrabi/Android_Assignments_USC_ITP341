package ipt341.zarrabi.hooman.a3;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {

    //integers for each button count
    private int american;
    private int chinese;
    private int indian;
    private int italian;
    private int middleEast;
    private int portugese;

    //buttons
    private ImageButton americanButton;
    private ImageButton chineseButton;
    private ImageButton indianButton;
    private ImageButton italianButton;
    private ImageButton middleEastButton;
    private ImageButton portugeseButton;

    //listner
    View.OnClickListener buttonListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    //initializes the buttons, listeners, and ints
    private void initialize()
    {
        american=0;
        indian=0;
        chinese=0;
        italian=0;
        middleEast=0;
        portugese=0;

        americanButton = (ImageButton)findViewById(R.id.AmericanButton);
        indianButton = (ImageButton)findViewById(R.id.IndianButton);
        chineseButton= (ImageButton) findViewById(R.id.ChineseButton);
        italianButton= (ImageButton) findViewById(R.id.ItalianButton);
        middleEastButton= (ImageButton) findViewById(R.id.MiddleEastButton);
        portugeseButton= (ImageButton) findViewById(R.id.PortugeseButton);

        buttonListener= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId())
                {
                    case R.id.AmericanButton:
                        american++;
                        //TODO make toast
                        break;

                    case R.id.IndianButton:
                        indian++;

                        break;

                    case R.id.ChineseButton:
                        chinese++;

                        break;

                    case R.id.ItalianButton:
                        italian++;

                        break;

                    case R.id.MiddleEastButton:
                        middleEast++;

                        break;

                    case R.id.PortugeseButton:
                        portugese++;

                        break;

                }

            }
        };
    }
}
