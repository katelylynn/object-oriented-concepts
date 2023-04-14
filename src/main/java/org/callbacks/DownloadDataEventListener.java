package org.callbacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadDataEventListener implements EventListener {

    @Override
    public void onTrigger() {
        respondToTrigger();
    }

    @Override
    public void respondToTrigger() {
        System.out.println(stream("https://reqres.in/api/users?page=2"));
    }

    public static String stream(String urlstr) {
        URL url = null;
        try {
            url = new URL(urlstr);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        try (InputStream input = url.openStream()) {
            InputStreamReader isr = new InputStreamReader(input);
            BufferedReader reader = new BufferedReader(isr);
            StringBuilder json = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                json.append((char) c);
            }
            return json.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
