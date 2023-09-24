package com.example.workout;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class WorkoutDetailFragment extends Fragment {


    private long workoutId;

    public void setWorkoutId(long workoutId) {
        this.workoutId = workoutId;
    }

    public WorkoutDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("onCreateView", "method is called");
        if(savedInstanceState!=null){
            workoutId = savedInstanceState.getLong("workoutId");
        }
        View view = inflater.inflate(R.layout.fragment_workout_detail, container, false);
        TextView titleTextView = view.findViewById(R.id.title);
        TextView descriptionTextView = view.findViewById(R.id.description);
        Workout workout = Workout.workouts[(int) workoutId];
        titleTextView.setText(workout.getName());
        descriptionTextView.setText(workout.getDescription());
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putLong("workoutId", workoutId);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}