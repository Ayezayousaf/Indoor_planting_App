package com.example.plantingapp;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

public class Search_for_Plants extends AppCompatActivity {
    SearchView searchView;
    ListView listView;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_for_plants);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        searchView=findViewById(R.id.searchView);
        listView=findViewById(R.id.listView);

    }
}
