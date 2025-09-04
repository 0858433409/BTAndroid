package com.example.bt1_baitoanptb2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class Nhap extends AppCompatActivity {
    EditText txtA, txtB, txtC;
    Button btnNhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);

        txtA = findViewById(R.id.txtA);
        txtB = findViewById(R.id.txtB);
        txtC = findViewById(R.id.txtC);
        btnNhap = findViewById(R.id.btnNhap);

        btnNhap.setOnClickListener(v -> {
            try {
                double a = Double.parseDouble(txtA.getText().toString());
                double b = Double.parseDouble(txtB.getText().toString());
                double c = Double.parseDouble(txtC.getText().toString());

                // Tạo intent để chuyển sang MainActivity
                Intent intent = new Intent(Nhap.this, MainActivity.class);
                intent.putExtra("a", a);
                intent.putExtra("b", b);
                intent.putExtra("c", c);
                startActivity(intent);
                finish();

            } catch (NumberFormatException e) {
                Toast.makeText(Nhap.this, "Vui lòng nhập đủ a, b, c", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
