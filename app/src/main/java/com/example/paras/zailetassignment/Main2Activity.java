package com.example.paras.zailetassignment;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    RecyclerView recyclerViewlist;
    RecyclerView.Adapter adaptar;

    ArrayList<posts> arrayList1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        LinearLayoutManager m=new LinearLayoutManager(this);
        m.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerViewlist = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerViewlist.setHasFixedSize(true);
        recyclerViewlist.setLayoutManager(m);
        resultasyntask rst = new resultasyntask();
        rst.execute("http://zailet.com/zailet_internship_assignment/get_data.php?topics_info=1");

    }

    public class resultasyntask extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(String... params) {

            URL url = null;
            HttpURLConnection httpURLConnection = null;

            try {
                url = new URL((String) params[0]);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            try {
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(10000);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                String s = null;
                InputStreamReader ir = new InputStreamReader(
                        httpURLConnection.getInputStream()
                );
                BufferedReader br = new BufferedReader(ir);
                StringBuilder sb = new StringBuilder();
                String str = null;
                while ((str = br.readLine()) != null) {
                    sb.append(str);
                    s = sb.toString();
                }
                return s;
            } catch (IOException e) {

            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray = jsonObject.getJSONArray("posts");
                arrayList1 = new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    JSONObject jsonObject2=jsonObject1.getJSONObject("post_info");
                    JSONObject jsonObject3=jsonObject1.getJSONObject("author_info");
                    //tv.setText(jsonObject2.get("id").toString());
                    arrayList1.add(new posts(jsonObject2.get("title").toString(),jsonObject2.get("id").toString(),jsonObject2.getString("time"), jsonObject2.getString("thumbnail"),jsonObject2.getString("description"),jsonObject2.getString("cover"),jsonObject3.get("id").toString(),jsonObject3.getString("name"),jsonObject3.getString("username"),jsonObject3.getString("dp")));
                }
                PostAdaptar adapter = new PostAdaptar(Main2Activity.this,arrayList1);
                recyclerViewlist.setAdapter(adapter);
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
        }
    }
}


