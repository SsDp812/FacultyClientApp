package org.example.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Connector.GetConnector;
import org.example.Connector.PostConnector;
import org.example.Entities.ClassRoom;

import java.io.IOException;
import java.net.MalformedURLException;

public class ClassRoomService {

    private final static String host = "http://localhost:8080/classrooms";

    public void create(ClassRoom classRoom) throws IOException {
        String url = host + "/create";
        PostConnector postConnector = new PostConnector(url);
        postConnector.addParam("name",classRoom.getName());
        postConnector.addParam("description",classRoom.getDescription());
        postConnector.addParam("capacity",String.valueOf(classRoom.getCapacity()));
        postConnector.connect();
    }

    public void update(ClassRoom classRoom) throws IOException {
        String url = host + "/update";
        PostConnector postConnector = new PostConnector(url);
        postConnector.addParam("id",classRoom.getId().toString());
        postConnector.addParam("name",classRoom.getName());
        postConnector.addParam("description",classRoom.getDescription());
        postConnector.addParam("capacity",String.valueOf(classRoom.getCapacity()));
        postConnector.connect();
    }

    public void delete(Long id) throws IOException {
        String url = host + "/delete/" + id.toString();
        GetConnector getConnector = new GetConnector(url);
        getConnector.connect();
    }

    public ClassRoom[] getAllClassRooms() throws IOException {
        String url = host + "/";
        GetConnector getConnector = new GetConnector(url);
        String res = getConnector.connect();
        ObjectMapper objectMapper = new ObjectMapper();
        ClassRoom[] classRoom = objectMapper.readValue(res,ClassRoom[].class);
        return  classRoom;
    }

    public ClassRoom getClassRoomById(Long id) throws IOException {
        String url = host + "/" + id.toString();
        GetConnector getConnector = new GetConnector(url);
        String res = getConnector.connect();
        ObjectMapper objectMapper = new ObjectMapper();
        ClassRoom classRoom = objectMapper.readValue(res,ClassRoom.class);
        return  classRoom;
    }
}
