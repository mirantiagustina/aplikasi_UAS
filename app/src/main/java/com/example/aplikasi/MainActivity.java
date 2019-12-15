package com.example.aplikasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMove = findViewById(R.id.atlet_intent);
        btnMove.setOnClickListener(this);

        btnMove = findViewById(R.id.sehat_intent);
        btnMove.setOnClickListener(this);

        btnMove = findViewById(R.id.berita_intent);
        btnMove.setOnClickListener(this);

        btnMove = findViewById(R.id.sport_intent);
        btnMove.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.atlet_intent:
                startActivity(new Intent(this, atlet.class));
                break;
            case R.id.sehat_intent:
                startActivity(new Intent(this, sehat.class));
                break;
            case R.id.berita_intent:
                startActivity(new Intent(this, Menu_Daftar_Makanan.class));
                break;
            case R.id.sport_intent:
                startActivity(new Intent(this, menu_daftar_olahraga.class));
                break;
        }
    }
    public void feed(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:miranti0899@gmail.com"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback for Just App");
        if (intent.resolveActivity(getPackageManager()) !=null) {
            startActivity(intent);
        }
    }
}

