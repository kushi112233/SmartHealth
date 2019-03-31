package com.example.kushani17.SmartHealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kushani17.myapplication.R;

public class BmiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        final EditText e1 = (EditText) findViewById(R.id.et1);
        final EditText e2 = (EditText) findViewById(R.id.et2);
        final TextView tv4 = (TextView) findViewById(R.id.tv4);

        findViewById(R.id.ib1).setOnClickListener(new View.OnClickListener() {

            // Logic for validation, input can't be empty
            @Override
            public void onClick(View v) {

                String str1 = e1.getText().toString();
                String str2 = e2.getText().toString();

                if(TextUtils.isEmpty(str1)){
                    e1.setError("Please enter your weight");
                    e1.requestFocus();
                    return;
                }

                if(TextUtils.isEmpty(str2)){
                    e2.setError("Please enter your height");
                    e2.requestFocus();
                    return;
                }


//Get the user values from the widget reference
                float weight = Float.parseFloat(str1);
                float height = Float.parseFloat(str2)/100;

//Calculate BMI value
                float bmiValue = calculateBMI(weight, height);

//Define the meaning of the bmi value
                String bmiInterpretation = interpretBMI(bmiValue);
                if(bmiInterpretation.equals("Severely underweight")){
                    Intent intent = new Intent(BmiActivity.this,UnderweightActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("Id","Severely underweight");
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                if(bmiInterpretation.equals("Underweight")){
                    Intent intent = new Intent(BmiActivity.this,UnderweightActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("Id","Underweight");
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                if(bmiInterpretation.equals("Normal")){
                    Intent intent = new Intent(BmiActivity.this,NormaActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("Id","Normal");
                    intent.putExtras(bundle);
                    startActivity(intent);
                }if(bmiInterpretation.equals("Overweight")){
                    Intent intent = new Intent(BmiActivity.this,OverweightActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("Id","Overweight");
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                if(bmiInterpretation.equals("Obese")){
                    Intent intent = new Intent(BmiActivity.this,OverweightActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("Id","Obese");
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                tv4.setText(String.valueOf(bmiValue + "-" + bmiInterpretation));
            }
        });

    }

    //Calculate BMI
    private float calculateBMI (float weight, float height) {
        return (float) (weight / (height * height));
    }

    // Interpret what BMI means
    private String interpretBMI(float bmiValue) {

       if (bmiValue < 18.5) {

            return "Underweight";
        } else if (bmiValue < 25) {

            return "Normal";
        } else {
            return "Overweight";
        }
    }
}
