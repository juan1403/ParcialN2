package com.example.parcialn2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.usuario);
        passwordEditText = findViewById(R.id.contraseña);
        Button loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (!username.isEmpty() && !password.isEmpty()) {
                    // Aquí podrías verificar el usuario y la contraseña

                    // Si el inicio de sesión es exitoso
                    SharedPreferences sharedPreferences = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", username); // Guarda el nombre de usuario
                    editor.apply();

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish(); // Termina la actividad de login
                } else {
                    // Mostrar un mensaje de error
                    Toast.makeText(LoginActivity.this, "Por favor, llena ambos campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

