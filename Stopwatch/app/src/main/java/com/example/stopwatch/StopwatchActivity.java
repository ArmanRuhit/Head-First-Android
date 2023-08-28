package com.example.stopwatch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StopwatchActivity extends AppCompatActivity {

    private Button start;
    private Button stop;
    private Button reset;

    // number of seconds displayed on the stopwatch
    private int seconds = 0;

    // Is the stopwatch running?
    private boolean running;

    // to check if the stopwatch was running before the onStop() method was called
    private boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        if(savedInstanceState != null){
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }

        runTimer();

        start = findViewById(R.id.start_button);
        stop = findViewById(R.id.stop_button);
        reset = findViewById(R.id.reset_button);

        //Start the stopwatch runnign when the Start button is clicked
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                running = true;
            }
        });


        //Stop the stopwatch running when Stop button is clicked
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                running = false;
            }
        });


        //Reset the stopwatch when the reset button is clicked
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                running = false;
                seconds = 0;
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        if(wasRunning){
            running = true;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(wasRunning){
            running = true;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("seconds", seconds);
        outState.putBoolean("running", running);
        outState.putBoolean("wasRunning", wasRunning);
        super.onSaveInstanceState(outState);
    }

    private void runTimer(){
        System.out.println("runtimer is called");
        final TextView timeView = findViewById(R.id.time_view);

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;

                String time = String.format("%d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);

                if(running){
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        wasRunning = running;
        running=false;
    }

    @Override
    protected void onStop() {
        super.onStop();
        wasRunning = running;
        running=false;
    }
}