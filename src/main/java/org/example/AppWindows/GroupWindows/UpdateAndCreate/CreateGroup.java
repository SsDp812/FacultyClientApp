package org.example.AppWindows.GroupWindows.UpdateAndCreate;

import org.example.Entities.Group;
import org.example.Services.CourseService;
import org.example.Services.GroupService;
import org.example.StandartComponents.StandartWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class CreateGroup extends StandartWindow {
    private JButton loadBT;


    private JTextField nameField;
    private JTextField descField;

    private JTextField teacherField;

    public CreateGroup(String title, JFrame backFrame) {
        super(title, backFrame);
        loadBT = new JButton("Create!");
        loadBT.setBounds(40,190,100,40);
        loadBT.addActionListener(new createService());
        container.add(loadBT);


        //idField.setBounds(40,250,50,40);
        //updateBT.setBounds(40,310,100,40);

        nameField = new JTextField("name");
        descField = new JTextField("courseID");

        nameField.setBounds(110,250,100,40);
        descField.setBounds(230,250,100,40);


        container.add(nameField);
        container.add(descField);

        this.setVisible(true);
    }



    class createService implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            GroupService service = new GroupService();
            CourseService courseService = new CourseService();
            Group group;
            try {
                group = new Group(
                        nameField.getText(),
                        courseService.getCourseById(Long.parseLong(descField.getText())),
                        new ArrayList<>()
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
                service.create(group);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
