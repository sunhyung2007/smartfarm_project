package com.example.farm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    TextView outputATEMP, outputAHUM, outputGHUM;
    Button selectPotButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        selectPotButton = (Button)findViewById(R.id.selectPotButton);
        outputATEMP = (TextView)findViewById(R.id.outputATEMP);
        outputAHUM = (TextView)findViewById(R.id.outputAHUM);
        outputGHUM = (TextView)findViewById(R.id.outputGHUM);


        String url = "http://dbgus1006.ivyro.net/Detail.php";
        selectDatabase selectDatabase = new selectDatabase(url, null);
        selectDatabase.execute();


    }

    class selectDatabase extends AsyncTask<Void, Void, String> {
        private String url1;
        private ContentValues values1;
        String result1;

        public selectDatabase(String url, ContentValues contentValues) {
            this.url1 = url;
            this.values1 = contentValues;
        }

        @Override
        protected String doInBackground(Void... params) {
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result1 = requestHttpURLConnection.request(url1, values1);
            return result1;
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            doJSONParser(s);
        }
    }

    public void doJSONParser(String string) {
        try {
            JSONObject jsonObject = new JSONObject(string);
            JSONArray jsonArray = jsonObject.getJSONArray("POT");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject output = jsonArray.getJSONObject(i);

                outputGHUM.setText(output.getString("potGHUM"));
                outputATEMP.setText(output.getString("potATEMP"));
                outputAHUM.setText(output.getString("potAHUM"));

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }




}
