package com.github.goldfish07.vidstatus;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.goldfish07.vidstatus.adapter.VidAdapter;
import com.github.goldfish07.vidstatus.model.Msg;
import com.github.goldfish07.vidstatus.model.Vid;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String JSON = "http://fatema.takatakind.com/app_api/index.php?p=showAllVideos";
    ViewPager2 viewPager2;
    VidAdapter vidAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager2 = findViewById(R.id.recyclerView);
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
        Vid vid = gson.fromJson(response, Vid.class);
        String url = vid.getMsg().get(0).getVideo();
        int length = vid.getMsg().size();
        Log.e("msg", String.valueOf(length));

        List<Msg> msgs = vid.getMsg();

        vidAdapter = new VidAdapter(this, msgs);
        viewPager2.setAdapter(vidAdapter);
//        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
//            @SuppressLint("NotifyDataSetChanged")
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
//                if (position != 0) {
//                    vidAdapter.onPause();
//                  //  vidAdapter.update(msgList[0], position);
//                 //   Log.e("onPageScrolled", String.valueOf(position));
//                }
//            }
//
//            @SuppressLint("NotifyDataSetChanged")
//            @Override
//            public void onPageSelected(int position) {
//                super.onPageSelected(position);
//               // msgList[0] = msgs;
//              //  vidAdapter.update(msgList[0], position);
//               // Log.e("onPageSelected", String.valueOf(position));
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//                super.onPageScrollStateChanged(state);
//            }
//        });

    }


    @Override
    protected void onPause() {
        super.onPause();
        if(vidAdapter!=null)
            vidAdapter.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(vidAdapter!=null)
        vidAdapter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(vidAdapter!=null)
            vidAdapter.onStop();
    }
}