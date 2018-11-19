package com.example.admin.ph05593quanlychitieu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText edName;
    private EditText edPass;
    private Button btnLogin;
    String strUser, strPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Đăng nhập");

        edName = (EditText) findViewById(R.id.edName);
        edPass = (EditText) findViewById(R.id.edPass);
        btnLogin = (Button) findViewById(R.id.btnLogin);
    }

    public void CheckLogin(View view) {
        strUser = edName.getText().toString();
        strPass = edPass.getText().toString();
        if (strUser.isEmpty() || strPass.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Tên đăng nhập và mật khẩu không được bỏ trống", Toast.LENGTH_SHORT).show();
        } else {
                Toast.makeText(getApplicationContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                finish();
            }

            if (strUser.equalsIgnoreCase("admin") && strPass.equalsIgnoreCase("admin")) {
                startActivity(new Intent(LoginActivity.this, MenuActivity.class));
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "Tên đăng nhập và mật khẩu không đúng", Toast.LENGTH_SHORT).show();
            }
        }
    }
