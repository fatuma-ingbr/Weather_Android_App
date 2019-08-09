package com.example.dailycast.DataObject;

import com.example.dailycast.R;

public class WeatherCondition {


    public static int getWeatherCondition(String rainProbability, String day) {


        if (day.equals("Tonight")) {

            switch (rainProbability) {
                case " Clear Sky":
                    return R.drawable.clearsky;
                case " Drizzle":
                    return R.drawable.drizzle;
                case " Grey Cloud":
                    return R.drawable.cloud;
                case " Heavy Rain":
                    return R.drawable.rain;
                case " Heavy Rain Showers":
                    return R.drawable.rain;
                case " Light Cloud":
                    return R.drawable.cloudy;
                case " Light Rain":
                    return R.drawable.rain;
                case " Light Snow":
                    return R.drawable.snow;
                case " Partly Cloudy":
                    return R.drawable.partlycloudynight;
                case " Thunderstorm":
                    return R.drawable.thunderstorm;
                case " Thundery Showers":
                    return R.drawable.thundery;
                default:
                    return R.drawable.cloud;

            }
        } else {
            switch (rainProbability) {

                case " Drizzle":
                    return R.drawable.drizzle;
                case " Heavy Rain":
                    return R.drawable.rain;
                case " Heavy Rain Showers":
                    return R.drawable.rain;
                case " Light Cloud":
                    return R.drawable.cloudy;
                case " Light Rain":
                    return R.drawable.rain;
                case " Light Snow":
                    return R.drawable.snow;
                case " Sunny":
                    return R.drawable.sunny;
                case " Sunny Intervals":
                    return R.drawable.sunnyintervals;
                case " Thunderstorm":
                    return R.drawable.thunderstorm;
                case " Thundery Showers":
                    return R.drawable.thundery;
                default:
                    return R.drawable.sunnyintervals;

            }
        }
    }
}