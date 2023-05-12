package org.example.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Connector.GetConnector;
import org.example.Connector.PostConnector;
import org.example.Entities.Group;
import org.example.Entities.Mark;

import java.io.IOException;

public class MarkService {
    private final static String host = "http://localhost:8080/marks";

    public void create(Mark mark) throws IOException {
        String url = host + "/create";
        PostConnector postConnector = new PostConnector(url);
        postConnector.addParam("score",mark.getScore().toString());
        postConnector.addParam("course_id",mark.getCourse().getId().toString());
        postConnector.addParam("student_id",mark.getStudent().getId().toString());
        postConnector.connect();
    }

    public void update(Mark mark) throws IOException {
        String url = host + "/update";
        PostConnector postConnector = new PostConnector(url);
        postConnector.addParam("id",mark.getId().toString());
        postConnector.addParam("score",mark.getScore().toString());
        postConnector.addParam("course_id",mark.getCourse().getId().toString());
        postConnector.addParam("student_id",mark.getStudent().getId().toString());
        postConnector.connect();
    }

    public void delete(Long id) throws IOException {
        String url = host + "/delete/" + id.toString();
        GetConnector getConnector = new GetConnector(url);
        getConnector.connect();
    }

    public Mark[] getAllMarks() throws IOException {
        String url = host + "/";
        GetConnector getConnector = new GetConnector(url);
        String res = getConnector.connect();
        ObjectMapper objectMapper = new ObjectMapper();
        Mark[] marks = objectMapper.readValue(res,Mark[].class);
        return marks;
    }

    public Mark getMarkById(Long id) throws IOException {
        String url = host + "/" + id.toString();
        GetConnector getConnector = new GetConnector(url);
        String res = getConnector.connect();
        ObjectMapper objectMapper = new ObjectMapper();
        Mark mark = objectMapper.readValue(res,Mark.class);
        return mark;
    }
}
