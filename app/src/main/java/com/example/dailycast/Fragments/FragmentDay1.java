package com.example.dailycast.Fragments;

/**
 *  Name: Fatuma Ingabire
 *  Student ID: S1719023
 * */

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dailycast.DataObject.Weather;
import com.example.dailycast.DataObject.WeatherCondition;
import com.example.dailycast.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FragmentDay1 extends Fragment {

    View view;
    TextView tabPressure, tabLocation, tabDate, maxTemp, maxTempValue,rainProb,minTemp, humidity;
    ImageView weatherIcon;


    public FragmentDay1() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_day1,parent,false);

        tabPressure = view.findViewById(R.id.tab_pressureValue1);
        tabLocation = view.findViewById(R.id.tab_locationView1);
        tabDate = view.findViewById(R.id.tab_date1);
        maxTemp = view.findViewById(R.id.tab_maxTemp1);
        maxTempValue = view.findViewById(R.id.tab_maxTempValue1);
        rainProb = view.findViewById(R.id.tab_rainProb1);
        minTemp = view.findViewById(R.id.tab_minTempValue1);
        humidity = view.findViewById(R.id.tab_humidityValue1);

        weatherIcon = view.findViewById(R.id.tab_weatherIcon1);

        //getting argument bundle
        Weather weather = getArguments().getParcelable("day1");

        tabDate.setText(weather.getDate());
        tabLocation.setText(weather.getCity());
        tabPressure.setText(weather.getPressure());
        maxTemp.setText(weather.getMaxTemp());
        maxTempValue.setText(weather.getMaxTemp());
        rainProb.setText(weather.getRainProbability());
        minTemp.setText(weather.getMinTemp());
        humidity.setText(weather.getHumidity());

        int imgId = WeatherCondition.getWeatherCondition(weather.getRainProbability(),weather.getDay());
        weatherIcon.setImageResource(imgId);

        return view;
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
