package com.example.admin.ph05593quanlychitieu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.admin.ph05593quanlychitieu.Database.ChiTieuDAO;

public class ThongKeActivity extends AppCompatActivity {

    private TextView tvThongKeNgay;
    private TextView tvThongKeThang;
    private ChiTieuDAO chiTieuDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke);
        tvThongKeNgay = (TextView) findViewById(R.id.tvThongKeNgay);
        tvThongKeThang = (TextView) findViewById(R.id.tvThongKeThang);
        chiTieuDAO=new ChiTieuDAO(this);
        tvThongKeNgay.setText("Hôm nay:   " + chiTieuDAO.getChiTieuTheoNgay());
    }
}
