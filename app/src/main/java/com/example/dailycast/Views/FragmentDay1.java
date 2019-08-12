package com.example.dailycast.Views;

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

import com.example.dailycast.Model.Weather;
import com.example.dailycast.R;

public class FragmentDay1 extends Fragment {

    View view;
    TextView tabPressure, tabDate, maxTemp,rainProb,minTemp, humidity,
            sunset, sunrise, windDirection, windSpeed,visibility;

    ImageView weatherIcon, pressureIcon,minTempIcon, humidityIcon,
            sunsetIcon, sunriseIcon, windIcon, visibilityIcon;


    public FragmentDay1() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_day1,parent,false);

        tabPressure = view.findViewById(R.id.tab_pressureValue1);

        tabDate = view.findViewById(R.id.tab_date1);
        maxTemp = view.findViewById(R.id.tab_maxTemp1);
        rainProb = view.findViewById(R.id.tab_rainProb1);
        minTemp = view.findViewById(R.id.tab_minTempValue1);
        humidity = view.findViewById(R.id.tab_humidityValue1);

        sunset = view.findViewById(R.id.tab_sunsetValue1);
        sunrise = view.findViewById(R.id.tab_sunriseValue1);
        windDirection = view.findViewById(R.id.tab_windDir1);
        windSpeed = view.findViewById(R.id.tab_windValue1);
        visibility = view.findViewById(R.id.tab_visibilityValue1);


        pressureIcon = view.findViewById(R.id.tab_pressureIcon1);
        minTempIcon = view.findViewById(R.id.tab_minTempIcon1);
        humidityIcon = view.findViewById(R.id.tab_humidityIcon1);
        sunsetIcon = view.findViewById(R.id.tab_sunsetIcon1);
        sunriseIcon = view.findViewById(R.id.tab_sunriseIcon1);
        windIcon = view.findViewById(R.id.tab_windIcon1);
        visibilityIcon = view.findViewById(R.id.tab_visibilityIcon1);

        weatherIcon = view.findViewById(R.id.tab_weatherIcon1);


        //getting argument bundle
        Weather weather = getArguments().getParcelable("day1");

        tabDate.setText(weather.getDate());
        tabPressure.setText(weather.getPressure());
        maxTemp.setText(weather.getMaxTemp());
        rainProb.setText(weather.getRainProbability());
        minTemp.setText(weather.getMinTemp());
        humidity.setText(weather.getHumidity());

        sunset.setText(weather.getSunset());
        sunrise.setText(weather.getSunrise());
        windDirection.setText(weather.getWindDirection());
        windSpeed.setText(weather.getWindSpeed());
        visibility.setText(weather.getVisibility());

        pressureIcon.setImageResource(R.drawable.pressure);
        minTempIcon.setImageResource(R.drawable.mintemp);
        humidityIcon.setImageResource(R.drawable.humidity);
        sunsetIcon.setImageResource(R.drawable.sunset);
        sunriseIcon.setImageResource(R.drawable.sunrise);
        windIcon.setImageResource(R.drawable.wind);
        visibilityIcon.setImageResource(R.drawable.visibility);

        int imgId = WeatherCondition.getWeatherCondition(weather.getRainProbability(),weather.getDay());
        weatherIcon.setImageResource(imgId);

        return view;
    }

}
