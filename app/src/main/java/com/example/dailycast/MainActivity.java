package com.example.dailycast;

/**
 *  Name: Fatuma Ingabire
 *  Student ID: S1719023
 * */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.dailycast.DataObject.Weather;
import com.example.dailycast.RSS.PullParser;
import com.example.dailycast.UI.WeatherAdapter;

import java.net.MalformedURLException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Weather> list = new ArrayList<>();
    private WeatherAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing the RecyclerView
        recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setHasFixedSize(true); //TODO: check if you really need this

        try {
            new PullParser(MainActivity.this,recyclerView).execute();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
