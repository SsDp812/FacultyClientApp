package org.example.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Connector.GetConnector;
import org.example.Connector.PostConnector;
import org.example.Entities.Student;
import org.example.Entities.Teacher;

import java.io.IOException;

public class TeacherService {
    private final static String host = "http://localhost:8080/teachers";

    public void create(Teacher teacher) throws IOException {
        String url = host + "/create";
        PostConnector postConnector = new PostConnector(url);
        postConnector.addParam("name",teacher.getName());
        postConnector.addParam("surname",teacher.getSurname());
        postConnector.addParam("middlename",teacher.getMiddle());
        postConnector.addParam("birthday",teacher.getBirthday().toString());
        postConnector.addParam("address",teacher.getAddress());
        postConnector.addParam("mobile",teacher.getMobile());
        postConnector.addParam("mail",teacher.getMail());
        postConnector.connect();
    }

    public void update(Teacher teacher) throws IOException {
        String url = host + "/update";
        System.out.println(url);
        PostConnector postConnector = new PostConnector(url);
        postConnector.addParam("id",teacher.getId().toString());
        postConnector.addParam("name",teacher.getName());
        postConnector.addParam("surname",teacher.getSurname());
        postConnector.addParam("middlename",teacher.getMiddle());
        postConnector.addParam("birthday",teacher.getBirthday().toString());
        postConnector.addParam("address",teacher.getAddress());
        postConnector.addParam("mobile",teacher.getMobile());
        postConnector.addParam("mail",teacher.getMail());
        postConnector.connect();
    }

    public void delete(Long id) throws IOException {
        String url = host + "/delete/" + id.toString();
        GetConnector getConnector = new GetConnector(url);
        getConnector.connect();
    }

    public Teacher[] getAllTeachers() throws IOException {
        String url = host + "/";
        GetConnector getConnector = new GetConnector(url);
        String res = getConnector.connect();
        ObjectMapper objectMapper = new ObjectMapper();
        Teacher[] teachers = objectMapper.readValue(res,Teacher[].class);
        return teachers;
    }

    public Teacher getTeacherById(Long id) throws IOException {
        String url = host + "/" + id.toString();
        GetConnector getConnector = new GetConnector(url);
        String res = getConnector.connect();
        ObjectMapper objectMapper = new ObjectMapper();
        Teacher teacher = objectMapper.readValue(res,Teacher.class);
        return teacher;
    }
}
