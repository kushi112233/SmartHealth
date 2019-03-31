package com.example.kushani17.SmartHealth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.example.kushani17.myapplication.R;

public class MilkActivity extends AppCompatActivity {
    TextView HyperLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milk);
        HyperLink = (TextView)findViewById(R.id.linkmilk);
        HyperLink.setMovementMethod(LinkMovementMethod.getInstance());
        HyperLink.setText(Html.fromHtml("" +
                "<a href='https://grofers.com/s/?q=milk&suggestion_type=0&t=1'><br>Buy Milk Products Here</a>"));
    }
}
