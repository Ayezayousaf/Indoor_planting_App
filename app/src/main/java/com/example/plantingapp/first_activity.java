package com.example.plantingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class first_activity  extends AppCompatActivity {
    Button btn_Search,btn_Identifier,btn_Calander,btn_Seasonal,btn_PlantLocation;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        btn_Search=findViewById(R.id.search_btn);
        btn_Identifier=findViewById(R.id.identifier_btn);
        btn_Calander=findViewById(R.id.plant_Calander_btn);
        btn_PlantLocation=findViewById(R.id.plant_Location_btn);
        btn_Seasonal=findViewById(R.id.seasonal_btn);


    }

    public void SearchPlant(View view) {
        Intent intent=new Intent(first_activity.this,Search_for_Plants.class);
        startActivity(intent);
    }
}
