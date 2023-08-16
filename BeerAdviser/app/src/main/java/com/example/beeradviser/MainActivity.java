package com.example.beeradviser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public Button findBeerButton;
    public TextView brands;
    public Spinner colors;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findBeerButton = findViewById(R.id.find_beer);
        brands = findViewById(R.id.brands);
        colors = findViewById(R.id.color);
        findBeerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedColor = String.valueOf(colors.getSelectedItem());
                brands.setText(selectedColor);
            }
        });
    }
}