package com.example.admin.ph05593quanlychitieu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.admin.ph05593quanlychitieu.database.ChiTieuDAO;

public class ThongKeActivity extends AppCompatActivity {

    private TextView tvThongKe;
    private ChiTieuDAO chiTieuDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke);
        tvThongKe = (TextView) findViewById(R.id.tvThongKe);
        chiTieuDAO=new ChiTieuDAO(this);
        tvThongKe.setText("Tổng chi tiêu:   " + chiTieuDAO.getChiTieuTheoNgay() + " đồng ");
    }
}
