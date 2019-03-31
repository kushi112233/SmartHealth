package com.example.kushani17.SmartHealth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.kushani17.myapplication.R;

public class UnderweightActivity extends AppCompatActivity {
    Button alarm, workout, yoga, breakfast, lunch, dinner, groceries;
    String stype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_underweight);
        final Bundle bundle = getIntent().getExtras();
        stype = bundle.getString("Id");
        Toast.makeText(UnderweightActivity.this, stype, Toast.LENGTH_SHORT).show();
        alarm = (Button) findViewById(R.id.ualarm);
        workout = (Button) findViewById(R.id.uworkout);
        yoga = (Button) findViewById(R.id.uyoga);
        breakfast = (Button) findViewById(R.id.uBreakfast);
        lunch = (Button) findViewById(R.id.ulunch);
        dinner = (Button) findViewById(R.id.udinner);
        groceries = (Button) findViewById(R.id.uGrocerires);
        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UnderweightActivity.this, NalarmActivity.class);
                startActivity(i);
            }
        });
        workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UnderweightActivity.this, UworkoutActivity.class);
                Bundle bundle1 = new Bundle();
                bundle1.putString("Type", stype);
                i.putExtras(bundle1);
                startActivity(i);
            }
        });

        yoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("Type", stype);
                Intent i = new Intent(UnderweightActivity.this, UyogaActivity.class);
                i.putExtras(bundle2);
                startActivity(i);
            }
        });
        breakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle3 = new Bundle();
                bundle3.putString("Type", stype);
                Intent i = new Intent(UnderweightActivity.this, UbreakfastActivity.class);
                i.putExtras(bundle3);
                startActivity(i);
            }
        });
        lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle4 = new Bundle();
                bundle4.putString("Type", stype);
                Intent i = new Intent(UnderweightActivity.this, UlunchActivity.class);
                i.putExtras(bundle4);
                startActivity(i);
            }
        });
        dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle5 = new Bundle();
                bundle5.putString("Type", stype);
                Intent i = new Intent(UnderweightActivity.this, UdinnerActivity.class);
                i.putExtras(bundle5);
                startActivity(i);
            }
        });
        groceries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle6 = new Bundle();
                bundle6.putString("Type", stype);
                Intent i = new Intent(UnderweightActivity.this, NgroceriesActivity.class);
                i.putExtras(bundle6);
                startActivity(i);
            }
        });
    }

}
