package com.example.com.mocon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SearchActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.school_search);


        findViewById(R.id.schoolName).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnResultIntent = new Intent(SearchActivity.this, member1Activity.class);
                TextView schoolText = findViewById(R.id.schoolName);
                String name = schoolText.getText().toString();
                returnResultIntent.putExtra("schoolName", name);
                startActivity(returnResultIntent);
                finish();
            }
        });
    }
}
