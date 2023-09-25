package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class MainActivity extends AppCompatActivity implements WorkoutListFragment.WorkoutListListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void itemClicked(long id) {
        View fragmentContainer = findViewById(R.id.detail_frag_container);
        if(fragmentContainer != null) {
            WorkoutDetailFragment workoutDetailFragment = new WorkoutDetailFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            workoutDetailFragment.setWorkoutId(id);
            fragmentTransaction.replace(R.id.detail_frag_container, workoutDetailFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        } else{
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.WORKOUT_ID, (int)id);
            startActivity(intent);
        }
    }
}