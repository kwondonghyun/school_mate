package com.example.com.mocon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class member1Activity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member);

        Intent thisIntent = getIntent();
        final EditText nameText = (EditText) findViewById(R.id.name);
        final EditText schoolText = (EditText) findViewById(R.id.schoolName);
        final Spinner gradeSpinner = (Spinner) findViewById(R.id.grade);
        final RadioButton maleButton = (RadioButton) findViewById(R.id.male);
        final RadioButton femaleButton = (RadioButton) findViewById(R.id.female);

        maleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                femaleButton.setChecked(false);
            }
        });

        femaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maleButton.setChecked(false);
            }
        });

        if (thisIntent.getExtras() != null) {
            schoolText.setText(thisIntent.getExtras().getString("schoolName"));
        }

        List<String> gradeList = new ArrayList<String>(Arrays.asList("1학년", "2학년", "3학년"));
        ArrayAdapter<String> gradeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, gradeList);
        gradeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gradeSpinner.setAdapter(gradeAdapter);

        findViewById(R.id.nextButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nameLength = nameText.getText().toString().length();
                int schoolLength = schoolText.getText().toString().length();

                if (nameLength == 0 || schoolLength == 0 || !maleButton.isChecked() && !femaleButton.isChecked())
                    return;

                Intent nextIntent = new Intent(member1Activity.this, member2Activity.class);
                nextIntent.putExtra("gender", maleButton.isChecked());
                nextIntent.putExtra("name", nameText.getText().toString());
                startActivity(nextIntent);
            }
        });

        findViewById(R.id.searchButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchIntent = new Intent(member1Activity.this, SearchActivity.class);
                startActivity(searchIntent);
            }
        });
    }
}
