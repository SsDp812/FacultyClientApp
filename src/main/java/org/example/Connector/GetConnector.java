package org.example.Connector;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Entities.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class GetConnector {
    private String address;
    private URL url;

    public GetConnector(String address) throws MalformedURLException {
        this.address = address;
        url = new URL(address);
    }
    public String connect() throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;

        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        String res = response.toString();
        return res;

    }
}
