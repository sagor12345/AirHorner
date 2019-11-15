package com.example.airhorner;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button button;
    MediaPlayer player;
    AnimationDrawable animationDrawable;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        button = findViewById( R.id.btn );

        final ImageView img = findViewById(R.id.image);
        img.setBackgroundResource(R.drawable.anim);
        animationDrawable = (AnimationDrawable) img.getBackground();

        final int[] sound= {R.raw.horn,R.raw.sound1,R.raw.sound2};

        button.setOnTouchListener( new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                if (event.getAction()== MotionEvent.ACTION_DOWN) {
                    animationDrawable.start();

                    Random random = new Random();
                    int low=0;
                    int high=3;
                    int rnd = random.nextInt(high-low)+low;

                    player= MediaPlayer.create( MainActivity.this,sound[rnd] );
                    player.start();

                    v.getBackground().setColorFilter(0xe0f47521, PorterDuff.Mode.SRC_ATOP);

                    v.invalidate();
                }
                else if(event.getAction()==MotionEvent.ACTION_UP){
                    animationDrawable.stop();
                    animationDrawable.selectDrawable(0);
                    player.stop();
                    player.release();

                    v.getBackground().clearColorFilter();
                    v.invalidate();
                }
                return true;

            }

        } );


    }

}
