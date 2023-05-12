package org.example.AppWindows.GroupWindows.UpdateAndCreate;

import org.example.AppWindows.FacultyWindows.UpdateAndCreate.UpdateFaculty;
import org.example.Entities.Course;
import org.example.Entities.Faculty;
import org.example.Entities.Group;
import org.example.Services.CourseService;
import org.example.Services.FacultyService;
import org.example.Services.GroupService;
import org.example.Services.TeacherService;
import org.example.StandartComponents.ChangeWindows.UpdateWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GroupUpdate extends UpdateWindow {
    private JButton loadBT;


    private JTextField nameField;
    private JTextField descField;

    private JTextField teacherField;

    public GroupUpdate(String title, JFrame backFrame) {
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
        descField = new JTextField("courseID");

        nameField.setBounds(110,250,100,40);
        descField.setBounds(230,250,100,40);


        container.add(nameField);
        container.add(descField);

        this.setVisible(true);
    }

    class loadBTListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            GroupService service = new GroupService();
            try {
                Group group = service.getGroupById(((Long.parseLong(idField.getText()))));
                nameField.setText(group.getName());
                descField.setText(group.getCourse().getId().toString());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }
    }



    class updateService implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
          GroupService service = new GroupService();
            CourseService courseService = new CourseService();
            Group group;
            try {
                group = new Group(
                        Long.parseLong(idField.getText()),
                        nameField.getText(),
                        courseService.getCourseById(Long.parseLong(descField.getText())),
                        service.getGroupById(Long.parseLong(idField.getText())).getStudent()
                      );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
                service.update(group);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
