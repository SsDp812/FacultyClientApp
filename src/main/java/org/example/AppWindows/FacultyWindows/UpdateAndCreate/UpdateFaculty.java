package org.example.AppWindows.FacultyWindows.UpdateAndCreate;

import org.example.AppWindows.CourseWindows.UpdateAndCreate.UpdateCourse;
import org.example.Entities.Course;
import org.example.Entities.Faculty;
import org.example.Services.CourseService;
import org.example.Services.FacultyService;
import org.example.Services.TeacherService;
import org.example.StandartComponents.ChangeWindows.UpdateWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UpdateFaculty extends UpdateWindow {
    private JButton loadBT;


    private JTextField nameField;
    private JTextField descField;

    private JTextField teacherField;

    public UpdateFaculty(String title, JFrame backFrame) {
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
        teacherField = new JTextField("deanID");

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
            FacultyService service = new FacultyService();
            try {
                Faculty faculty = service.getFacultyById((Long.parseLong(idField.getText())));
                nameField.setText(faculty.getName());
                descField.setText(faculty.getDescription());
                teacherField.setText(String.valueOf(faculty.getDean().getId()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }
    }





    class updateService implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
          FacultyService service = new FacultyService();
            TeacherService teacherService = new TeacherService();
            Faculty faculty;
            try {
                faculty = new Faculty(
                        Long.parseLong(idField.getText()),
                        nameField.getText(),
                        descField.getText(),
                        teacherService.getTeacherById(Long.parseLong(teacherField.getText())));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
                service.update(faculty);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
