package com.example.kushani17.SmartHealth;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.kushani17.myapplication.R;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class UlunchActivity extends AppCompatActivity {

    SharedPreferences sp;
    String sgender, stype;
    ArrayList<Ulunchlist> ulunchlists;
    UlunchAdapter ulunchAdapter;
    ListView listView;

    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ulunch);
        sp = getSharedPreferences(ConstantSp.PREFERENCE, MODE_PRIVATE);
        sgender = sp.getString(ConstantSp.GENDER, "");
        Bundle bundle = getIntent().getExtras();
        stype = bundle.getString("Type");
        Toast.makeText(UlunchActivity.this, stype, Toast.LENGTH_SHORT).show();
        listView = (ListView) findViewById(R.id.ulunch_lv);
        if (new ConnectionDetector(UlunchActivity.this).isConnectingToInternet()) {
            new getWeightData().execute();
        } else {
            new ConnectionDetector(UlunchActivity.this).connectiondetect();
        }

    }


    private class getWeightData extends AsyncTask<String, String, String> {

        ProgressDialog pd;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = new ProgressDialog(UlunchActivity.this);
            pd.setMessage("Loading...");
            pd.show();
        }

        @Override
        protected String doInBackground(String... params) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("gender", sgender);
            hashMap.put("typeWork", stype);
            return new MakeServiceCall().getPostData(ConstantUrl.BASEURL + "underweight_json.php", hashMap);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (pd.isShowing()) {
                pd.dismiss();
            }
            try {
                JSONObject object = new JSONObject(s.toString());
                if (object.getString("Status").equalsIgnoreCase("True")) {
                    JSONArray jsonArray = object.getJSONArray("response");
                    ulunchlists = new ArrayList<>();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Ulunchlist list = new Ulunchlist();
                        list.setdata(jsonObject.getString("lunch"));
                        list.setImage(jsonObject.getString("lunch_image"));
                        ulunchlists.add(list);
                    }
                    ulunchAdapter = new UlunchAdapter(UlunchActivity.this,ulunchlists);
                    listView.setAdapter(ulunchAdapter);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
