package com.example.com.mocon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        final TextView idText = findViewById(R.id.idText);
        final TextView passwordText = findViewById(R.id.passwordText);

        String id = idText.getText().toString();
        String password = passwordText.getText().toString();

        findViewById(R.id.loginButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (idText.length() == 0 || passwordText.length() == 0) {
                    Toast.makeText(LoginActivity.this, "아이디와 비밀번호가 일치하는 지 확인해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(loginIntent);
                finish();
            }
        });

        findViewById(R.id.registerText).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent = new Intent(LoginActivity.this, member1Activity.class);
                startActivity(nextIntent);
            }
        });
    }
}
