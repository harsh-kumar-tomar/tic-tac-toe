package com.example.javaappversion2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer beep;
    ImageView rocket1 , rocket2;

    int flag=0 , count=0 , freeze=0 , won1=0 , won2=0 ;                                                    //nned by function
    Button btn1 , btn2 , btn3 , btn4 , btn5 , btn6 , btn7 , btn8 , btn9 ;   //connecting  buttons
    TextView player1 , player2 , Won1 , Won2  ;                                           //connecting name that is showing
    String sbtn1 , sbtn2 , sbtn3 , sbtn4 , sbtn5 , sbtn6 , sbtn7 , sbtn8 , sbtn9 ;  //getting string from buttons

    Button version ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);           //which layout activity uses

       rocket1= findViewById(R.id.Rocket1);
       rocket2= findViewById(R.id.Rocket2);
        Animation move = AnimationUtils.loadAnimation(this,R.anim.move);
//        rocket1.startAnimation(move);
        rocket2.startAnimation(move);

       intialize();                                        //connecting all buttons to the java

       fetchingdataActivity();                     //fetching data of Activity 3

    }

    private void fetchingdataActivity() {               //fetching data

        Intent temp3toMain ;
        temp3toMain = getIntent();

        player1.setText(temp3toMain.getStringExtra("player1")+": X");
        player2.setText(temp3toMain.getStringExtra("player2")+": O");
    }

    public void emptyActivity(View view)              //when we click on Next
    {
        Intent secondActivity = new Intent( MainActivity.this , MainActivity2.class) ; //establishing connection between main1 to main2

        startActivity(secondActivity);                                                     //changing activity

    }


    public void buttonClick(View view)   //this will happen when a tic tac toe button is clicked
    {

        Button currentButton ;
        currentButton = (Button) view ;          //getting reference to current button that is clicked


        if(currentButton.getText().toString()=="" && freeze==0)      //only able to change value if it was not clicked before
       {
           beep.start();
           count++;

             if (flag == 0) {

                 currentButton.setText("X");

                 currentButton.setTextColor(Color.parseColor("#472183"));
                 flag = 1;
             } else {

                 currentButton.setText("O");
                 currentButton.setTextColor(Color.parseColor("#50677d"));
                 flag = 0;
             }


             if (count > 4)
             {
                 initializeString();
                 pleaseCheck();
             }


       }


    }



public void initializeString()     //fetching string from all buttons for comparison
{
    sbtn1 = btn1.getText().toString();
    sbtn2 = btn2.getText().toString();
    sbtn3 = btn3.getText().toString();
    sbtn4 = btn4.getText().toString();
    sbtn5 = btn5.getText().toString();
    sbtn6 = btn6.getText().toString();
    sbtn7 = btn7.getText().toString();
    sbtn8 = btn8.getText().toString();
    sbtn9 = btn9.getText().toString();


}

public void getWinner(String temp)
{
    String temp2;
    String temp3;

    if(temp=="X") {
        flag = 0;
        temp2 =player1.getText().toString();
        won1++;
        Won1.setText(won1+"");
    }
    else {
        flag = 1;
        temp2 =player2.getText().toString();
        won2++;
        Won2.setText(won2+"");

    }


    Intent splash = new Intent( MainActivity.this , com.example.javaappversion2.splash.class) ; //establishing connection between main1 to splash

    splash.putExtra("winnerName" , temp2);   //sending name to splash

    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            startActivity(splash);
        }
    } , 0);


    freeze=1;

}

public void reset(View view)
{
    btn1.setText("");
    btn2.setText("");
    btn3.setText("");
    btn4.setText("");
    btn5.setText("");
    btn6.setText("");
    btn7.setText("");
    btn8.setText("");
    btn9.setText("");



    count =0 ;
    freeze =0;
}
    public void pleaseCheck()            //comparison of all buttons
    {
        if(sbtn1 == sbtn2 && sbtn2==sbtn3 && sbtn1!="")
        {
           getWinner(sbtn1);

        } else if (sbtn4 == sbtn5&& sbtn5==sbtn6 && sbtn4!="") {

            getWinner(sbtn4);

        } else if (sbtn7 == sbtn8 && sbtn8==sbtn9 && sbtn7!="") {

            getWinner(sbtn7);

        } else if (sbtn1 == sbtn4 && sbtn4==sbtn7 && sbtn1!="") {

            getWinner(sbtn1);

        } else if (sbtn2 == sbtn5 && sbtn5==sbtn8 && sbtn2!="") {

            getWinner(sbtn1);

        } else if (sbtn3 == sbtn6 && sbtn6==sbtn9 && sbtn3!="") {

            getWinner(sbtn3);

        } else if (sbtn1 == sbtn5 && sbtn5==sbtn9 && sbtn1!="") {

            getWinner(sbtn1);

        } else if (sbtn3 == sbtn5 && sbtn5==sbtn7 && sbtn3!="") {

            getWinner(sbtn3);

        }



    }
    private void intialize() { //initializing all buttons

        btn1 =findViewById(R.id.but1);
        btn2 =findViewById(R.id.but2);
        btn3 =findViewById(R.id.but3);
        btn4 =findViewById(R.id.but4);
        btn5 =findViewById(R.id.but5);
        btn6 =findViewById(R.id.but6);
        btn7 =findViewById(R.id.but7);
        btn8 =findViewById(R.id.but8);
        btn9 =findViewById(R.id.but9);

        beep= MediaPlayer.create(this,R.raw.click);




        player1 =findViewById(R.id.player1);
        player2 =findViewById(R.id.player2);

        Won1 =findViewById(R.id.won1);
        Won2 =findViewById(R.id.won2);

        version = findViewById(R.id.next);






    }
}