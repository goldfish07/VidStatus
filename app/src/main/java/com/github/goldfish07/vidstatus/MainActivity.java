package com.github.goldfish07.vidstatus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.goldfish07.vidstatus.model.Msg;
import com.github.goldfish07.vidstatus.model.Vid;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String JSON = "http://fatema.takatakind.com/app_api/index.php?p=showAllVideos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //largeLog("response",response);
                startJsonParse(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
        requestQueue.start();
    }

    public void startJsonParse(String response) {

        Gson gson = new Gson();
        Vid msg = gson.fromJson(response, Vid.class);
        Log.e("msg", msg.getMsg().get(0).getVideo());
    }
}