package com.example.kushani17.SmartHealth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.example.kushani17.myapplication.R;

public class JuiceActivity extends AppCompatActivity {
    TextView HyperLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juice);
        HyperLink = (TextView)findViewById(R.id.linkjuice);
        HyperLink.setMovementMethod(LinkMovementMethod.getInstance());
        HyperLink.setText(Html.fromHtml("" +
                "<a href='https://grofers.com/s/?q=juices&suggestion_type=0&t=1'><br>Buy Juices Here</a>"));
    }
}
