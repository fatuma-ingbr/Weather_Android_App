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

    //TODO: Finish up styling the fragments views
    //TODO: implement an appBarLayout move the city data there. Part of part 1
    //TODO: Revise the date so that the date change as you switch tabs
    //TODO: implement the horizontal orientation
    //TODO: Implement user navigation through the views
    //TODO: Implement an update intervals - defaults 8am & 8pm (20:00hrs)
    //TODO: Restructure the folders to MVC
    //TODO: Write test report
    //TODO: Record with screen-o-matic


}
