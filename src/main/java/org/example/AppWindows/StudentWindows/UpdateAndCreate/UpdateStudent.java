package org.example.AppWindows.StudentWindows.UpdateAndCreate;

import org.example.AppWindows.MarkWindows.UpdateAndCreate.UpdateMark;
import org.example.Entities.Mark;
import org.example.Entities.Student;
import org.example.Services.CourseService;
import org.example.Services.MarkService;
import org.example.Services.StudentService;
import org.example.StandartComponents.ChangeWindows.UpdateWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

public class UpdateStudent extends UpdateWindow {
    private JButton loadBT;

    private JTextField nameField;
    private JTextField surnameField;
    private JTextField middleField;
    private JTextField birthField;
    private JTextField addressField;
    private JTextField mobileField;
    private JTextField mailField;

    public UpdateStudent(String title, JFrame backFrame) {
        super(title, backFrame);
        loadBT = new JButton("Load by Id");
        loadBT.setBounds(40,190,100,40);
        loadBT.addActionListener(new loadBTListener());
        updateBT.addActionListener(new updateService());
        container.add(loadBT);
        container.add(updateBT);
        container.add(idField);

        nameField = new JTextField("name");
        surnameField = new JTextField("surname");
        middleField = new JTextField("middle");
        birthField = new JTextField("birthday");
        addressField = new JTextField("address");
        mobileField = new JTextField("mobile");
        mailField = new JTextField("mail");


        nameField.setBounds(120,250,100,40);
        surnameField.setBounds(240,250,100,40);
        middleField.setBounds(360,250,100,40);
        birthField.setBounds(480,250,100,40);
        addressField.setBounds(600,250,100,40);
        mobileField.setBounds(360,310,100,40);
        mailField.setBounds(480,310,100,40);

        container.add(nameField);
        container.add(surnameField);
        container.add(mailField);
        container.add(middleField);
        container.add(birthField);
        container.add(addressField);
        container.add(mobileField);

        this.setVisible(true);
    }

    class loadBTListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            StudentService service = new StudentService();
            try {
                Student student = service.getStudentById(((Long.parseLong(idField.getText()))));
                nameField.setText(student.getName());
               surnameField.setText(student.getSurname());
               middleField.setText(student.getMiddle());
               birthField.setText(student.getBirthday().toString());
               addressField.setText(student.getAddress());
               mobileField.setText(student.getMobile());
               mailField.setText(student.getMail());

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }
    }



    class updateService implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           StudentService service = new StudentService();
            Student student;
            student = new Student(
                    Long.parseLong(idField.getText()),
                    nameField.getText(),
                    surnameField.getText(),
                    middleField.getText(),
                    Date.valueOf(birthField.getText()),
                    addressField.getText(),
                    mobileField.getText(),
                    mailField.getText()
            );
            try {
                service.update(student);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
