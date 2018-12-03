package com.example.admin.ph05593quanlychitieu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.admin.ph05593quanlychitieu.common.Common;
import com.example.admin.ph05593quanlychitieu.database.ChiTieuDAO;
import com.example.admin.ph05593quanlychitieu.model.ChiTieu;

import java.text.SimpleDateFormat;

public class SuaActivity extends AppCompatActivity {
    private ChiTieuDAO chiTieuDAO;
    private EditText edName;
    private EditText edSoluong;
    private EditText edGiatien;
    private EditText edNgaychi;
    private Button btnThem;
    private Button btnHuy;
    private Button btnShow;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua);

        edName = (EditText) findViewById(R.id.edName);
        edSoluong = (EditText) findViewById(R.id.edSoluong);
        edGiatien = (EditText) findViewById(R.id.edGiatien);
        edNgaychi = (EditText) findViewById(R.id.edNgaychi);
        btnThem = (Button) findViewById(R.id.btnThem);
        btnHuy = (Button) findViewById(R.id.btnHuy);
        btnShow = (Button) findViewById(R.id.btnShow);

        Intent in = getIntent();
        Bundle b = in.getExtras();
        if (b != null) {
            edName.setText(b.getString("TENCHITIEU"));
            edSoluong.setText(b.getString("SOLUONG"));
            edGiatien.setText(b.getString("GIATIEN"));
            edNgaychi.setText(Common.convertDate(b.getString("NGAYCHI")));
        }
    }

    public void Show(View view) {
        finish();
    }

    public void editChitieu(View view) {
        chiTieuDAO = new ChiTieuDAO(this);
        try {
            ChiTieu chiTieu = new ChiTieu(edName.getText().toString(), Integer.parseInt(edSoluong.getText().toString()),
                    Integer.parseInt(edGiatien.getText().toString()),
                   (edNgaychi.getText().toString().trim()));
            if (validateForm() > 0) {
                if (chiTieuDAO.updateChiTieu(chiTieu) > 0) {
                    Toast.makeText(this, "Sửa thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Sửa thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception e) {
            Log.e("//====", e.toString());
        }

    }
    public int validateForm() {

        int check = 1;
        if (edName.getText().length() == 0 || edSoluong.getText().length() == 0 || edGiatien.getText().length() == 0 || edGiatien.getText().length() == 0 || edNgaychi.getText().length() ==0 || edNgaychi.getText().length()<10) {
            Toast.makeText(getApplicationContext(), "Bạn phải nhập đầy đủ thông ", Toast.LENGTH_SHORT).show();
            check = -1;
        } else {
        }
        return check;
    }

    public void Huy(View view) {
        finish();
    }
}
