package org.example.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Connector.GetConnector;
import org.example.Connector.PostConnector;
import org.example.Entities.Course;
import org.example.Entities.Student;

import java.io.IOException;

public class CourseService {
    private final static String host = "http://localhost:8080/courses";

    public void create(Course course) throws IOException {
        String url = host + "/create";
        PostConnector postConnector = new PostConnector(url);
        postConnector.addParam("name",course.getName());
        postConnector.addParam("description",course.getDescription());
        postConnector.addParam("teacher_id",course.getTeacher().getId().toString());
        postConnector.connect();
    }

    public void update(Course course) throws IOException {
        String url = host + "/update";
        PostConnector postConnector = new PostConnector(url);
        postConnector.addParam("id",course.getId().toString());
        postConnector.addParam("name",course.getName());
        postConnector.addParam("description",course.getDescription());
        postConnector.addParam("teacher_id",course.getTeacher().getId().toString());
        postConnector.connect();
    }

    public void delete(Long id) throws IOException {
        String url = host + "/delete/" + id.toString();
        GetConnector getConnector = new GetConnector(url);
        getConnector.connect();
    }

    public Course[] getAllCourses() throws IOException {
        String url = host + "/";
        GetConnector getConnector = new GetConnector(url);
        String res = getConnector.connect();
        ObjectMapper objectMapper = new ObjectMapper();
        Course[] courses = objectMapper.readValue(res,Course[].class);
        return courses;
    }

    public Course getCourseById(Long id) throws IOException {
        String url = host + "/" + id.toString();
        GetConnector getConnector = new GetConnector(url);
        String res = getConnector.connect();
        System.out.println(res);
        ObjectMapper objectMapper = new ObjectMapper();
        Course course = objectMapper.readValue(res,Course.class);
        return course;
    }
}
