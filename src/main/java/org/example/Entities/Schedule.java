package org.example.Entities;


import java.sql.Time;

public class Schedule {

    private Long id;


    private ClassRoom classRoom;


    private String dayOfWeek;


    private Time start_time;


    private Time end_time;


    private Course course;


    private Teacher teacher;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Time getStart_time() {
        return start_time;
    }

    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }

    public Time getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Time end_time) {
        this.end_time = end_time;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Schedule(ClassRoom classRoom, String dayOfWeek, Time start_time, Time end_time, Course course, Teacher teacher) {
        this.classRoom = classRoom;
        this.dayOfWeek = dayOfWeek;
        this.start_time = start_time;
        this.end_time = end_time;
        this.course = course;
        this.teacher = teacher;
    }

    public Schedule(Long id, ClassRoom classRoom, String dayOfWeek, Time start_time, Time end_time, Course course, Teacher teacher) {
        this.id = id;
        this.classRoom = classRoom;
        this.dayOfWeek = dayOfWeek;
        this.start_time = start_time;
        this.end_time = end_time;
        this.course = course;
        this.teacher = teacher;
    }

    public Schedule() {
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", classRoom=" + classRoom.getName() +
                ", dayOfWeek='" + dayOfWeek +
                ", start_time=" + start_time.toString() +
                ", end_time=" + end_time.toString() +
                ", course=" + course.getName() + "-id-" + course.getId().toString() +
                ", teacher=" + teacher.getName() + "-id-" + teacher.getId() +
                '}';
    }
}
