package com.example.airhorner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class Spalsh extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        this.requestWindowFeature( Window.FEATURE_NO_TITLE);


        setContentView( R.layout.activity_spalsh );


        new Handler().postDelayed( new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent( Spalsh.this,MainActivity.class );
                startActivity( i );
                finish();
            }
        }, 3000);

    }
}
