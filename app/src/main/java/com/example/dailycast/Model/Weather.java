package com.example.dailycast.Model;
/**
 *  Name: Fatuma Ingabire
 *  Student ID: S1719023
 * */

import android.os.Parcel;
import android.os.Parcelable;

public class Weather implements Parcelable {
    private String date;
    private String title;
    private String desc;

    private String city;
    private String country;
    private String day;
    private String rainProbability;
    private String maxTemp;
    private String minTemp;
    private String pressure;
    private String humidity;

    private String windDirection;
    private String windSpeed;
    private String visibility;
    private String uvRisk;
    private String pollution;
    private String sunset;
    private String sunrise;



    //Constructor
    public Weather(){
    }

    public Weather(String pubDate, String title, String desc) {
        this.date = pubDate;
        this.title = title;
        this.desc = desc;
    }


    protected Weather(Parcel in) {
        city = in.readString();
        day = in.readString();
        rainProbability = in.readString();
        maxTemp = in.readString();
        minTemp = in.readString();
        pressure = in.readString();
        humidity = in.readString();
        date = in.readString();
        title = in.readString();
        desc = in.readString();
        windDirection = in.readString();
        windSpeed = in.readString();
        visibility = in.readString();
        uvRisk = in.readString();
        pollution = in.readString();
        sunset = in.readString();
        sunrise = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(city);
        dest.writeString(day);
        dest.writeString(rainProbability);
        dest.writeString(maxTemp);
        dest.writeString(minTemp);
        dest.writeString(pressure);
        dest.writeString(humidity);
        dest.writeString(date);
        dest.writeString(title);
        dest.writeString(desc);
        dest.writeString(windDirection);
        dest.writeString(windSpeed);
        dest.writeString(visibility);
        dest.writeString(uvRisk);
        dest.writeString(pollution);
        dest.writeString(sunset);
        dest.writeString(sunrise);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Weather> CREATOR = new Creator<Weather>() {
        @Override
        public Weather createFromParcel(Parcel in) {
            return new Weather(in);
        }

        @Override
        public Weather[] newArray(int size) {
            return new Weather[size];
        }
    };

    public void splitStrings(String titles, String descs, String city){

        desc = descs;
        title = titles;

        String[] splitDesc = desc.split(",");
        String[] splitTitle = title.split(",");

        this.city = city;
        country = getCountry(city);
        day = splitTitle[0].split(":")[0];
        rainProbability =splitTitle[0].split(":")[1];

        if(splitDesc.length == 9){
            maxTemp = splitDesc[0].split(":")[1].substring(0,5);
            minTemp = "-";
            sunrise = "-";
            windDirection = splitDesc[1].split(":")[1];
            windSpeed = splitDesc[2].split(":")[1];
            visibility = splitDesc[3].split(":")[1];
            pressure = splitDesc[4].split(":")[1];
            humidity = splitDesc[5].split(":")[1];
            uvRisk = splitDesc[6].split(":")[1];
            pollution = splitDesc[7].split(":")[1];
            sunset = splitDesc[8].split(":")[1];

        }else if(splitDesc.length == 11){
            maxTemp = splitDesc[0].split(":")[1].substring(0,5);
            minTemp = splitDesc[1].split(":")[1].substring(0,5);
            windDirection = splitDesc[2].split(":")[1];
            windSpeed = splitDesc[3].split(":")[1];
            visibility = splitDesc[4].split(":")[1];
            pressure = splitDesc[5].split(":")[1];
            humidity = splitDesc[6].split(":")[1];
            uvRisk = splitDesc[7].split(":")[1];
            pollution = splitDesc[8].split(":")[1];
            sunrise = splitDesc[9].split(":")[1];
            sunset = splitDesc[10].split(":")[1];
        }
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getRainProbability() {
        return rainProbability;
    }

    public void setRainProbability(String rainProbability) {
        this.rainProbability = rainProbability;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getUvRisk() {
        return uvRisk;
    }

    public void setUvRisk(String uvRisk) {
        this.uvRisk = uvRisk;
    }

    public String getPollution() {
        return pollution;
    }

    public void setPollution(String pollution) {
        this.pollution = pollution;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    private String getCountry(String city){

        switch(city){
            case "Dhaka":
                return "Bangladesh";
            case "Kigali":
                return "Rwanda";
            case "Muscat":
                return  "Oman";
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

    @Override
    public String toString() {
        return "\n\nWEATHER: \n\n" +
                "city: " + city + "\n"+
                "country: " + country + "\n"+
                "day: " + day + "\n"+
                "rainProbability: " + rainProbability + "\n"+
                "maxTemp: " + maxTemp + "\n"+
                "minTemp: " + minTemp + "\n"+
                "pressure: " + pressure + "\n"+
                "humidity: " + humidity + "\n"+
                "date: " + date + "\n"+
                "windDirection: " + windDirection + "\n"+
                "windSpeed: " + windSpeed + "\n"+
                "visibility: " + visibility + "\n"+
                "uvRisk: " + uvRisk + "\n"+
                "pollution: " + pollution + "\n"+
                "sunset: " + sunset + "\n"+
                "sunrise:" + sunrise;
    }
}
