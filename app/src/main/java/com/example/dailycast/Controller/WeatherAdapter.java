package com.example.dailycast.Controller;
/**
 *  Name: Fatuma Ingabire
 *  Student ID: S1719023
 * */

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dailycast.Model.Weather;
import com.example.dailycast.Views.WeatherCondition;
import com.example.dailycast.Views.LocationActivity;
import com.example.dailycast.R;

import java.util.ArrayList;
import java.util.HashMap;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>{

    private final HashMap<String,ArrayList<Weather>> weatherStorage;
    private LayoutInflater inflater;
    private Context c;


    public WeatherAdapter(Context c, HashMap<String,ArrayList<Weather>> weatherStorage) {
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
        //Location is the key in our HashMap
        final ArrayList<String> locations = new ArrayList<>(weatherStorage.keySet());

        //Looping through the keys to get the values
        //Assigning the values to an ArrayList
        String key = locations.get(position);
        final ArrayList<Weather> weatherList = weatherStorage.get(key);

        //getting weather data from the ArrayList values
        final Weather weather = weatherList.get(0);


        holder.countryView.setText(weather.getCountry());
        holder.maxTempView.setText(weather.getMaxTemp());
        holder.cityView.setText(weather.getCity());
        holder.rainProbView.setText(weather.getRainProbability());
        holder.iconView.setImageResource(WeatherCondition.getWeatherCondition(weather.getRainProbability(), weather.getDay()));


        holder.parentLayout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
            Toast.makeText(c,weather.getCity(),Toast.LENGTH_SHORT).show();

            //sending the key which is our data
            Intent intent = new Intent(c, LocationActivity.class);
            intent.putExtra("city",weather.getCity());
            intent.putExtra("WeatherObject1", weatherList.get(0));
            intent.putExtra("WeatherObject2", weatherList.get(1));
            intent.putExtra("WeatherObject3", weatherList.get(2));

            c.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return weatherStorage.size();
    }

    class WeatherViewHolder extends RecyclerView.ViewHolder{

        private TextView countryView, maxTempView,cityView, rainProbView;
        private LinearLayout parentLayout;
        final WeatherAdapter adapter;

        private ImageView iconView;

        public WeatherViewHolder (final View itemView, WeatherAdapter adapter){
            super(itemView);

            countryView = itemView.findViewById(R.id.countryView);
            maxTempView = itemView.findViewById(R.id.maxTemp);
            cityView = itemView.findViewById(R.id.cityView);
            rainProbView = itemView.findViewById(R.id.rainProbView);

            parentLayout = itemView.findViewById(R.id.parentLayout);

            iconView = itemView.findViewById(R.id.weather_icon);
            iconView.getLayoutParams().width = 300;
            iconView.getLayoutParams().height = 300;
            iconView.setAdjustViewBounds(true);

            this.adapter = adapter;
        }
    }


}
