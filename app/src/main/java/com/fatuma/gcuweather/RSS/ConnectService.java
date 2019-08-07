package com.fatuma.gcuweather.RSS;
/**
 *  Name: Fatuma Ingabire
 *  Student ID: S1719023
 * */

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ConnectService {

    public static InputStream getInputStream(URL url){
        try{
            //calling openConnection to open connection with URL object
            //the getting inputStream from the connection
            return url.openConnection().getInputStream();

        }catch(IOException e){
            return null;
        }
    }
}
