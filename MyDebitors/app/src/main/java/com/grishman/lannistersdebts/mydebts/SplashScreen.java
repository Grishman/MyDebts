package com.grishman.lannistersdebts.mydebts;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;


public class SplashScreen extends Activity {

    MediaPlayer lannisterVoice;
    private static final int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
        lannisterVoice =MediaPlayer.create(getApplicationContext(), R.raw.quote);
        lannisterVoice.setLooping(false);
        lannisterVoice.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        lannisterVoice.release();
        lannisterVoice = null;
    }
}
