package com.example.multpleactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RecieveMessageActivity extends AppCompatActivity {

    private TextView messageText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieve_message);
        messageText = findViewById(R.id.messageText);
        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        messageText.setText(message);
    }
}