package com.example.com.mocon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class member3Activity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member3);

        Intent prevIntent = getIntent();
        final Boolean isMale = prevIntent.getBooleanExtra("gender", true);
        final String name = prevIntent.getStringExtra("name");
        final String nickname = prevIntent.getStringExtra("nickname");

        final TextView nameText = (TextView) findViewById(R.id.name);
        final ImageView profileImage = (ImageView) findViewById(R.id.profile);

        nameText.setText(name + "(" + nickname + ")");
        if (!isMale) {
            profileImage.setImageResource(R.drawable.woman);
        }
        findViewById(R.id.nextButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent = new Intent(member3Activity.this, MainActivity.class);
                nextIntent.putExtra("nickname", nickname);
                nextIntent.putExtra("gender", isMale);
                startActivity(nextIntent);
                finish();
            }
        });
    }
}
