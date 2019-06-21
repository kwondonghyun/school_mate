package com.example.com.mocon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class member2Activity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member2);

        final EditText nameText = (EditText) findViewById(R.id.nickname);
        final EditText idText = (EditText) findViewById(R.id.id);
        final EditText passwordText = (EditText) findViewById(R.id.password);
        final EditText passwordCheckText = (EditText) findViewById(R.id.passwordCheck);

        Intent prevIntent = getIntent();
        final Boolean isMale = prevIntent.getBooleanExtra("gender", true);
        final String realName = prevIntent.getStringExtra("name");

        findViewById(R.id.nextButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nameLength = nameText.getText().length();
                int idLength = idText.getText().length();
                int passwordLength = passwordText.getText().length();
                int passwordCheckLength = passwordCheckText.getText().length();

                String password = passwordText.getText().toString();
                String passwordCheck = passwordCheckText.getText().toString();

                if (password.compareTo(passwordCheck) != 0) {
                    Toast.makeText(member2Activity.this, "비밀번호가 다릅니다.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (nameLength == 0 || idLength == 0 || passwordLength == 0 || passwordCheckLength == 0)
                    return;

                Intent nextIntent = new Intent(member2Activity.this, member3Activity.class);
                nextIntent.putExtra("gender", isMale);
                nextIntent.putExtra("nickname", nameText.getText().toString());
                nextIntent.putExtra("name", realName);
                startActivity(nextIntent);
                finish();
            }
        });
    }
}
