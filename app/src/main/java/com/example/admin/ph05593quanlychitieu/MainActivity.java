package com.example.admin.ph05593quanlychitieu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Hello");
        Thread bamgio = new Thread() {
            public void run() {
                try {
                    sleep(1500);
                } catch (Exception e) {

                } finally {
                    Intent activitymoi = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(activitymoi);
                }
            }
        };
        bamgio.start();
    }

    protected void onPause() {
        super.onPause();
        finish();
    }
}
