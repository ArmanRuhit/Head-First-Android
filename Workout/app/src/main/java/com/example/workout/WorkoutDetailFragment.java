package com.example.workout;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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
        View view = inflater.inflate(R.layout.fragment_workout_detail, container, false);
        // Sample data for the list
        String[] items = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

        // Create an ArrayAdapter to display the items in the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, items);

        ListView listView = view.findViewById(R.id.list123);
        listView.setAdapter(adapter);
        return view;
    }
}