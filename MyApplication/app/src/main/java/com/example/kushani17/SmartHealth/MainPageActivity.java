package com.example.kushani17.SmartHealth;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kushani17.myapplication.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainPageActivity extends AppCompatActivity {
    int[] imageResources = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5};
    Button signup, login;
    ViewPager viewPager;
    customSwip adapter;
    int count = 0;
    Timer timer;
    Setget setget;
    ArrayList<Setget> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (Button) findViewById(R.id.login_main);
        signup = (Button) findViewById(R.id.signup);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setCurrentItem(0);
        arrayList = new ArrayList<>();
        for (int i = 0; i < imageResources.length; i++) {
            setget = new Setget();
            setget.setImages(imageResources[i]);
            arrayList.add(setget);
        }
        adapter = new customSwip(MainPageActivity.this, arrayList);
        viewPager.setAdapter(adapter);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (count <= arrayList.size()) {
                            viewPager.setCurrentItem(count);
                            count++;
                        } else {
                            count = 0;
                            viewPager.setCurrentItem(count);
                        }
                    }
                });
            }
        }, 3000, 3000);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainPageActivity.this, SignupActivity.class);
                startActivity(i);

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPageActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}