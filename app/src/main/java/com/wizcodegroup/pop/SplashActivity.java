package com.wizcodegroup.pop;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;

/**
 * Created by Lheye on 4/20/15.
 */
public class SplashActivity extends Activity {

    private static int SPLASH_SCREEN_DELAY = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Use an Handler as Timer
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);

                finish();
            }
        }, SPLASH_SCREEN_DELAY);


    }

}
