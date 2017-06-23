package com.sytoss.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class URLConnection {

	public static String  parsedString(URL url) throws MalformedURLException {
		HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String resultJson = "";
		 try {

             urlConnection = (HttpURLConnection) url.openConnection();
             urlConnection.setRequestMethod("GET");
             urlConnection.connect();

             InputStream inputStream = urlConnection.getInputStream();
             StringBuffer buffer = new StringBuffer();

             reader = new BufferedReader(new InputStreamReader(inputStream));

             String line;
             while ((line = reader.readLine()) != null) {
                 buffer.append(line);
             }

             resultJson = buffer.toString();

         } catch (Exception e) {
             e.printStackTrace();
         }
         return resultJson;
	}
}
