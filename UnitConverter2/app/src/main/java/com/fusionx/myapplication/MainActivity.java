package com.fusionx.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fusionx.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.cardViewArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CalculationActivity.class);
                intent.putExtra("card_name","card_area");
                startActivity(intent);
            }
        });
 binding.cardViewLength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CalculationActivity.class);
                intent.putExtra("card_name","card_length");
                startActivity(intent);
            }
        });
 binding.cardViewFrequency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CalculationActivity.class);
                intent.putExtra("card_name","card_frequency");
                startActivity(intent);
            }
        });
 binding.cardViewMass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CalculationActivity.class);
                intent.putExtra("card_name","card_mass");
                startActivity(intent);
            }
        });
 binding.cardViewSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CalculationActivity.class);
                intent.putExtra("card_name","card_speed");
                startActivity(intent);
            }
        });
 binding.cardViewTemperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CalculationActivity.class);
                intent.putExtra("card_name","card_temperature");
                startActivity(intent);
            }
        });


    }
}