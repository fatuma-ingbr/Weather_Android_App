package com.example.dailycast;

/**
 *  Name: Fatuma Ingabire
 *  Student ID: S1719023
 * */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.dailycast.RSS.PullParser;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing the RecyclerView
        recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setHasFixedSize(true); //TODO: check if you really need this

        new PullParser(MainActivity.this,recyclerView).execute();
    }

}
