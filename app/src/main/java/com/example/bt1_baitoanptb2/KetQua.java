package com.example.bt1_baitoanptb2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


public class KetQua extends Activity {
    TextView txtKq;
    Button btnDong;
    double a, b, c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ketqua);
        txtKq = findViewById(R.id.txtKq);
        btnDong = findViewById(R.id.btnDong);

        btnDong.setOnClickListener(v -> finish());
        Intent intent = getIntent();
        a = intent.getDoubleExtra("a", 0);
        b = intent.getDoubleExtra("b", 0);
        c = intent.getDoubleExtra("c", 0);

        txtKq.setText(giaiPhuongTrinh(a, b, c));
    }

    public static String giaiPhuongTrinh(double a, double b, double c) {
        if (a == 0) {
            if (b == 0) {
                if (c == 0) return "Phương trình vô số nghiệm";
                else return "Phương trình vô nghiệm";
            } else {
                return "Phương trình có nghiệm: x = " + (-c / b);
            }
        } else {
            double delta = b * b - 4 * a * c;
            if (delta < 0) {
                return "Phương trình vô nghiệm";
            } else if (delta == 0) {
                return "Phương trình có nghiệm kép: x = " + (-b / (2 * a));
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                return "Phương trình có 2 nghiệm:\n x1 = " + x1 + "\n x2 = " + x2;
            }
        }
    }
}
