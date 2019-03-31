package com.example.kushani17.SmartHealth;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kushani17.myapplication.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class SignupActivity extends AppCompatActivity {

    EditText name, email, password, phone, address, age;
    String sname, semail, spassword, sphone, saddress, sage;
    Button Register;
    RadioGroup rg;
    RadioButton male, female;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name = (EditText) findViewById(R.id.etname);
        email = (EditText) findViewById(R.id.etemail);
        password = (EditText) findViewById(R.id.etpass);
        phone = (EditText) findViewById(R.id.etphone);
        address = (EditText) findViewById(R.id.etadd);
        age = (EditText) findViewById(R.id.etage);
        rg = (RadioGroup) findViewById(R.id.rg);
        male = (RadioButton) findViewById(R.id.male);
        female = (RadioButton) findViewById(R.id.Female);
        Register = (Button) findViewById(R.id.Register);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (name.getText().toString().equalsIgnoreCase("")) {
                    name.setError("Enter Name");
                    return;
                } else if (email.getText().toString().equalsIgnoreCase("")) {
                    email.setError("Enter Email");
                    return;
                } else if (password.getText().toString().equalsIgnoreCase("")) {
                    password.setError("Enter Password");
                    return;
                } else if (address.getText().toString().equalsIgnoreCase("")) {
                    address.setError("Enter Address");
                    return;
                } else if (age.getText().toString().equalsIgnoreCase("")) {
                    age.setError("Enter age");
                    return;
                } else {
                    if (new ConnectionDetector(SignupActivity.this).isConnectingToInternet()) {
                        sname = name.getText().toString();
                        semail = email.getText().toString();
                        spassword = password.getText().toString();
                        saddress = address.getText().toString();
                        sage = age.getText().toString();
                        sphone = phone.getText().toString();
                        new jsoninsert().execute();
                    } else {
                        new ConnectionDetector(getApplicationContext()).connectiondetect();
                    }
                }

            }
        });
    }

    private class jsoninsert extends AsyncTask<String, String, String> {
        ProgressDialog pd;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = new ProgressDialog(SignupActivity.this);
            pd.setMessage("Loading....");
            pd.setCancelable(true);
            pd.show();
        }

        @Override
        protected String doInBackground(String... params) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("action", "abc");
            hashMap.put("name", sname);
            hashMap.put("email", semail);
            hashMap.put("pass", spassword);
            hashMap.put("cno", sphone);
            hashMap.put("address", saddress);
            hashMap.put("age", sage);
            return new MakeServiceCall().getPostData(ConstantUrl.BASEURL + "insertRecord.php", hashMap);
        }

        @Override
        protected void onPostExecute(String s) {
            if (pd.isShowing()) {
                pd.dismiss();
            }
            try {
                JSONObject jsonObject = new JSONObject(s.toString());
                Intent i = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(i);
                if (jsonObject.getString("Status").equalsIgnoreCase("True")) {
                    Toast.makeText(SignupActivity.this, jsonObject.getString("Message"), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SignupActivity.this, jsonObject.getString("Message"), Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            super.onPostExecute(s);
        }
    }

}
