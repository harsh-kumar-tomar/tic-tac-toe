package com.example.javaappversion2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class splash extends AppCompatActivity {

    String winnerName ;
    TextView winnerShow;
    MediaPlayer win;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Intent maintoSplash;
        maintoSplash = getIntent();
        winnerShow =findViewById(R.id.winnerShow);
        win= MediaPlayer.create(this,R.raw.winner);
        win.start();

        winnerName =maintoSplash.getStringExtra("winnerName");

        winnerShow.setText(winnerName);




        Intent back = new Intent( splash.this , MainActivity.class) ; //establishing connection between main1 to splash

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                finish();
            }
        } , 3000);

    }
}