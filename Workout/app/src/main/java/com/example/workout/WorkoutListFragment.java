package com.example.workout;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

public class WorkoutListFragment extends ListFragment {

    static interface WorkoutListListener{
        void itemClicked(long id);
    }

    private WorkoutListListener workoutListListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String[] names = new String[Workout.workouts.length];
        int i = 0;
        for(Workout workout : Workout.workouts){
            names[i] = workout.getName();
            i++;
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(inflater.getContext(), android.R.layout.simple_list_item_1, names);
        setListAdapter(arrayAdapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof Activity){
            this.workoutListListener = (WorkoutListListener) context;
        }
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        if(workoutListListener != null){
            workoutListListener.itemClicked(id);
        }
    }
}
