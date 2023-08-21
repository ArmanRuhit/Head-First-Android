package com.example.multpleactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateMessageActivity extends AppCompatActivity {

    private Button sendMessageButton;
    private EditText messageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
        sendMessageButton = findViewById(R.id.send);
        messageEditText = findViewById(R.id.messageEditText);

        //Add onClickListern on sendMessageButton
        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = messageEditText.getText().toString();
//                Intent intent = new Intent(CreateMessageActivity.this, RecieveMessageActivity.class);
//                intent.putExtra("message", message);

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, message);

                Intent chosenIntent = Intent.createChooser(intent, "Select App to send message");
                startActivity(chosenIntent);
            }
        });
    }
}