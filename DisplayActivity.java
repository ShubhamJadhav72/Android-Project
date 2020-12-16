package com.example.omsaiwashing;

import androidx.appcompat.app.AppCompatActivity;

import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

public class DisplayActivity extends AppCompatActivity {
   // ListView listView;
    //ArrayAdapter<String> adapter;
   Button remove;
   Button click;
   TextView TextRemove;
    public  static TextView data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

       // view.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY)
        click = (Button) findViewById(R.id.button2);
        data = (TextView) findViewById(R.id.fetchedata);
        remove=(Button)findViewById(R.id.button5);
        TextRemove=(TextView) findViewById(R.id.TextRemove);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchData process = new fetchData();
                process.execute();

            }
        });

    }
      //  listView=findViewById(R.id.listView);
       // adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
      //  listView.setAdapter(adapter);
      //  new Connection().execute();

    public void OnRemove(View view) {

        String remove = TextRemove.getText().toString();

        Remove backgroundWorker = new Remove(this);

        backgroundWorker.execute(remove);


    }
    }
