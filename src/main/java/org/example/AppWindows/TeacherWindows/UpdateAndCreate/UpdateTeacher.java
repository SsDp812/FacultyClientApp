package org.example.AppWindows.TeacherWindows.UpdateAndCreate;

import org.example.AppWindows.StudentWindows.UpdateAndCreate.UpdateStudent;
import org.example.Entities.Student;
import org.example.Entities.Teacher;
import org.example.Services.StudentService;
import org.example.Services.TeacherService;
import org.example.StandartComponents.ChangeWindows.UpdateWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Date;

public class UpdateTeacher extends UpdateWindow {
    private JButton loadBT;

    private JTextField nameField;
    private JTextField surnameField;
    private JTextField middleField;
    private JTextField birthField;
    private JTextField addressField;
    private JTextField mobileField;
    private JTextField mailField;

    public UpdateTeacher(String title, JFrame backFrame) {
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
            TeacherService service = new TeacherService();
            Teacher teacher;
            try {
                teacher = service.getTeacherById(((Long.parseLong(idField.getText()))));
                nameField.setText(teacher.getName());
                surnameField.setText(teacher.getSurname());
                middleField.setText(teacher.getMiddle());
                birthField.setText(teacher.getBirthday().toString());
                addressField.setText(teacher.getAddress());
                mobileField.setText(teacher.getMobile());
                mailField.setText(teacher.getMail());

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }
    }



    class updateService implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
          TeacherService service = new TeacherService();
          Teacher teacher;
            teacher = new Teacher(
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
                service.update(teacher);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
