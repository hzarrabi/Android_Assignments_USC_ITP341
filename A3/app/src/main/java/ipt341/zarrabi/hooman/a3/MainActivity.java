package ipt341.zarrabi.hooman.a3;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

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

    public static final String AMERICAN_CLICKS ="AMERICAN_CLICKS";
    public static final String CHINESE_CLICKS ="CHINISE_CLICKS";
    public static final String INDIAN_CLICKS ="INDIAN_CLICKS";
    public static final String ITALIAN_CLICKS="ITALIAN_CLICKS";
    public static final String MIDDLE_CLICKS ="MIDDLE_CLICKS";
    public static final String PORTUGESE_CLICKS="PORTUGESE_CLICKS";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //changed the status bar color
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.custom));



        if (savedInstanceState != null)
        {
            american = savedInstanceState.getInt(AMERICAN_CLICKS);
            chinese = savedInstanceState.getInt(CHINESE_CLICKS);
            italian = savedInstanceState.getInt(ITALIAN_CLICKS);
            indian = savedInstanceState.getInt(INDIAN_CLICKS);
            middleEast = savedInstanceState.getInt(MIDDLE_CLICKS);
            portugese = savedInstanceState.getInt(PORTUGESE_CLICKS);
        }
        else //if this is the first instance we want to make sure the votes are both 0
        {
            american=0;
            chinese=0;
            italian=0;
            indian=0;
            middleEast=0;
            portugese=0;
        }


        initialize();
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
                        Toast.makeText(getApplicationContext(), getResources().getString(R.string.americanToast) + american + getResources().getString(R.string.times),
                                Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.IndianButton:
                        indian++;
                        Toast.makeText(getApplicationContext(), getResources().getString(R.string.indianToast) + indian + getResources().getString(R.string.times),
                                Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.ChineseButton:
                        chinese++;
                        Toast.makeText(getApplicationContext(), getResources().getString(R.string.chineseToast) + chinese + getResources().getString(R.string.times),
                                Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.ItalianButton:
                        italian++;
                        Toast.makeText(getApplicationContext(), getResources().getString(R.string.italianToast) + italian + getResources().getString(R.string.times),
                                Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.MiddleEastButton:
                        middleEast++;
                        Toast.makeText(getApplicationContext(), getResources().getString(R.string.middleToast) + middleEast + getResources().getString(R.string.times),
                                Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.PortugeseButton:
                        portugese++;
                        Toast.makeText(getApplicationContext(), getResources().getString(R.string.portugeseToast) + portugese + getResources().getString(R.string.times),
                                Toast.LENGTH_SHORT).show();
                        break;

                }

            }
        };

        americanButton.setOnClickListener(buttonListener);
        chineseButton.setOnClickListener(buttonListener);
        italianButton.setOnClickListener(buttonListener);
        indianButton.setOnClickListener(buttonListener);
        middleEastButton.setOnClickListener(buttonListener);
        portugeseButton.setOnClickListener(buttonListener);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(AMERICAN_CLICKS, american);
        outState.putInt(CHINESE_CLICKS, chinese);
        outState.putInt(ITALIAN_CLICKS, italian);
        outState.putInt(INDIAN_CLICKS, indian);
        outState.putInt(MIDDLE_CLICKS, middleEast);
        outState.putInt(PORTUGESE_CLICKS, portugese);
    }
}
