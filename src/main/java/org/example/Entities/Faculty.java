package org.example.Entities;



public class Faculty {

    private Long id;


    private String name;

    private String description;


    private Teacher dean;

    public Faculty(String name, String description, Teacher dean) {
        this.name = name;
        this.description = description;
        this.dean = dean;
    }

    public Faculty(Long id, String name, String description, Teacher dean) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dean = dean;
    }

    public Faculty() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Teacher getDean() {
        return dean;
    }

    public void setDean(Teacher dean) {
        this.dean = dean;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dean=" + dean.getName() + "-id-" + dean.getId().toString() +
                '}';
    }
}
