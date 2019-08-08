package com.example.dailycast;

/**
 *  Name: Fatuma Ingabire
 *  Student ID: S1719023
 * */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.dailycast.DataObject.Weather;
import com.example.dailycast.RSS.RSSParser;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HashMap<String, ArrayList<Weather>> locationWeatherStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setHasFixedSize(true); //TODO: check if you really need this
        new RSSParser(MainActivity.this, recyclerView).execute();

    }

    //TODO: Link data to the location layouts.
    //TODO:
    //TODO:

    public void callBack(HashMap<String, ArrayList<Weather>> locationWeatherStorage){
        this.locationWeatherStorage = locationWeatherStorage;
    }

}
