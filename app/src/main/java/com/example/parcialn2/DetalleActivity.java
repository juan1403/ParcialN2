package com.example.parcialn2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class DetalleActivity extends AppCompatActivity {

    TextView textViewTitle, textViewDescription;
    ImageView imageView;
    Button buttonLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_activity);

        textViewTitle = findViewById(R.id.textViewTitle);
        textViewDescription = findViewById(R.id.textViewDescription);
        imageView = findViewById(R.id.imageView);
        buttonLogout = findViewById(R.id.buttonLogout);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String description = intent.getStringExtra("description");
        String imageUrl = intent.getStringExtra("imageUrl");

        textViewTitle.setText(title);
        textViewDescription.setText(description);
        Picasso.get().load(imageUrl).into(imageView);

        buttonLogout.setOnClickListener(v -> {
            SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();

            Intent loginIntent = new Intent(DetalleActivity.this, LoginActivity.class);
            startActivity(loginIntent);
            finish();
        });
    }
}
