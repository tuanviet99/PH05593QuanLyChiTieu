package com.example.admin.ph05593quanlychitieu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.ph05593quanlychitieu.Database.ChiTieuDAO;
import com.example.admin.ph05593quanlychitieu.Model.ChiTieu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class SuaActivity extends AppCompatActivity {

    private EditText edName;
    private EditText edSoluong;
    private EditText edGiatien;
    private EditText edNgaychi;
    private Button btnSua;
    private Button btnHuy;
    private Button btnShow;
    private ChiTieuDAO chiTieuDAO;
    String Name, Soluong, Giatien, Ngaychi;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    public static List<ChiTieu> dsChiTieu = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua);
        edName = (EditText) findViewById(R.id.edName);
        edSoluong = (EditText) findViewById(R.id.edSoluong);
        edGiatien = (EditText) findViewById(R.id.edGiatien);
        edNgaychi = (EditText) findViewById(R.id.edNgaychi);
        btnSua = (Button) findViewById(R.id.btnSua);
        btnHuy = (Button) findViewById(R.id.btnHuy);
        btnShow = (Button) findViewById(R.id.btnShow);
        chiTieuDAO = new ChiTieuDAO(this);


    }

    public void Show(View view) {
        finish();
    }
}


