package org.example.AppWindows.CourseWindows.UpdateAndCreate;

import org.example.Entities.Course;
import org.example.Services.CourseService;
import org.example.Services.TeacherService;
import org.example.StandartComponents.StandartWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CreateCourse extends StandartWindow {

    private JButton loadBT;


    private JTextField nameField;
    private JTextField descField;

    private JTextField teacherField;

    public CreateCourse(String title, JFrame backFrame) {
        super(title, backFrame);
        loadBT = new JButton("Create!");
        loadBT.setBounds(40,190,100,40);
        loadBT.addActionListener(new createService());
        container.add(loadBT);

        //idField.setBounds(40,250,50,40);
        //updateBT.setBounds(40,310,100,40);

        nameField = new JTextField("name");
        descField = new JTextField("description");
        teacherField = new JTextField("teacherID");

        nameField.setBounds(110,250,100,40);
        descField.setBounds(230,250,100,40);
        teacherField.setBounds(330,250,100,40);

        container.add(nameField);
        container.add(descField);
        container.add(teacherField);

        this.setVisible(true);
    }



    class createService implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            CourseService service = new CourseService();
            TeacherService teacherService = new TeacherService();
            Course course;
            try {
                course = new Course(
                        nameField.getText(),
                        descField.getText(),
                        teacherService.getTeacherById(Long.parseLong(teacherField.getText())));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
                service.create(course);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
