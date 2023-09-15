package com.example.startbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class TopLevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);

        AdapterView.OnItemClickListener listViewOnItemClickListener = createListViewOnItemClickListener();

        ListView listView = findViewById(R.id.list_options);
        listView.setOnItemClickListener(listViewOnItemClickListener);

    }


    AdapterView.OnItemClickListener createListViewOnItemClickListener(){
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View view, int position, long id) {
                if(position == 0){
                    launchDrinkCategoryActivity();
                }
            }
        };
    }

    void launchDrinkCategoryActivity(){
        Intent intent = new Intent(TopLevelActivity.this, DrinkCategoryActivity.class);
        startActivity(intent);
    }
}