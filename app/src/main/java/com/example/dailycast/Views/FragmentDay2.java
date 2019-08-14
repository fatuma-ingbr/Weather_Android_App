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

public class FragmentDay2 extends Fragment {

    View view;
    TextView tabPressure, tabDate, maxTemp,rainProb,minTemp, humidity,
            sunset, sunrise, windDirection, windSpeed,visibility;

    ImageView weatherIcon, pressureIcon,minTempIcon, humidityIcon,
            sunsetIcon, sunriseIcon, windIcon, visibilityIcon;

    public FragmentDay2() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_day2,parent,false);

        tabPressure = view.findViewById(R.id.tab_pressureValue2);
        tabDate = view.findViewById(R.id.tab_date2);
        maxTemp = view.findViewById(R.id.tab_maxTemp2);
        rainProb = view.findViewById(R.id.tab_rainProb2);
        minTemp = view.findViewById(R.id.tab_minTempValue2);
        humidity = view.findViewById(R.id.tab_humidityValue2);

        sunset = view.findViewById(R.id.tab_sunsetValue2);
        sunrise = view.findViewById(R.id.tab_sunriseValue2);
        windDirection = view.findViewById(R.id.tab_windDir2);
        windSpeed = view.findViewById(R.id.tab_windValue2);
        visibility = view.findViewById(R.id.tab_visibilityValue2);


        pressureIcon = view.findViewById(R.id.tab_pressureIcon2);
        minTempIcon = view.findViewById(R.id.tab_minTempIcon2);
        humidityIcon = view.findViewById(R.id.tab_humidityIcon2);
        sunsetIcon = view.findViewById(R.id.tab_sunsetIcon2);
        sunriseIcon = view.findViewById(R.id.tab_sunriseIcon2);
        windIcon = view.findViewById(R.id.tab_windIcon2);
        visibilityIcon = view.findViewById(R.id.tab_visibilityIcon2);

        weatherIcon = view.findViewById(R.id.tab_weatherIcon2);


        //getting argument bundle
        Weather weather = getArguments().getParcelable("day2");

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


        tabPressure.setText(weather.getPressure());
        maxTemp.setText(weather.getMaxTemp());
        rainProb.setText(weather.getRainProbability());
        minTemp.setText(weather.getMinTemp());
        humidity.setText(weather.getHumidity());

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
