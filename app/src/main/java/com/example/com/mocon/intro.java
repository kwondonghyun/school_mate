package com.example.com.mocon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent;
                intent = new Intent(intro.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1000);
    }
}


