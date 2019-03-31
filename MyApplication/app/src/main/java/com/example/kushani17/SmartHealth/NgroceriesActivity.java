package com.example.kushani17.SmartHealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kushani17.myapplication.R;

public class NgroceriesActivity extends AppCompatActivity {
    Button grain,bread,juice,spice,milk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngroceries);
        grain= (Button) findViewById(R.id.MultiGrains);
        bread= (Button) findViewById(R.id.bread);
        juice= (Button) findViewById(R.id.Juices);
        spice= (Button) findViewById(R.id.Spices);
        milk= (Button) findViewById(R.id.Milk);
        grain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NgroceriesActivity.this,GrainActivity.class);
                startActivity(i);
            }
        });
        bread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NgroceriesActivity.this,BreadActivity.class);
                startActivity(i);
            }
        });
        juice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NgroceriesActivity.this,JuiceActivity.class);
                startActivity(i);
            }
        });
        spice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NgroceriesActivity.this,SpiceActivity.class);
                startActivity(i);
            }
        });
        milk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NgroceriesActivity.this,MilkActivity.class);
                startActivity(i);
            }
        });

    }
}
