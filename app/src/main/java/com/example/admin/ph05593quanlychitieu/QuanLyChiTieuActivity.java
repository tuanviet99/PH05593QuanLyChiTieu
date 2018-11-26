package com.example.admin.ph05593quanlychitieu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.admin.ph05593quanlychitieu.adapter.ChiTieuAdapter;
import com.example.admin.ph05593quanlychitieu.database.ChiTieuDAO;
import com.example.admin.ph05593quanlychitieu.model.ChiTieu;

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

        dsChiTieu = chiTieuDAO.getALLChiTieu();

        chiTieuAdapter = new ChiTieuAdapter(this, dsChiTieu);
        lvChitieu.setAdapter(chiTieuAdapter);
        lvChitieu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                ChiTieu chiTieu = (ChiTieu) parent.getItemAtPosition(position);
                Intent intent = new Intent(getApplicationContext(), SuaActivity.class);
                Bundle b = new Bundle();
                b.putString("TENCHITIEU", chiTieu.getTenChiphi());
                b.putString("SOLUONG", String.valueOf(chiTieu.getSoLuong()));
                b.putString("GIATIEN", String.valueOf(chiTieu.getGiaTien()));
                b.putString("NGAYCHI", String.valueOf(chiTieu.getNgayChi()));

                intent.putExtras(b);
                startActivity(intent);
            }
        });
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
}
