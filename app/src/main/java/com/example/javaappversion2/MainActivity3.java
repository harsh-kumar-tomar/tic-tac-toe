package com.example.javaappversion2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {

    EditText player_1 , player_2 ;

    MediaPlayer goodJob ;
    Intent jumptoMain ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        goodJob= MediaPlayer.create(this,R.raw.waterdrop);

        xmltoJava();

    }

     public void xmltoJava()
    {
        player_1 = findViewById(R.id.player1);
        player_2 = findViewById(R.id.player2);
    }

    public void buttonContinue(View view)               //after clicking button "continue"
    {
        String playerString1 , playerString2 ;

        playerString1 = player_1.getText().toString();       //getting names
        playerString2 = player_2.getText().toString();       //getting names


        if(!playerString1.equals("") && !playerString2.equals("")) {
            goodJob.start();
            jumptoMain = new Intent(MainActivity3.this, MainActivity.class);  // establishing connection to MainActivity

            jumptoMain.putExtra("player1", playerString1);   //sending name to activity Main
            jumptoMain.putExtra("player2", playerString2);     //sending name to activity Main


            startActivity(jumptoMain);
            finish();
            //jumping on main
        }

    }
}