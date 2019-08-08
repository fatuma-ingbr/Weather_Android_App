package com.example.dailycast.DataObject;

/**
 *  Name: Fatuma Ingabire
 *  Student ID: S1719023
 * */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class WeatherObjectService {

    static final char COMMA_DELIMITER =',';
    static final char COLON_DELIMITER = ':';

    ArrayList<Weather> weatherStorage = new ArrayList<>();

    public ArrayList<Weather> createWeatherObject(ArrayList<String> titleTagData, ArrayList<String> descTagDAta, String date, String location) throws ParseException {

        String[] tmpComma;
        String[] tmpColon;
        Weather weather = new Weather();

        /**
         * Extracting weather data from the Title tag data
         * */
        for(String item : titleTagData) {

            //splitting the original string
            tmpComma = item.split(Character.toString(COMMA_DELIMITER));

            //we only need the first items i.e. day & Rain probability
            tmpColon = tmpComma[0].split(Character.toString(COLON_DELIMITER));

            //getting Values
            String day = tmpColon[0];
            String rainProbability = tmpColon[1];
            weather.setDay(day);
            weather.setRainProbability(rainProbability);
            weatherStorage.add(weather);

        }

        /**
         * Extracting weather data from the Description tag data
         * */

        int counter = 0;

        for(String item: descTagDAta){

            Weather w = weatherStorage.get(counter);
            tmpComma = item.split(Character.toString(COMMA_DELIMITER));

            w.setLocation(location);

            for(int i = 0; i < tmpComma.length; i++){

                tmpColon = tmpComma[i].split(Character.toString(COLON_DELIMITER));

                if(i == 0){
                    String maxTemp = tmpColon[1].substring(0,5);
                    w.setMaxTemp(maxTemp);
                    weatherStorage.add(w);
                }else if(i == 1){
                    String minTemp = tmpColon[1].substring(0,5);
                    w.setMinTemp(minTemp);
                    weatherStorage.add(w);
                }else if(i == 5){
                    String pressure = tmpColon[1];
                    w.setPressure(pressure);
                    weatherStorage.add(w);
                }else if(i == 6){
                    String humidity = tmpColon[1];
                    w.setHumidity(humidity);
                    weatherStorage.add(w);
                }
            }
            counter++;
        }

        //setting Date object
        weatherStorage.get(0).setDate(date);

        //TODO: increment the dates
//        weatherStorage.get(1).setDate(createDate(date));
//        weatherStorage.get(2).setDate(createDate(createDate(date)));


        return weatherStorage;

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
