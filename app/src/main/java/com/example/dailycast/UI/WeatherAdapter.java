package com.example.dailycast.UI;

/**
 *  Name: Fatuma Ingabire
 *  Student ID: S1719023
 * */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dailycast.DataObject.Weather;
import com.example.dailycast.R;

import java.util.ArrayList;
import java.util.HashMap;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>{

    private final HashMap<String,ArrayList<Weather>> weatherStorage;
    //private final ArrayList<Weather> weatherStorage;
    private LayoutInflater inflater;
    private Context c;


    public WeatherAdapter(Context c, HashMap<String,ArrayList<Weather>> hashMap) {
    //public WeatherAdapter(Context c, ArrayList<Weather> weatherStorage) {
        this.c = c;
        inflater = LayoutInflater.from(c);
        this.weatherStorage = hashMap;
    }

    @NonNull
    @Override
    public WeatherAdapter.WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {

        View itemView = inflater.inflate(R.layout.layout_weather_object, parent,false);
        return new WeatherViewHolder(itemView,this);

    }

    @Override
    public void onBindViewHolder(@NonNull WeatherAdapter.WeatherViewHolder holder, final int position) {
        
        ArrayList<Weather> arrayList = weatherStorage.get(position);
        final Weather weather = arrayList.get(0);

        holder.countryView.setText(weather.getCountry());
        holder.maxTempView.setText(weather.getMaxTemp());
        holder.cityView.setText(weather.getCity());
        holder.rainProbView.setText(weather.getRainProbability());

        //TODO: Add an switch or if statement checking the rain probability and assigning it to the right icon.
        //TODO: You will need to add icons to the drawable folder
        //TODO: Basic Syntax: holder.[NameOfView].setImageResource(R.drawable.[NameOfIcon])

        holder.parentLayout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(c,weather.getCity(),Toast.LENGTH_SHORT).show();

                //TODO: if/else

//
//                    //TODO: Figure out how to get data.
//                    //sending the key which is the of our data
//                    Intent intent = new Intent(c, LocationActivity.class);
//                    intent.putExtra("city",weather.getCity());
//                    intent.putExtra("WeatherObject1", weatherList.get(0));
//                    intent.putExtra("WeatherObject2", weatherList.get(1));
//                    intent.putExtra("WeatherObject3", weatherList.get(2));
//
//                    c.startActivity(intent);

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
