package org.example.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Connector.GetConnector;
import org.example.Connector.PostConnector;
import org.example.Entities.Mark;
import org.example.Entities.Schedule;

import java.io.IOException;

public class ScheduleService {
    private final static String host = "http://localhost:8080/schedules";

    public void create(Schedule schedule) throws IOException {
        String url = host + "/create";
        PostConnector postConnector = new PostConnector(url);
        postConnector.addParam("classroom_id",schedule.getClassRoom().getId().toString());
        postConnector.addParam("dayOfWeek",schedule.getDayOfWeek());
        postConnector.addParam("start_time",schedule.getStart_time().toString());
        postConnector.addParam("end_time",schedule.getEnd_time().toString());
        postConnector.addParam("course_id",schedule.getCourse().getId().toString());
        postConnector.addParam("teacher_id",schedule.getTeacher().getId().toString());
        postConnector.connect();
    }

    public void update(Schedule schedule) throws IOException {
        String url = host + "/update";
        PostConnector postConnector = new PostConnector(url);
        postConnector.addParam("id",schedule.getId().toString());
        postConnector.addParam("classroom_id",schedule.getClassRoom().getId().toString());
        postConnector.addParam("dayOfWeek",schedule.getDayOfWeek());
        postConnector.addParam("start_time",schedule.getStart_time().toString());
        postConnector.addParam("end_time",schedule.getEnd_time().toString());
        postConnector.addParam("course_id",schedule.getCourse().getId().toString());
        postConnector.addParam("teacher_id",schedule.getTeacher().getId().toString());
        postConnector.connect();
    }

    public void delete(Long id) throws IOException {
        String url = host + "/delete/" + id.toString();
        GetConnector getConnector = new GetConnector(url);
        getConnector.connect();
    }

    public Schedule[] getAllSchedules() throws IOException {
        String url = host + "/";
        GetConnector getConnector = new GetConnector(url);
        String res = getConnector.connect();
        ObjectMapper objectMapper = new ObjectMapper();
        Schedule[] schedules = objectMapper.readValue(res,Schedule[].class);
        return schedules;
    }

    public Schedule getScheduleById(Long id) throws IOException {
        String url = host + "/" + id.toString();
        GetConnector getConnector = new GetConnector(url);
        String res = getConnector.connect();
        ObjectMapper objectMapper = new ObjectMapper();
        Schedule schedule = objectMapper.readValue(res,Schedule.class);
        return schedule;
    }
}
