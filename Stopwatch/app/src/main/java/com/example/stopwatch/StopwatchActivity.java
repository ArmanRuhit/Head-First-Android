package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StopwatchActivity extends AppCompatActivity {

    private Button start;
    private Button stop;
    private Button reset;

    private int seconds;

    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        start = findViewById(R.id.start_button);
        stop = findViewById(R.id.stop_button);
        reset = findViewById(R.id.reset_button);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                running = true;
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                running = false;
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                running = false;
                seconds = 0;
            }
        });

    }

    private void runTimer(){
        final TextView timeView = findViewById(R.id.time_view);

        int hours = seconds/3600;
        int minutes = (seconds%3600)/60;
        int secs = seconds%60;

        String time = String.format("%d:%02d:%02d", hours, minutes, secs);
        timeView.setText(time);

        if(running){
            seconds++;
        }
    }
}