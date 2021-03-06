package jar9fy.cs2110.virginia.edu.androidproject;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Level2 extends ActionBarActivity {

    int scorecount = 0;
    RelativeLayout layout;
    ImageView cavman;
    ImageView basketball;
    boolean didShoot = false;
    ViewDrawer2 v = new ViewDrawer2(this);


//    //create sound for you ball

    //MediaPlayer collide = MediaPlayer.create(this, R.raw.collide);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_level2);

        //give movement to cavman and basketball
        cavman = (ImageView) findViewById(R.id.cavman);
        layout = (RelativeLayout) findViewById(R.id.layout2);
        basketball = (ImageView) findViewById(R.id.basketball);


        //layout gets onTouch listener attached to it
        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                cavman.setX(event.getX() );
                basketball.setX(event.getX()+125);

                return true;
            }

        });

        final Intent i3 = new Intent( this, Level3.class);

        if( scorecount == 200 ){
            startActivity(i3);

        }

    }
}
