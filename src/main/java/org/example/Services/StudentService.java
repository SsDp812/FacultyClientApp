package org.example.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Connector.GetConnector;
import org.example.Connector.PostConnector;
import org.example.Entities.ClassRoom;
import org.example.Entities.Student;

import java.io.IOException;
import java.net.MalformedURLException;

public class StudentService {
    private final static String host = "http://localhost:8080/students";

    public void create(Student student) throws IOException {
        String url = host + "/create";
        PostConnector postConnector = new PostConnector(url);
        postConnector.addParam("name",student.getName());
        postConnector.addParam("surname",student.getSurname());
        postConnector.addParam("middlename",student.getMiddle());
        postConnector.addParam("birthday",student.getBirthday().toString());
        postConnector.addParam("address",student.getAddress());
        postConnector.addParam("mobile",student.getMobile());
        postConnector.addParam("mail",student.getMail());
        postConnector.connect();
    }

    public void update(Student student) throws IOException {
        String url = host + "/update";
        PostConnector postConnector = new PostConnector(url);
        postConnector.addParam("id",student.getId().toString());
        postConnector.addParam("name",student.getName());
        postConnector.addParam("surname",student.getSurname());
        postConnector.addParam("middlename",student.getMiddle());
        postConnector.addParam("birthday",student.getBirthday().toString());
        postConnector.addParam("address",student.getAddress());
        postConnector.addParam("mobile",student.getMobile());
        postConnector.addParam("mail",student.getMail());
        postConnector.connect();
    }

    public void delete(Long id) throws IOException {
        String url = host + "/delete/" + id.toString();
        GetConnector getConnector = new GetConnector(url);
        getConnector.connect();
    }

    public Student[] getAllStudents() throws IOException {
        String url = host + "/";
        GetConnector getConnector = new GetConnector(url);
        String res = getConnector.connect();
        ObjectMapper objectMapper = new ObjectMapper();
        Student[] students = objectMapper.readValue(res,Student[].class);
        return students;
    }

    public Student getStudentById(Long id) throws IOException {
        String url = host + "/" + id.toString();
        GetConnector getConnector = new GetConnector(url);
        String res = getConnector.connect();
        ObjectMapper objectMapper = new ObjectMapper();
        Student student = objectMapper.readValue(res,Student.class);
        return  student;
    }

    public void addCourse(Long id,Long course_id) throws IOException {
        String url = host + "/courses/add";
        PostConnector postConnector = new PostConnector(url);
        postConnector.addParam("id",id.toString());
        postConnector.addParam("course_id",course_id.toString());
        postConnector.connect();
    }

    public void removeCourse(Long id,Long course_id) throws IOException {
        String url = host + "/courses/remove";
        PostConnector postConnector = new PostConnector(url);
        postConnector.addParam("id",id.toString());
        postConnector.addParam("course_id",course_id.toString());
        postConnector.connect();
    }
}
