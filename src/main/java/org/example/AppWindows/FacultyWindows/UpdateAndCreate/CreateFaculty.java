package org.example.AppWindows.FacultyWindows.UpdateAndCreate;

import org.example.Entities.Faculty;
import org.example.Services.FacultyService;
import org.example.Services.TeacherService;
import org.example.StandartComponents.StandartWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CreateFaculty extends StandartWindow {
    private JButton loadBT;


    private JTextField nameField;
    private JTextField descField;

    private JTextField teacherField;

    public CreateFaculty(String title, JFrame backFrame) {
        super(title, backFrame);
        loadBT = new JButton("Create!");
        loadBT.setBounds(40,190,100,40);
        loadBT.addActionListener(new createService());
        container.add(loadBT);

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




    class createService implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            FacultyService service = new FacultyService();
            TeacherService teacherService = new TeacherService();
            Faculty faculty;
            try {
                faculty = new Faculty(
                        nameField.getText(),
                        descField.getText(),
                        teacherService.getTeacherById(Long.parseLong(teacherField.getText())));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
                service.create(faculty);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
