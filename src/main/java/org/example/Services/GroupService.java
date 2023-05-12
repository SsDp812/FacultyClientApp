package org.example.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Connector.GetConnector;
import org.example.Connector.PostConnector;
import org.example.Entities.Faculty;
import org.example.Entities.Group;

import java.io.IOException;

public class GroupService {
    private final static String host = "http://localhost:8080/groups";

    public void create(Group group) throws IOException {
        String url = host + "/create";
        PostConnector postConnector = new PostConnector(url);
        postConnector.addParam("name",group.getName());
        postConnector.addParam("course_id",group.getCourse().getId().toString());
        postConnector.connect();
    }

    public void update(Group group) throws IOException {
        String url = host + "/update";
        PostConnector postConnector = new PostConnector(url);
        postConnector.addParam("id",group.getId().toString());
        postConnector.addParam("name",group.getName());
        postConnector.addParam("course_id",group.getCourse().toString());
        postConnector.connect();
    }

    public void delete(Long id) throws IOException {
        String url = host + "/delete/" + id.toString();
        GetConnector getConnector = new GetConnector(url);
        getConnector.connect();
    }

    public Group[] getAllGroups() throws IOException {
        String url = host + "/";
        GetConnector getConnector = new GetConnector(url);
        String res = getConnector.connect();
        ObjectMapper objectMapper = new ObjectMapper();
        Group[] groups = objectMapper.readValue(res,Group[].class);
        return groups;
    }

    public Group getGroupById(Long id) throws IOException {
        String url = host + "/" + id.toString();
        GetConnector getConnector = new GetConnector(url);
        String res = getConnector.connect();
        ObjectMapper objectMapper = new ObjectMapper();
        Group group = objectMapper.readValue(res,Group.class);
        return group;
    }


    public void addStudent(Long id,Long student_id) throws IOException {
        String url = host + "/addStudent";
        PostConnector postConnector = new PostConnector(url);
        postConnector.addParam("id",id.toString());
        postConnector.addParam("student_id",student_id.toString());
        postConnector.connect();
    }

    public void removeStudent(Long id,Long student_id) throws IOException {
        String url = host + "/removeStudent";
        PostConnector postConnector = new PostConnector(url);
        postConnector.addParam("id",id.toString());
        postConnector.addParam("student_id",student_id.toString());
        postConnector.connect();
    }
}
