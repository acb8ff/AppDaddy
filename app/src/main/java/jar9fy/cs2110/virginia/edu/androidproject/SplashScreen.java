package jar9fy.cs2110.virginia.edu.androidproject;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;


public class SplashScreen extends Activity {

    private static String TAG = SplashScreen.class.getName(); //used to report an error in run()
    private static long SLEEP_TIME = 5; //set duration of the splashscreen


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //remove notification bar if it exists

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);

        //start time and launch main activity
        IntentLauncher launcher = new IntentLauncher();
        launcher.start();

    }

    private class IntentLauncher extends Thread{

        @Override
        public void run() {
            try {
                Thread.sleep(SLEEP_TIME * 500);
            }catch(Exception e) {
                Log.e(TAG, "splashScreen is up ");
            }

            //start main activity
            Intent intent = new Intent( SplashScreen.this, MainActivity.class);
            SplashScreen.this.startActivity(intent);
            SplashScreen.this.finish();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash_screen, menu);
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
}
