package com.example.kushani17.SmartHealth;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.kushani17.myapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class UworkoutActivity extends AppCompatActivity {

    SharedPreferences sp;
    String sgender, stype;
    ArrayList<UworkoutList> uworkoutLists;
    UworkOutAdapter uworkOutAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uworkout);
        sp = getSharedPreferences(ConstantSp.PREFERENCE, MODE_PRIVATE);
        sgender = sp.getString(ConstantSp.GENDER, "");
        Bundle bundle = getIntent().getExtras();
        stype = bundle.getString("Type");
        listView = (ListView) findViewById(R.id.uworkout_lv);
        if (new ConnectionDetector(UworkoutActivity.this).isConnectingToInternet()) {
            new getWeightData().execute();
        } else {
            new ConnectionDetector(UworkoutActivity.this).connectiondetect();
        }
    }


    private class getWeightData extends AsyncTask<String, String, String> {

        ProgressDialog pd;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = new ProgressDialog(UworkoutActivity.this);
            pd.setMessage("Loading...");
            pd.show();
        }

        @Override
        protected String doInBackground(String... params) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("gender", sgender);
            hashMap.put("typeWork", stype);
            Log.d("RESPONSEWORK",new MakeServiceCall().getPostData(ConstantUrl.BASEURL + "underweight_json.php", hashMap));
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
                if (object.getString("Status").equalsIgnoreCase("true")) {
                    uworkoutLists = new ArrayList<>();
                    JSONArray jsonArray = object.getJSONArray("response");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        UworkoutList list = new UworkoutList();
                        list.setTips1(jsonObject.getString("uworkout"));
                        list.setImage(jsonObject.getString("uworkout_image"));
                        uworkoutLists.add(list);
                    }
                    uworkOutAdapter = new UworkOutAdapter(UworkoutActivity.this, uworkoutLists);
                    listView.setAdapter(uworkOutAdapter);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
