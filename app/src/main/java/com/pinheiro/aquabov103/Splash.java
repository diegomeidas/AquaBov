package com.pinheiro.aquabov103;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                callMainActivity();
                finish();

            }
        }, 5000);
    }

    public void callMainActivity(){
        Intent intent = new Intent(Splash.this, MainActivity.class);
        startActivity(intent);
    }
}
