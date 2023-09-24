package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.WorkoutListListener {

    WorkoutDetailFragment workoutDetailFragment = new WorkoutDetailFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void itemClicked(long id) {
        workoutDetailFragment.setWorkoutId(id);

    }
}