package com.example.dailycast;

/**
 *  Name: Fatuma Ingabire
 *  Student ID: S1719023
 * */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.dailycast.Fragments.FragmentDay1;
import com.example.dailycast.Fragments.FragmentDay2;
import com.example.dailycast.Fragments.FragmentDay3;
import com.example.dailycast.UI.ViewPagerAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class LocationActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        //adding Fragments
        adapter.addFragment(new FragmentDay1(), "Today"); //TODO: change this to dynamic data
        adapter.addFragment(new FragmentDay2(), "Tomorrow");
        adapter.addFragment(new FragmentDay3(), "Day 3");

        //Setting up the adapter
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        getIncomingIntent();

    }

    private void getIncomingIntent(){

        if(getIntent().hasExtra("singleLocationData")){

        }

    }

    public String createDate(String stringDate) throws ParseException {
        //TODO: revise this method to properly increment the dates.
        String date;

        SimpleDateFormat dateFormat = new SimpleDateFormat("E, dd MMM yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateFormat.parse(stringDate));
        cal.add(Calendar.DATE,1);

        date = dateFormat.format(cal.getTime());

        return date;
    }

}
