package com.example.bt1_baitoanptb2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


public class KetQua extends Activity {
    TextView txtKq;
    Button btnDong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ketqua);
        txtKq = findViewById(R.id.txtKq);
        btnDong = findViewById(R.id.btnDong);
        Intent i = getIntent();
        String kq = i.getStringExtra("ketqua");
        txtKq.setText(kq);
        btnDong.setOnClickListener(v -> finish());
    }
}
