package com.example.admin.ph05593quanlychitieu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.ph05593quanlychitieu.database.ChiTieuDAO;
import com.example.admin.ph05593quanlychitieu.model.ChiTieu;

import java.text.SimpleDateFormat;

public class ThemActivity extends AppCompatActivity {
    private EditText edName;
    private EditText edSoluong;
    private EditText edGiatien;
    private EditText edNgaychi;
    private ChiTieuDAO chiTieuDAO;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them);
        edName = (EditText) findViewById(R.id.edName);
        edSoluong = (EditText) findViewById(R.id.edSoluong);
        edGiatien = (EditText) findViewById(R.id.edGiatien);
        edNgaychi = (EditText) findViewById(R.id.edNgaychi);

    }



    public void addChitieu(View view) {
        chiTieuDAO = new ChiTieuDAO(ThemActivity.this);
        try {
            if (validateForm() > 0) {
                ChiTieu chiTieu = new ChiTieu(edName.getText().toString(), Integer.parseInt(edSoluong.getText().toString()), Integer.parseInt(edGiatien.getText().toString()),
                        (edNgaychi.getText().toString()));

                if (chiTieuDAO.insertChiTieu(chiTieu) > 0) {
                    Toast.makeText(this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception e) {
            Log.e("//====", e.toString());
        }
    }

    public void Show(View view) {
        finish();
    }

    public int validateForm() {

        int check = 1;
        if (edName.getText().length() == 0 || edSoluong.getText().length() == 0 || edGiatien.getText().length() == 0 || edGiatien.getText().length() == 0 || edNgaychi.getText().length() == 0 || edNgaychi.getText().length()<10) {
            Toast.makeText(getApplicationContext(), "Bạn phải nhập đầy đủ thông ", Toast.LENGTH_SHORT).show();
            check = -1;
        } else {

        }
        return check;
    }

    public void huy(View view) {
        finish();
    }
}
