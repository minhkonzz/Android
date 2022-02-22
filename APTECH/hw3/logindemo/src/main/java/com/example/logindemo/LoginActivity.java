package com.example.logindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private TextView usernameLb, passwordLb;
    private EditText usernameInput, passwordInput;
    private Button loginBtn;


    private final static String USERNAME_EXTRA = "username";
    private final static String PASSWORD_EXTRA = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupViews();
    }

    private void setupViews() {

        usernameLb = findViewById(R.id.usernameLb);
        passwordLb = findViewById(R.id.passwordLb);
        usernameInput = findViewById(R.id.usernameInput);

        passwordInput = findViewById(R.id.passwordInput);
        passwordInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        passwordInput.setSelection(passwordInput.getText().length());

        loginBtn = findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra(USERNAME_EXTRA, String.format("%s", usernameInput.getText().toString().trim()));
            intent.putExtra(PASSWORD_EXTRA, String.format("%s", passwordInput.getText().toString().trim()));
            startActivity(intent);
        });
    }
}