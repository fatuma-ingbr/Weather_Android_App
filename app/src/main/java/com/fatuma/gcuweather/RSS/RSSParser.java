package com.fatuma.gcuweather.RSS;

/**
 *  Name: Fatuma Ingabire
 *  Student ID: S1719023
 * */

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fatuma.gcuweather.DataObject.Weather;
import com.fatuma.gcuweather.DataObject.WeatherObjectService;
import com.fatuma.gcuweather.MainActivity;
import com.fatuma.gcuweather.UI.WeatherAdapter;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class RSSParser extends AsyncTask<Integer, Void, LinkedHashMap<String,ArrayList<Weather>>>{

    private Context c;
    private URL url;
    private String location;
    private RecyclerView recyclerView;
    private WeatherAdapter adapter;


    private ArrayList<String> titles = new ArrayList<>();
    private ArrayList<String> decs = new ArrayList<>();
    private String date = "";

    //Storage for weather data for a single location
    private ArrayList<Weather> locationWeatherObject;
    private WeatherObjectService serviceObject;

    //Strong for weather objects for all locations
    LinkedHashMap<String, ArrayList<Weather>> allLocationsData;

    private HashMap<String, String> locations = new HashMap<>();

    private final String baseUrl = "https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/";


    private Exception exception = null;

    public RSSParser(Context c, RecyclerView recyclerView) {
        this.c = c;
        this.recyclerView = recyclerView;
    }

    @Override
    protected LinkedHashMap<String,ArrayList<Weather>> doInBackground(Integer... integers) {

        locations.put("Dhaka","1185241"); //Bangladesh
        locations.put("Kigali","202061"); // Rwanda
        locations.put("New York","5128581"); //USA
        locations.put("Muscat","287286"); //Oman
        locations.put("Port Louis","934154"); //Mauritius
        locations.put("Glasgow","2648579"); //Scotland
        locations.put("London","2643743"); //United Kingdom

        allLocationsData = new LinkedHashMap<>();

        for(HashMap.Entry<String,String > entry : locations.entrySet()) {


            try{

                url = new URL(baseUrl + entry.getValue());
                location = entry.getKey();

                //Creating XmlPullParser factory that will create XmlPullParser(s)...
                // ...that will retrieve data from Xml document
                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();

                //Specify whether the parser will provide namespace support.
                factory.setNamespaceAware(false);

                //Creating a PullParser object
                XmlPullParser xpp = factory.newPullParser();

                xpp.setInput(ConnectService.getInputStream(url),"UTF-8");

                boolean insideItem = false;

                //Returns the type of the current event...
                // ... i.e. Start tag, end tag, etc
                int eventType = xpp.getEventType();

                //While loop that reads data until end of xml document.
                while(eventType != XmlPullParser.END_DOCUMENT){
                    //If statement that checks if it is the start of a tag
                    if(eventType == XmlPullParser.START_TAG){
                        //check if the start tag is "item"
                        if(xpp.getName().equalsIgnoreCase("item")){
                            insideItem = true;

                        }else if(xpp.getName().equalsIgnoreCase("title")){
                            //Check if we are inside the item tag
                            if(insideItem){
                                titles.add(xpp.nextText());
                            }
                        }else if(xpp.getName().equalsIgnoreCase("description")){
                            if(insideItem){
                                decs.add(xpp.nextText());
                            }
                        }else if (xpp.getName().equalsIgnoreCase("pubDate")){
                            if(insideItem){
                                date = xpp.nextText().substring(0,16);
                            }
                        }
                    }else if(eventType == XmlPullParser.END_TAG && xpp.getName().equalsIgnoreCase("item")){
                        insideItem = false;
                    }

                    //incrementing to the next tag
                    eventType = xpp.next();
                }



            }catch (MalformedURLException e){
                exception = e;
            } catch(XmlPullParserException e){
                exception = e;
            }catch (IOException e){
                exception = e;
            }

            serviceObject = new WeatherObjectService();

            try {
                locationWeatherObject =  serviceObject.createWeatherObject(titles,decs,date,location);
            } catch (ParseException e) {
                exception = e;
            }

            allLocationsData.put(location,locationWeatherObject);

        }

        return allLocationsData;
    }

    @Override
    protected void onPostExecute(LinkedHashMap<String,ArrayList<Weather>> hashMap) {
        super.onPostExecute(hashMap);
//        MainActivity mainActivity = new MainActivity(); //TODO: check if you still need this
//        mainActivity.callBack(hashMap);

        adapter = new WeatherAdapter(c, allLocationsData);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(c));
    }

}
