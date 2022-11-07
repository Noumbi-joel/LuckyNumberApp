package com.example.luckyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class LuckyActivity extends AppCompatActivity {
    Button btn;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky);

        //ui components init
        btn = findViewById(R.id.shareNumberBtn);
        txt = findViewById(R.id.luckyNumber);

        //get param value = name
        Intent i = getIntent();
        String name = i.getStringExtra("name");

        //generate random number
        int random_number = generateRandomNumber();
        txt.setText(""+random_number);

        //share btn click listener
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(name, random_number);
            }
        });
    }

    public int generateRandomNumber(){
        Random random = new Random();
        int upper_list = 1000;

        int generatedNumber = random.nextInt(upper_list);

        return generatedNumber;
    }

    public void shareData(String username, int randomNumber){

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");

        //converts int to string
        String number = String.valueOf(randomNumber);

        intent.putExtra(Intent.EXTRA_SUBJECT, username+" got lucky today!");
        intent.putExtra(Intent.EXTRA_TEXT, "His lucky number is: "+number);

        startActivity(Intent.createChooser(intent, "Choose a platform"));
    }
}