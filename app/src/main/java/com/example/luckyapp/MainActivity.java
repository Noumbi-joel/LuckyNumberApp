package com.example.luckyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ui components init
        btn = findViewById(R.id.button);
        editText = findViewById(R.id.editText);

        //set a click listener and passing username to Lucky activity
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get username
                String name = editText.getText().toString();
                Intent i = new Intent(getApplicationContext(), LuckyActivity.class);
                i.putExtra("name", name);
                startActivity(i);
            }
        });
    }
}