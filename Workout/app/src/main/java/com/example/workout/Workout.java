package com.example.workout;

import java.util.List;

public class Workout {
    private String name;
    private String description;

    public Workout(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static final Workout[] workouts = {
            new Workout("The limb loosener", "5 handstand pushups"),
            new Workout("Core Agony", "100 pull-ups"),
            new Workout("Strength and length", "500 meter run"),
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
