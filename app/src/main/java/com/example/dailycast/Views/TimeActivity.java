package com.example.dailycast.Views;
/**
 *  Name: Fatuma Ingabire
 *  Student ID: S1719023
 * */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.dailycast.R;
import java.util.Calendar;

public class TimeActivity extends AppCompatActivity {

    private TimePicker timePicker1;
    private TimePicker timePicker2;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        timePicker1 = findViewById(R.id.timePicker1);
        timePicker2 = findViewById(R.id.timePicker2);
        button = findViewById(R.id.button);

        int hr = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int min = Calendar.getInstance().get(Calendar.MINUTE);
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
            Toast.makeText(this, "This is the page.", Toast.LENGTH_SHORT)
                    .show();

            return true;

        } else if (item.getItemId() == R.id.list_all) {

            Intent intent = new Intent(this, MainActivity.class);
            this.startActivity(intent);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void saveTime(View view) {
        Toast.makeText(this, "Time saved.", Toast.LENGTH_SHORT)
                .show();

        int morningHr = timePicker1.getHour();
        int morningMin = timePicker1.getMinute();

        int eveHr = timePicker2.getHour();
        int eveMin = timePicker2.getMinute();

    }

}
