package com.example.admin.ph05593quanlychitieu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.admin.ph05593quanlychitieu.Adapter.ChiTieuAdapter;
import com.example.admin.ph05593quanlychitieu.Database.ChiTieuDAO;
import com.example.admin.ph05593quanlychitieu.Model.ChiTieu;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class QuanLyChiTieuActivity extends AppCompatActivity {

    ChiTieuDAO chiTieuDAO;
    ListView lvChitieu;
    public static List<ChiTieu> dsChiTieu = new ArrayList<>();
    ChiTieuAdapter chiTieuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_chi_tieu);
        setTitle("Quản lý chi tiêu");

        lvChitieu = findViewById(R.id.lvChitieu);
        chiTieuDAO = new ChiTieuDAO(QuanLyChiTieuActivity.this);
        try {
            dsChiTieu = chiTieuDAO.getALLChiTieu();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        chiTieuAdapter = new ChiTieuAdapter(this, dsChiTieu);
        lvChitieu.setAdapter(chiTieuAdapter);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                Intent intent = new Intent(getApplicationContext(), ThemActivity.class);
                startActivity(intent);
                return (true);
        }
        return super.onOptionsItemSelected(item);
    }

    public void Edit(View view) {
        Intent intent=new Intent(getApplicationContext(),SuaActivity.class);
        startActivity(intent);
    }
}
