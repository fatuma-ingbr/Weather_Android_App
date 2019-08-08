package com.example.dailycast.DataObject;

/**
 *  Name: Fatuma Ingabire
 *  Student ID: S1719023
 * */

public class Weather {

    private String location;
    private String day;
    private String rainProbability;
    private String maxTemp;
    private String minTemp;
    private String pressure;
    private String humidity;
    private String date;


    //Constructor
    public Weather(){
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    @Override
    public String toString() {
        return "WEATHER: \n" +
                "======== \n" +
                "Location = " + location + '\n' +
                "day = " + day + '\n' +
                "rainProbability= " + rainProbability + '\n' +
                "maxTemp = " + maxTemp + '\n' +
                "minTemp = " + minTemp + '\n' +
                "pressure = " + pressure + '\n' +
                "humidity = " + humidity + '\n' +
                "Date= " + date + '\n';
    }
}
