package com.example.admin.ph05593quanlychitieu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.InputStream;

public class MenuActivity extends AppCompatActivity {

    private Button btnQuanlychitieu;
    private Button btnThongke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setTitle("Menu");
        btnQuanlychitieu = (Button) findViewById(R.id.btnQuanlychitieu);
        btnThongke = (Button) findViewById(R.id.btnThongke);
    }

    public void QuanLyChiTieu(View view) {
        Intent intent=new Intent(getApplicationContext(),QuanLyChiTieuActivity.class);
        startActivity(intent);
    }

    public void ThongKe(View view) {
        Intent intent1=new Intent(getApplicationContext(),ThongKeActivity.class);
        startActivity(intent1);
    }
}
