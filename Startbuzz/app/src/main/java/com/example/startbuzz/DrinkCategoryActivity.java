package com.example.startbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DrinkCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_category);

        ListView drinkCategoryListView = findViewById(R.id.list_options);
        ArrayAdapter<Drink> drinkArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Drink.drinks);
        drinkCategoryListView.setAdapter(drinkArrayAdapter);

        drinkCategoryListView.setOnItemClickListener(createListViewOnItemClickListener());
    }

    AdapterView.OnItemClickListener createListViewOnItemClickListener(){
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View view, int position, long id) {
                launchDrinkActivity(id);

            }
        };
    }

    void launchDrinkActivity(long id){
        Intent intent = new Intent(DrinkCategoryActivity.this, DrinkActivity.class);
        intent.putExtra(DrinkActivity.DRINK_NO, (int)id);
        startActivity(intent);
    }
}