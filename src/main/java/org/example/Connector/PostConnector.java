package org.example.Connector;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;

public class PostConnector {
    private String address;
    private HashMap<String,String> params;
    private URL url;
    public PostConnector(String address) throws MalformedURLException {
        this.address = address;
        url = new URL(address);
        params = new HashMap<>();
    }
    public void connect() throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);

        OutputStream os = connection.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
        osw.write(getStringParam());
        System.out.println(getStringParam());
        osw.flush();
        osw.close();
        os.close();
        connection.connect();
        System.out.println(connection.getResponseCode());
    }


    public void addParam(String name,String val){
        params.put(name,val);
    }
    public String getStringParam(){
        String body = "";
        for(var el : params.entrySet()){
            body += el.getKey();
            body += "=";
            body += el.getValue();
            body += "&";
        }
        return (new StringBuilder(body).substring(0,body.length()-1).toString());
    }
}
