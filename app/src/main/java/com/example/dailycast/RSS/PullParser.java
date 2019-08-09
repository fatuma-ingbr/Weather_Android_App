package com.example.dailycast.RSS;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.dailycast.DataObject.Weather;
import com.example.dailycast.UI.WeatherAdapter;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class PullParser extends AsyncTask<Integer, Void, HashMap<String, ArrayList<Weather>>> {

    private Context c;
    private final String baseUrl = "https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/";

    private URL url;
    WeatherAdapter adapter;

    RecyclerView recyclerView;

    HashMap<String, ArrayList<Weather>> allLocationsData = new HashMap<>();

    //constructor that takes context, and location code
    public PullParser(Context c, View view) {
        this.c = c;
        this.recyclerView = (RecyclerView) view;

    }


    @Override
    protected HashMap<String, ArrayList<Weather>> doInBackground(Integer... integers) {

        ArrayList<String> locationCodes = new ArrayList<>();

        locationCodes.add("1185241");//Bangladesh
        locationCodes.add("202061");//Rwanda
        locationCodes.add("5128581");//USA
        locationCodes.add("287286");//Oman
        locationCodes.add("934154");//Mauritius
        locationCodes.add("2648579");//Scotland
        locationCodes.add("2643743");//United Kingdom

        for(int i = 0; i < locationCodes.size(); i++){

            ArrayList<Weather> singleLocationWeatherObjects = new ArrayList<>();

            String code = locationCodes.get(i);

            try{

                url = new URL(baseUrl+ code);
                //Creating XmlPullParser factory that will create XmlPullParser(s)...
                // ...that will retrieve data from Xml document
                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();

                //Specify whether the parser will provide namespace support.
                factory.setNamespaceAware(false);

                //Creating a PullParser object
                XmlPullParser xpp = factory.newPullParser();

                xpp.setInput(ConnectService.getInputStream(url),"UTF-8");

                int eventType = xpp.getEventType();

                boolean insideItem = false;
                Weather weather = null;

                while(eventType != XmlPullParser.END_DOCUMENT && !insideItem){
                    switch(eventType){
                        case XmlPullParser.START_DOCUMENT:
                            break;
                        case XmlPullParser.START_TAG:
                            if(xpp.getName().equalsIgnoreCase("item")){
                                weather = new Weather();
                            }else if(weather != null){
                                if(xpp.getName().equalsIgnoreCase("title")){
                                    weather.setTitle(xpp.nextText());
                                }else if(xpp.getName().equalsIgnoreCase("description")){
                                    weather.setDesc(xpp.nextText());
                                }else if(xpp.getName().equalsIgnoreCase("pubDate")){
                                    String date = xpp.nextText().substring(0, 16);
                                    weather.setDate(date);
                                }
                            }
                            break;
                        case XmlPullParser.END_TAG:
                            if(xpp.getName().equalsIgnoreCase("item") && weather != null){
                                singleLocationWeatherObjects.add(weather);
                            }else if(xpp.getName().equalsIgnoreCase("channel")){
                                insideItem = true;
                            }
                            break;
                    }
                    eventType = xpp.next();
                }


            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            allLocationsData.put(getCity(code),singleLocationWeatherObjects);
        }

        return allLocationsData;
    }

    @Override
    protected void onPostExecute(HashMap<String, ArrayList<Weather>> hashMap) {
        super.onPostExecute(hashMap);

        HashMap<String, ArrayList<Weather>> toSend = new HashMap<>();
        String city;

        for(String key : hashMap.keySet()){
            city = key;
            ArrayList<Weather> arrayList = hashMap.get(city);

            for(int i = 0; i < arrayList.size(); i++){

                Weather weather = arrayList.get(i);
                weather.splitStrings(weather.getTitle(),weather.getDesc(),city);
            }

            toSend.put(city,arrayList);
        }

        adapter = new WeatherAdapter(c,toSend);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(c));

    }

    private String getCity(String  code){

        switch(code){
            case "1185241":
                return "Dhaka";
            case "202061":
                return "Kigali";
            case "287286":
                return  "Muscat";
            case "2648579":
                return "Glasgow";
            case "2643743":
                return "London";
            case "5128581":
                return "New York";
            case "934154":
                return "Port Louis";
        }

        return null;
    }


}
