package org.example.Entities;



public class Mark {

    private Long id;


    private Course course;


    private Student student;




    private Long score;


    public Mark(Long id, Long score, Course course, Student student) {
        this.id = id;
        this.score = score;
        this.course = course;
        this.student = student;
    }

    public Mark(Long score, Course course, Student student) {
        this.score = score;
        this.course = course;
        this.student = student;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public Mark() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
                ", course=" + course.getName() + "-id-" + course.getId().toString() +
                ", student=" + student.getName() + "-id-" + student.getId().toString() +
                ", score="+score.toString()+
                '}';
    }
}
