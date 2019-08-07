package com.fatuma.gcuweather.UI;
/**
 *  Name: Fatuma Ingabire
 *  Student ID: S1719023
 * */

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.fatuma.gcuweather.DataObject.Weather;
import com.fatuma.gcuweather.R;
import com.fatuma.gcuweather.location_activity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> implements Serializable{

    private final LinkedHashMap<String,ArrayList<Weather>> weatherStorage;
    private LayoutInflater inflater;
    private Context c;


    public WeatherAdapter(Context c, LinkedHashMap<String,ArrayList<Weather>> weatherStorage) {
        this.c = c;
        inflater = LayoutInflater.from(c);
        this.weatherStorage = weatherStorage;
    }

    @NonNull
    @Override
    public WeatherAdapter.WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {

        View itemView = inflater.inflate(R.layout.layout_weather_object, parent,false);
        return new WeatherViewHolder(itemView,this);

    }

    @Override
    public void onBindViewHolder(@NonNull WeatherAdapter.WeatherViewHolder holder, final int position) {


        //Creating a List of the keys
        //Location is the key in our LinkedHashMap
        final ArrayList<String> locations = new ArrayList<>(weatherStorage.keySet());

        //Looping through the keys to get the values
        //Assigning the values to an ArrayList
        String key = locations.get(position);
        final ArrayList<Weather> weatherList = weatherStorage.get(key);

        //getting weather data from the ArrayList values
        final Weather weather = weatherList.get(position);

        holder.countryView.setText(getCountry(weather.getLocation())); //TODO: find a way to change this to the country
        holder.maxTempView.setText(weather.getMaxTemp());
        holder.cityView.setText(weather.getLocation());
        holder.rainProbView.setText(weather.getRainProbability());

        //TODO: Add an switch or if statement checking the rain probability and assigning it to the right icon.
        //TODO: You will need to add icons to the drawable folder
        //TODO: Basic Syntax: holder.[NameOfView].setImageResource(R.drawable.[NameOfIcon])

        holder.parentLayout.setOnClickListener(new View.OnClickListener(){

            Bundle bundle = new Bundle();

            @Override
            public void onClick(View v) {
                Toast.makeText(c,weather.getLocation(),Toast.LENGTH_SHORT).show();


                for(int i = 0; i < weatherList.size(); i++){

                    //TODO: Figure out how to get data.
                    //sending the key which is the of our data
                    Intent intent = new Intent(c,location_activity.class);
                    intent.putExtra("location",weather.getLocation());
                    c.startActivity(intent);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return weatherStorage.size();
    }

    private String getCountry(String city){

        switch(city){
            case "Dhaka":
                return "Bangladesh";
            case "Kigali":
                return "Rwanda";
            case "Oman":
                return  "Muscat";
            case "Glasgow":
                return "Scotland";
            case "London":
                return "United Kingdom";
            case "New York":
                return "USA";
            case "Port Louis":
                return "Mauritius";
        }

        return null;
    }

    class WeatherViewHolder extends RecyclerView.ViewHolder{

        private TextView countryView, maxTempView,cityView, rainProbView;
        private LinearLayout parentLayout;
        final WeatherAdapter adapter;

        public WeatherViewHolder (final View itemView, WeatherAdapter adapter){
            super(itemView);

            countryView = itemView.findViewById(R.id.countryView);
            maxTempView = itemView.findViewById(R.id.maxTemp);
            cityView = itemView.findViewById(R.id.cityView);
            rainProbView = itemView.findViewById(R.id.rainProbView);

            parentLayout = itemView.findViewById(R.id.parentLayout);

            this.adapter = adapter;
        }
    }
}