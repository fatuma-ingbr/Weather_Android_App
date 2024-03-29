package com.example.dailycast.Views;

/**
 *  Name: Fatuma Ingabire
 *  Student ID: S1719023
 * */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.dailycast.R;
import com.example.dailycast.Controller.PullParser;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing the RecyclerView
        recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setHasFixedSize(true);

        new PullParser(MainActivity.this,recyclerView).execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.refresh) {
            Intent intent = new Intent(this, TimeActivity.class);
            this.startActivity(intent);

            return true;

        }else if (item.getItemId() == R.id.list_all) {
            Toast.makeText(this, "This is the page.", Toast.LENGTH_SHORT)
                    .show();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
