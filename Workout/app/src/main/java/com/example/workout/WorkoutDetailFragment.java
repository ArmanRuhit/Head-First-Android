package com.example.workout;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WorkoutDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WorkoutDetailFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private long workoutId;

    public void setWorkoutId(long workoutId) {
        this.workoutId = workoutId;
    }

    public WorkoutDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WorkoutDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WorkoutDetailFragment newInstance(String param1, String param2) {
        WorkoutDetailFragment fragment = new WorkoutDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView titleTextView = view.findViewById(R.id.title);
        Workout workout = Workout.workouts[(int) workoutId];
        titleTextView.setText(workout.getName());
        TextView descriptionTextView = view.findViewById(R.id.description);
        descriptionTextView.setText(workout.getDescription());
    }
}