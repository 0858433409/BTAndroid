package com.example.bt1_baitoanptb2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText editPhuongTrinh;
    Button btnGiai, btnNhap;
    double a, b, c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        editPhuongTrinh= findViewById(R.id.editTextText);
        btnGiai= findViewById(R.id.btnGiai);
        btnNhap= findViewById(R.id.btnNhap);

//        btnNhap.setOnClickListener(v -> {
//            Intent intent = new Intent(MainActivity.this, Nhap.class);
//            startActivity(intent);
//        });

        Intent intent = getIntent();
        a = intent.getDoubleExtra("a", 0);
        b = intent.getDoubleExtra("b", 0);
        c = intent.getDoubleExtra("c", 0);

        if (a == 0 && b == 0 && c == 0) {
            editPhuongTrinh.setText("Vui lòng nhấn 'NHẬP' để nhập a, b, c.");
        } else {
            editPhuongTrinh.setText(formatPhuongTrinh(a, b, c));
        }

        btnGiai.setOnClickListener(v -> {
            Intent kqIntent = new Intent(MainActivity.this, KetQua.class);
            kqIntent.putExtra("a", a);
            kqIntent.putExtra("b", b);
            kqIntent.putExtra("c", c);
            startActivity(kqIntent);
        });

        btnNhap.setOnClickListener(v -> {
            Intent nhapIntent = new Intent(MainActivity.this, Nhap.class);
            startActivity(nhapIntent);
            finish();
        });
    }
    private String formatPhuongTrinh(double a, double b, double c) {
        StringBuilder sb = new StringBuilder();
        if (a != 0) {
            sb.append(a).append("x²");
        }
        if (b > 0) {
            sb.append(" + ").append(b).append("x");
        } else if (b < 0) {
            sb.append(" - ").append(-b).append("x");
        }
        if (c > 0) {
            sb.append(" + ").append(c);
        } else if (c < 0) {
            sb.append(" - ").append(-c);
        }
        sb.append(" = 0");
        return sb.toString();
    }
}