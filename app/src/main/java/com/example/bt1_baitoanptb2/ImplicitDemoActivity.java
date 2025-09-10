package com.example.bt1_baitoanptb2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ImplicitDemoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_demo);

        // Mở Google (Implicit Intent với ACTION_VIEW + Data)
        Button btnWeb = findViewById(R.id.btnWeb);
        btnWeb.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Toast.makeText(this, "Không có app mở được", Toast.LENGTH_SHORT).show();
            }
        });

        // Gọi điện (Implicit Intent với ACTION_DIAL + Data)
        Button btnCall = findViewById(R.id.btnCall);
        btnCall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0123456789"));
            startActivity(intent);
        });

        // Chia sẻ văn bản (Implicit Intent với ACTION_SEND + Extras)
        Button btnShare = findViewById(R.id.btnShare);
        btnShare.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, "Xin chào, đây là ví dụ share từ app!");
            startActivity(Intent.createChooser(intent, "Chia sẻ qua"));
        });

        // Về Menu (Explicit Intent + Flags)
        Button btnBackMenu = findViewById(R.id.btnBackMenu);
        btnBackMenu.setOnClickListener(v -> {
            Intent intent = new Intent(ImplicitDemoActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });
    }

    // Lifecycle: nhận Intent mới khi Activity ở chế độ singleTop
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        Toast.makeText(this, "onNewIntent được gọi!", Toast.LENGTH_SHORT).show();
    }
}