package com.example.kushani17.SmartHealth;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kushani17.myapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {
    EditText email, password;
    Button login;
    String semail, spassword;
    SharedPreferences sp;
    TextView HyperLink;
    Spanned Text;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sp = getSharedPreferences(ConstantSp.PREFERENCE, MODE_PRIVATE);
        HyperLink = (TextView) findViewById(R.id.textView1);
        HyperLink.setMovementMethod(LinkMovementMethod.getInstance());
        HyperLink.setText(Html.fromHtml("" +
                "<a href=''>No Account Yet?Click Here</a>"));
        HyperLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(i);
            }
        });
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.pass);
        login = (Button) findViewById(R.id.btnlogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(LoginActivity.this, BmiActivity.class);
                startActivity(i);
            }
        });



        // login.setOnClickListener(new View.OnClickListener() {
        //@Override
        //   public void onClick(View v) {
               /* if (email.getText().toString().equalsIgnoreCase("")) {
                    email.setError("Enter email");
                } else if (password.getText().toString().equalsIgnoreCase("")) {
                    password.setError("Enter Password");
                } else {
                    if (new ConnectionDetector(LoginActivity.this).isConnectingToInternet()) {
                        semail = email.getText().toString();
                        spassword = password.getText().toString();
                        //new jsoninsert().execute();
                    } else {
                        new ConnectionDetector(LoginActivity.this).connectiondetect();
                    }
                }
            }
        });

    }

   /* private class jsoninsert extends AsyncTask<String, String, String> {
        ProgressDialog pd;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = new ProgressDialog(LoginActivity.this);
            pd.setMessage("Loading....");
            pd.setCancelable(true);
            pd.show();
        }

        @Override
        protected String doInBackground(String... params) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("email", semail);
            hashMap.put("pass", spassword);
            Log.d("ABCDLogin", new MakeServiceCall().getPostData(ConstantUrl.BASEURL + "login.php", hashMap));
            return new MakeServiceCall().getPostData(ConstantUrl.BASEURL + "login.php", hashMap);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (pd.isShowing()) {
                pd.dismiss();
            }
            try {
                JSONObject jsonObject = new JSONObject(s.toString());
                if (jsonObject.getString("Status").equalsIgnoreCase("True")) {
                    Toast.makeText(LoginActivity.this, jsonObject.getString("Message"), Toast.LENGTH_SHORT).show();
                    JSONArray jsonArray = jsonObject.getJSONArray("response");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        String gender = object.getString("gender");
                        sp.edit().putString(ConstantSp.GENDER, gender).commit();
                        Intent intent = new Intent(LoginActivity.this, BmiActivity.class);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(LoginActivity.this, jsonObject.getString("Message"), Toast.LENGTH_SHORT).show();
                }*/
    }
//catch (JSONException e) {
    //              e.printStackTrace();
    //        }
    //  }
    //}
//}
}