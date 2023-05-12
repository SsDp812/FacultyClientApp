package org.example.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Connector.GetConnector;
import org.example.Connector.PostConnector;
import org.example.Entities.Course;
import org.example.Entities.Faculty;

import java.io.IOException;

public class FacultyService {
    private final static String host = "http://localhost:8080/faculties";

    public void create(Faculty faculty) throws IOException {
        String url = host + "/create";
        PostConnector postConnector = new PostConnector(url);
        postConnector.addParam("name",faculty.getName());
        postConnector.addParam("description",faculty.getDescription());
        postConnector.addParam("dean",faculty.getDean().getId().toString());
        postConnector.connect();
    }

    public void update(Faculty faculty) throws IOException {
        String url = host + "/update";
        PostConnector postConnector = new PostConnector(url);
        postConnector.addParam("id",faculty.getId().toString());
        postConnector.addParam("name",faculty.getName());
        postConnector.addParam("description",faculty.getDescription());
        postConnector.addParam("dean",faculty.getDean().getId().toString());
        postConnector.connect();
    }

    public void delete(Long id) throws IOException {
        String url = host + "/delete/" + id.toString();
        GetConnector getConnector = new GetConnector(url);
        getConnector.connect();
    }

    public Faculty[] getAllFaculties() throws IOException {
        String url = host + "/";
        GetConnector getConnector = new GetConnector(url);
        String res = getConnector.connect();
        ObjectMapper objectMapper = new ObjectMapper();
        Faculty[] facultyes = objectMapper.readValue(res,Faculty[].class);
        return facultyes;
    }

    public Faculty getFacultyById(Long id) throws IOException {
        String url = host + "/" + id.toString();
        GetConnector getConnector = new GetConnector(url);
        String res = getConnector.connect();
        ObjectMapper objectMapper = new ObjectMapper();
        Faculty faculty = objectMapper.readValue(res,Faculty.class);
        return faculty;
    }
}
