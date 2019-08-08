package com.example.dailycast;

/**
 *  Name: Fatuma Ingabire
 *  Student ID: S1719023
 * */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.dailycast.Fragments.FragmentAfterTomorrow;
import com.example.dailycast.Fragments.FragmentToday;
import com.example.dailycast.UI.ViewPagerAdapter;


public class LocationActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout; //TODO: check if you really need this
    private ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        //adding Fragments
        adapter.addFragment(new FragmentToday(), "Today"); //TODO: change this to dynamic data
        adapter.addFragment(new FragmentAfterTomorrow(), "Tomorrow");
        adapter.addFragment(new FragmentAfterTomorrow(), "After Tomorrow");

        //Setting up the adapter
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        getIncomingIntent();

    }

    private void getIncomingIntent(){

        if(getIntent().hasExtra("singleLocationData")){

//            ArrayList<Weather> singleLocationWeather = (ArrayList<Weather>) getIntent().getSerializableExtra("singleLocationData");
//            System.out.println("TESTINGGGGGGGGGGGGGGGGGGGGGGGGGG");
//            System.out.println(singleLocationWeather.get(0).toString());

//            setWeatherData(singleLocationWeather);
        }

    }

//    private void setWeatherData(ArrayList<Weather> locationWeatherData){
//
//        TextView location1 = findViewById(R.id.tab_locationView1);
//        TextView location2 = findViewById(R.id.tab_locationView2);
//        TextView location3 = findViewById(R.id.tab_locationView3);
//
//        location1.setText(locationWeatherData.get(0).getLocation());
//        location2.setText(locationWeatherData.get(1).getLocation());
//        location3.setText(locationWeatherData.get(2).getLocation());
//
//        TextView date1 = findViewById(R.id.tab_date1);
//        TextView date2 = findViewById(R.id.tab_date2);
//        TextView date3 = findViewById(R.id.tab_date3);
//
//        date1.setText(locationWeatherData.get(0).getDate());
//        date2.setText(locationWeatherData.get(1).getDate());
//        date3.setText(locationWeatherData.get(2).getDate());
//
//        TextView maxTemp1 = findViewById(R.id.tab_maxTemp1);
//        TextView maxTemp2 = findViewById(R.id.tab_maxTemp2);
//        TextView maxTemp3 = findViewById(R.id.tab_maxTemp3);
//
//        maxTemp1.setText(locationWeatherData.get(0).getMaxTemp());
//        maxTemp2.setText(locationWeatherData.get(1).getMaxTemp());
//        maxTemp3.setText(locationWeatherData.get(2).getMaxTemp());
//
//        TextView rainProb1 = findViewById(R.id.tab_rainProb1);
//        TextView rainProb2 = findViewById(R.id.tab_rainProb2);
//        TextView rainProb3 = findViewById(R.id.tab_rainProb3);
//
//        rainProb1.setText(locationWeatherData.get(0).getRainProbability());
//        rainProb2.setText(locationWeatherData.get(1).getRainProbability());
//        rainProb3.setText(locationWeatherData.get(3).getRainProbability());
//
//        TextView maxTempValue1 = findViewById(R.id.tab_maxTempValue1);
//        TextView maxTempValue2 = findViewById(R.id.tab_maxTempValue2);
//        TextView maxTempValue3 = findViewById(R.id.tab_maxTempValue3);
//
//        maxTempValue1.setText(locationWeatherData.get(0).getMaxTemp());
//        maxTempValue2.setText(locationWeatherData.get(1).getMaxTemp());
//        maxTempValue3.setText(locationWeatherData.get(2).getMaxTemp());
//
//        TextView minTempValue1 = findViewById(R.id.tab_minTempValue1);
//        TextView minTempValue2 = findViewById(R.id.tab_minTempValue2);
//        TextView minTempValue3 = findViewById(R.id.tab_minTempValue3);
//
//        minTempValue1.setText(locationWeatherData.get(0).getMinTemp());
//        minTempValue2.setText(locationWeatherData.get(1).getMinTemp());
//        minTempValue3.setText(locationWeatherData.get(2).getMinTemp());
//
//        TextView pressure1 = findViewById(R.id.tab_pressureValue1);
//        TextView pressure2 = findViewById(R.id.tab_pressureValue2);
//        TextView pressure3 = findViewById(R.id.tab_pressureValue3);
//
//        pressure1.setText(locationWeatherData.get(0).getPressure());
//        pressure2.setText(locationWeatherData.get(1).getPressure());
//        pressure3.setText(locationWeatherData.get(2).getPressure());
//
//        TextView humidity1 = findViewById(R.id.tab_humidityValue1);
//        TextView humidity2 = findViewById(R.id.tab_humidityValue2);
//        TextView humidity3 = findViewById(R.id.tab_humidityValue3);
//
//        humidity1.setText(locationWeatherData.get(0).getHumidity());
//        humidity2.setText(locationWeatherData.get(1).getHumidity());
//        humidity3.setText(locationWeatherData.get(3).getHumidity());
//
//
//    }
}
