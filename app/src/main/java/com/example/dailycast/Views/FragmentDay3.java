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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class FragmentDay3 extends Fragment {

    View view;
    TextView tabPressure, tabDate, maxTemp,rainProb,minTemp, humidity,
            sunset, sunrise, windDirection, windSpeed,visibility;

    ImageView weatherIcon, pressureIcon,minTempIcon, humidityIcon,
            sunsetIcon, sunriseIcon, windIcon, visibilityIcon;

    public FragmentDay3() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_day3,parent,false);

        tabPressure = view.findViewById(R.id.tab_pressureValue3);
        tabDate = view.findViewById(R.id.tab_date3);
        maxTemp = view.findViewById(R.id.tab_maxTemp3);
        rainProb = view.findViewById(R.id.tab_rainProb3);
        minTemp = view.findViewById(R.id.tab_minTempValue3);
        humidity = view.findViewById(R.id.tab_humidityValue3);

        sunset = view.findViewById(R.id.tab_sunsetValue3);
        sunrise = view.findViewById(R.id.tab_sunriseValue3);
        windDirection = view.findViewById(R.id.tab_windDir3);
        windSpeed = view.findViewById(R.id.tab_windValue3);
        visibility = view.findViewById(R.id.tab_visibilityValue3);


        pressureIcon = view.findViewById(R.id.tab_pressureIcon3);
        minTempIcon = view.findViewById(R.id.tab_minTempIcon3);
        humidityIcon = view.findViewById(R.id.tab_humidityIcon3);
        sunsetIcon = view.findViewById(R.id.tab_sunsetIcon3);
        sunriseIcon = view.findViewById(R.id.tab_sunriseIcon3);
        windIcon = view.findViewById(R.id.tab_windIcon3);
        visibilityIcon = view.findViewById(R.id.tab_visibilityIcon3);

        weatherIcon = view.findViewById(R.id.tab_weatherIcon3);

        //getting argument bundle
        Weather weather = getArguments().getParcelable("day3");

        try {

            String updatedDate = createDate(weather.getDate());
            tabDate.setText(updatedDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }

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

        tabPressure.setText(weather.getPressure());
        maxTemp.setText(weather.getMaxTemp());
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
        cal.add(Calendar.DATE,2);

        date = dateFormat.format(cal.getTime());

        return date;
    }
}
