
package com.example.kushani17.SmartHealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.kushani17.myapplication.R;

public class OverweightActivity extends AppCompatActivity {
    Button alarm,workout,yoga,breakfast,lunch,dinner,groceries;
    String stype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overweight);
        final Bundle bundle= getIntent().getExtras();
        stype=bundle.getString("Id");
        Toast.makeText(OverweightActivity.this, stype, Toast.LENGTH_SHORT).show();
        alarm= (Button) findViewById(R.id.oalarm);
        workout= (Button) findViewById(R.id.oworkout);
        yoga= (Button) findViewById(R.id.oyoga);
        breakfast= (Button) findViewById(R.id.oBreakfast);
        lunch= (Button) findViewById(R.id.olunch);
        dinner= (Button) findViewById(R.id.odinner);
        groceries= (Button) findViewById(R.id.oGrocerires);
        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OverweightActivity.this,NalarmActivity.class);
                startActivity(i);
            }
        });
        workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(OverweightActivity.this,OworkoutActivity.class);
                Bundle bundle1=new Bundle();
                bundle1.putString("Type",stype);
                i.putExtras(bundle1);
                startActivity(i);
            }
        });

        yoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(OverweightActivity.this,OyogaActivity.class);
                Bundle bundle2=new Bundle();
                bundle2.putString("Type",stype);
                i.putExtras(bundle2);
                startActivity(i);
            }
        });
        breakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(OverweightActivity.this,ObreakfastActivity.class);
                Bundle bundle3=new Bundle();
                bundle3.putString("Type",stype);
                i.putExtras(bundle3);
                startActivity(i);
            }
        });
        lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(OverweightActivity.this,OlunchActivity.class);
                Bundle bundle4=new Bundle();
                bundle4.putString("Type",stype);
                i.putExtras(bundle4);
                startActivity(i);
            }
        });
        dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(OverweightActivity.this,OdinnerActivity.class);
                Bundle bundle5=new Bundle();
                bundle5.putString("Type",stype);
                i.putExtras(bundle5);
                startActivity(i);
            }
        });
        groceries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(OverweightActivity.this,NgroceriesActivity.class);
                Bundle bundle6=new Bundle();
                bundle6.putString("Type",stype);
                i.putExtras(bundle6);
                startActivity(i);
            }
        });
    }
}
