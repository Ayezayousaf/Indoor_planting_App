package com.example.plantingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import  android.view.animation.Animation;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Timer timer ;
    ImageView logo;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo=findViewById(R.id.mainLogo);

      //  Animation move= AnimationUtils.loadAnimation(this,R.anim.animation);
        animation=AnimationUtils.loadAnimation(this,R.anim.left_to_right_anim);

        logo.setAnimation(animation);

        timer =new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,Login.class);
                startActivity(intent);
                finish();
            }
        },5000);


    }
}