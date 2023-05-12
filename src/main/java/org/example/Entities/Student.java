package org.example.Entities;




import java.sql.Date;
import java.util.List;


public class Student {

    private Long id;


    private String name;


    private String surname;


    private String middle;


    private Date birthday;


    private String address;


    private String mobile;


    private String mail;


    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Student(String name, String surname, String middle, Date birthday, String address, String mobile, String mail) {
        this.name = name;
        this.surname = surname;
        this.middle = middle;
        this.birthday = birthday;
        this.address = address;
        this.mobile = mobile;
        this.mail = mail;
    }

    public Student() {
    }

    public Student(Long id, String name, String surname, String middle, Date birthday, String address, String mobile, String mail) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middle = middle;
        this.birthday = birthday;
        this.address = address;
        this.mobile = mobile;
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", middle='" + middle + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
