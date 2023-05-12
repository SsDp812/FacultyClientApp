package org.example.Entities;


import java.util.List;

public class Group {

    private Long id;


    private String name;


    private Course course;


    private List<Student> student;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Group(Long id, String name, Course course, List<Student> student) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.student = student;
    }

    public Group(String name, Course course, List<Student> student) {
        this.name = name;
        this.course = course;
        this.student = student;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public Group() {
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course=" + course.getName() + "-id-" + course.getId().toString() +
                '}';
    }
}
