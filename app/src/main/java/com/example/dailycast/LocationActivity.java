package com.example.dailycast;

/**
 *  Name: Fatuma Ingabire
 *  Student ID: S1719023
 * */

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.dailycast.DataObject.Weather;
import com.example.dailycast.Fragments.FragmentDay1;
import com.example.dailycast.Fragments.FragmentDay2;
import com.example.dailycast.Fragments.FragmentDay3;
import com.example.dailycast.UI.ViewPagerAdapter;


public class LocationActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView textView;

    FragmentDay1 fragmentDay1 = new FragmentDay1();
    FragmentDay2 fragmentDay2 = new FragmentDay2();
    FragmentDay3 fragmentDay3 = new FragmentDay3();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        textView = findViewById(R.id.tab_locationView);


        Intent intent = getIntent();

        Weather weatherObj1 = intent.getExtras().getParcelable("WeatherObject1");
        Weather weatherObj2 = intent.getExtras().getParcelable("WeatherObject2");
        Weather weatherObj3 = intent.getExtras().getParcelable("WeatherObject3");

        String city = intent.getStringExtra("city");

        textView.setText(city);

        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = new Bundle();

        bundle.putParcelable("day1", weatherObj1);
        bundle2.putParcelable("day2", weatherObj2);
        bundle3.putParcelable("day3", weatherObj3);

        fragmentDay1.setArguments(bundle);
        fragmentDay2.setArguments(bundle2);
        fragmentDay3.setArguments(bundle3);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        //adding Fragments
        adapter.addFragment(fragmentDay1, weatherObj1.getDay());
        adapter.addFragment(fragmentDay2, weatherObj2.getDay());
        adapter.addFragment(fragmentDay3, weatherObj3.getDay());

        //Setting up the adapter
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


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

            Intent intent = new Intent(this, MainActivity.class);
            this.startActivity(intent);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
