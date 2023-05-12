package org.example.AppWindows.CourseWindows.UpdateAndCreate;

import org.example.AppWindows.ClassRoomsWindows.UpdateAndCreate.UpdateClassRoom;
import org.example.Entities.ClassRoom;
import org.example.Entities.Course;
import org.example.Entities.Teacher;
import org.example.Services.ClassRoomService;
import org.example.Services.CourseService;
import org.example.Services.TeacherService;
import org.example.StandartComponents.ChangeWindows.UpdateWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UpdateCourse extends UpdateWindow {

    private JButton loadBT;


    private JTextField nameField;
    private JTextField descField;

    private JTextField teacherField;

    public UpdateCourse(String title, JFrame backFrame) {
        super(title, backFrame);
        loadBT = new JButton("Load by Id");
        loadBT.setBounds(40,190,100,40);
        loadBT.addActionListener(new loadBTListener());
        updateBT.addActionListener(new updateService());
        container.add(loadBT);
        container.add(updateBT);
        container.add(idField);

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

    class loadBTListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            CourseService service = new CourseService();
            try {
                Course course = service.getCourseById(Long.parseLong(idField.getText()));
                nameField.setText(course.getName());
                descField.setText(course.getDescription());
                teacherField.setText(String.valueOf(course.getTeacher().getId()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }
    }





    class updateService implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            CourseService service = new CourseService();
            TeacherService teacherService = new TeacherService();
            Course course;
            try {
                course = new Course(
                        Long.parseLong(idField.getText()),
                        nameField.getText(),
                        descField.getText(),
                        teacherService.getTeacherById(Long.parseLong(teacherField.getText())));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
                service.update(course);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
