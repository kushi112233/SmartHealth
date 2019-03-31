package com.example.kushani17.SmartHealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.kushani17.myapplication.R;

public class NormaActivity extends AppCompatActivity {
    Button alarm,workout,yoga,breakfast,lunch,dinner,groceries;
    String stype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Bundle bundle=getIntent().getExtras();
        stype=bundle.getString("Id");
        Toast.makeText(NormaActivity.this, stype, Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_norma);
        alarm= (Button) findViewById(R.id.nalarm);
        workout= (Button) findViewById(R.id.nworkout);
        yoga= (Button) findViewById(R.id.nyoga);
        breakfast= (Button) findViewById(R.id.nBreakfast);
        lunch= (Button) findViewById(R.id.nlunch);
        dinner= (Button) findViewById(R.id.ndinner);
        groceries= (Button) findViewById(R.id.nGrocerires);
        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NormaActivity.this,NalarmActivity.class);
                startActivity(i);
            }
        });
        workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(NormaActivity.this,NworkoutActivity.class);
                Bundle bundle1=new Bundle();
                bundle1.putString("Type",stype);
                i.putExtras(bundle1);
                startActivity(i);
            }
        });

        yoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(NormaActivity.this,NyogaActivity.class);
                Bundle bundle2=new Bundle();
                bundle2.putString("Type",stype);
                i.putExtras(bundle2);
                startActivity(i);
            }
        });
        breakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(NormaActivity.this,NbreakfastActivity.class);
                Bundle bundle3=new Bundle();
                bundle3.putString("Type",stype);
                i.putExtras(bundle3);
                startActivity(i);
            }
        });
        lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(NormaActivity.this,NlunchActivity.class);
                Bundle bundle4=new Bundle();
                bundle4.putString("Type",stype);
                i.putExtras(bundle4);
                startActivity(i);
            }
        });
        dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(NormaActivity.this,NdinnerActivity.class);
                Bundle bundle5=new Bundle();
                bundle5.putString("Type",stype);
                i.putExtras(bundle5);
                startActivity(i);
            }
        });
        groceries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(NormaActivity.this,NgroceriesActivity.class);
                Bundle bundle6=new Bundle();
                bundle6.putString("Type",stype);
                i.putExtras(bundle6);
                startActivity(i);
            }
        });
    }
}
