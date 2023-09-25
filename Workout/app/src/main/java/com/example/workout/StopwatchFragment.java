package com.example.workout;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class StopwatchFragment extends Fragment {

    private int seconds = 0;
    private boolean running;
    private boolean wasRunning;

    private Button start;
    private Button stop;
    private Button reset;



    public StopwatchFragment() {
        // Required empty public constructor
    }





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null){
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");

            if(wasRunning){
                running = true;
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_stopwatch, container, false);
        start = layout.findViewById(R.id.start_button);
        stop = layout.findViewById(R.id.stop_button);
        reset = layout.findViewById(R.id.reset_button);

        start.setOnClickListener(onClickStartListener());
        stop.setOnClickListener(onClickStopListener());
        reset.setOnClickListener(onClickResetListener());

        runtimer(layout);
        return layout;
    }

    private void runtimer(View layout) {
        final TextView timeView = (TextView) layout.findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int min = seconds/60;
                int secs = seconds%60;
                String time = String.format("$d:%02d:%02d", hours, min, secs);

                timeView.setText(time);
                if(running){
                    seconds++;
                }
                handler.postDelayed(this::run, 1000);
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        wasRunning = running;
        running = false;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(wasRunning){
            running = true;
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("seconds", seconds);
        outState.putBoolean("running", running);
        outState.putBoolean("wasRunning", wasRunning);
    }



    View.OnClickListener onClickStartListener(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                running = true;
            }
        };
    }

    View.OnClickListener onClickStopListener(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                running = false;
            }
        };
    }

    View.OnClickListener onClickResetListener(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                running = false;
                seconds = 0;
            }
        };
    }



}