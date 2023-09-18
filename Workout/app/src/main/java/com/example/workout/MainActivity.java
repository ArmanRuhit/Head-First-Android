package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WorkoutDetailFragment workoutDetailFragment = new WorkoutDetailFragment();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.detail_frag, workoutDetailFragment, null)
                    .commit();
            workoutDetailFragment.setWorkoutId(2);
        }
    }
}