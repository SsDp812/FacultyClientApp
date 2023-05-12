package org.example.StandartComponents.ChangeWindows;

import org.example.Services.*;
import org.example.StandartComponents.StandartWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DeleteWindow extends StandartWindow {

    private TextField idFeild;
    private JButton deleteButton;
    private String entityName;


    public DeleteWindow(JFrame backFrame,String entityName) {
        super("Delete", backFrame);
        this.entityName = entityName;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel label = new JLabel("Id: ");
        label.setBounds(200,250,100,60);
        idFeild = new TextField();
        idFeild.setBounds(320,250,120,60);
        deleteButton = new JButton("Delete!");
        deleteButton.setBounds(470,250,120,60);
        deleteButton.addActionListener(new deleteListener());
        container.add(label);
        container.add(idFeild);
        container.add(deleteButton);
        this.setVisible(true);
    }

    private class deleteListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (entityName){
                case "classRoom":
                    try {
                        new ClassRoomService().delete(Long.parseLong(idFeild.getText()));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case "course":
                    try {
                        new CourseService().delete(Long.parseLong(idFeild.getText()));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case "faculty":
                    try {
                        new FacultyService().delete(Long.parseLong(idFeild.getText()));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case "group":
                    try {
                        new GroupService().delete(Long.parseLong(idFeild.getText()));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case "mark":
                    try {
                        new MarkService().delete(Long.parseLong(idFeild.getText()));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case "schedule":
                    try {
                        new ScheduleService().delete(Long.parseLong(idFeild.getText()));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case "student":
                    try {
                        new StudentService().delete(Long.parseLong(idFeild.getText()));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case "teacher":
                    try {
                        new TeacherService().delete(Long.parseLong(idFeild.getText()));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
            }
        }
    }
}
