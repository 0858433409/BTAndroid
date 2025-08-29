package com.example.bt1_baitoanptb2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText txtA, txtB, txtC;
    Button btnGiai, btnDong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtA = findViewById(R.id.txtA);
        txtB = findViewById(R.id.txtB);
        txtC = findViewById(R.id.txtC);
        btnGiai = findViewById(R.id.btnGiai);
        btnDong = findViewById(R.id.btnDong);

        btnDong.setOnClickListener(v -> finish());
        btnGiai.setOnClickListener(v -> {
            try {
                double a = Double.parseDouble(txtA.getText().toString());
                double b = Double.parseDouble(txtB.getText().toString());
                double c = Double.parseDouble(txtC.getText().toString());
                String kq;

                if (a == 0) {
                    if (b == 0) {
                        kq = (c == 0) ? "Phương trình vô số nghiệm" : "Phương trình vô nghiệm";
                    } else {
                        kq = "Phương trình có nghiệm: x = " + (-c / b);
                    }
                } else {
                    double delta = b * b - 4 * a * c;
                    if (delta < 0) {
                        kq = "Phương trình vô nghiệm";
                    } else if (delta == 0) {
                        kq = "Phương trình có nghiệm kép: x = " + (-b / (2 * a));
                    } else {
                        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                        double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                        kq = "Phương trình có 2 nghiệm:\n x1 = " + x1 + "\n x2 = " + x2;
                    }
                }

                Intent intent = new Intent(MainActivity.this, KetQua.class);
                intent.putExtra("ketqua", kq);
                startActivity(intent);

            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Vui lòng nhập đủ a, b, c", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
