package com.example.kushani17.SmartHealth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.example.kushani17.myapplication.R;

public class SpiceActivity extends AppCompatActivity {
    TextView HyperLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spice);
        HyperLink = (TextView)findViewById(R.id.linkspices);
        HyperLink.setMovementMethod(LinkMovementMethod.getInstance());
        HyperLink.setText(Html.fromHtml("" +
                "<a href='https://grofers.com/s/?q=spices&suggestion_type=0&t=1'><br>Buy Spices Here</a>"));
    }
}
