package com.example.paras.zailetassignment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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
import java.util.List;

public class MainActivity extends AppCompatActivity {
List<result> arrayList;
    RecyclerView recyclerViewlist;
    Button bt1;

    ResultAdaptar adapter;
ResultAdaptar.Viewholder holder;
    {

    }
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StaggeredGridLayoutManager m=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL);
        m.setOrientation(StaggeredGridLayoutManager.HORIZONTAL);
        recyclerViewlist = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerViewlist.setHasFixedSize(true);
        recyclerViewlist.setLayoutManager(m);
        recyclerViewlist.addItemDecoration(new space(50));
        bt1=(Button) findViewById(R.id.pro);
        resultasyntask rst=new resultasyntask();
                rst.execute("http://zailet.com/zailet_internship_assignment/get_data.php?get_topics=1");
bt1.setOnClickListener(new View.OnClickListener() {
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
       if (adapter.counter>=10) {
           Intent i = new Intent(MainActivity.this, Main2Activity.class);
           startActivity(i);
       }
           else
           {int r=(10-adapter.counter);
               AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this).setMessage("PLEASE SELECT "+r+" MORE TOPICS TO PROCEED");
                builder.create();
               builder.show();

         }
    }
});


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
                String s=null;
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
            JSONObject jsonObject=null;
            try {
                jsonObject = new JSONObject(s);
                JSONArray jsonArray= jsonObject.getJSONArray("result");
                arrayList=new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    arrayList.add(new result(jsonObject1.getInt("id"),jsonObject1.getString("interest"),jsonObject1.getString("cover"),jsonObject1.getString("time")));
                }
                adapter=new ResultAdaptar(MainActivity.this,arrayList);
                recyclerViewlist.setAdapter(adapter);

                Log.d("Topic",arrayList.get(0).getInterest());
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }


}

}




