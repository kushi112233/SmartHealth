package com.example.kushani17.SmartHealth;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.kushani17.myapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class NbreakfastActivity extends AppCompatActivity {

    SharedPreferences sp;
    String sgender;
    String stype;
    ArrayList<Nbreaklist> nbreakists;
    NbreakAdapter nbreakAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nbreakfast);
        sp = getSharedPreferences(ConstantSp.PREFERENCE, MODE_PRIVATE);
        sgender = sp.getString(ConstantSp.GENDER, "");
        Bundle bundle = getIntent().getExtras();
        stype = bundle.getString("Type");
        Toast.makeText(NbreakfastActivity.this, stype, Toast.LENGTH_SHORT).show();
        listView = (ListView) findViewById(R.id.nbreak_lv);
        if (new ConnectionDetector(NbreakfastActivity.this).isConnectingToInternet()) {
            new getWeightData().execute();
        } else {
            new ConnectionDetector(NbreakfastActivity.this).connectiondetect();
        }

    }

    private class getWeightData extends AsyncTask<String, String, String> {

        ProgressDialog pd;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = new ProgressDialog(NbreakfastActivity.this);
            pd.setMessage("Loading...");
            pd.show();
        }

        @Override
        protected String doInBackground(String... params) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("gender", sgender);
            hashMap.put("typeWork", stype);
            return new MakeServiceCall().getPostData(ConstantUrl.BASEURL + "normal_json.php", hashMap);
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
                    nbreakists = new ArrayList<>();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Nbreaklist list = new Nbreaklist();
                        list.setTok(jsonObject.getString("breakfast"));
                        list.setImage(jsonObject.getString("breakfast_image"));
                        nbreakists.add(list);
                    }
                    nbreakAdapter = new NbreakAdapter(NbreakfastActivity.this, nbreakists);
                    listView.setAdapter(nbreakAdapter);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
