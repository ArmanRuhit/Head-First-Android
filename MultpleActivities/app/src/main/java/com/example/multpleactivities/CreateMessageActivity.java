package com.example.multpleactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreateMessageActivity extends AppCompatActivity {

    private Button sendMessageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
        sendMessageButton = findViewById(R.id.send);

        //Add onClickListern on sendMessageButton
        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateMessageActivity.this, RecieveMessageActivity.class);
                startActivity(intent);
            }
        });
    }
}