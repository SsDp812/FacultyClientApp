package org.example.AppWindows.MarkWindows.UpdateAndCreate;

import org.example.Entities.Mark;
import org.example.Services.CourseService;
import org.example.Services.MarkService;
import org.example.Services.StudentService;
import org.example.StandartComponents.StandartWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CreateMark extends StandartWindow {
    private JButton loadBT;


    private JTextField nameField;
    private JTextField courseField;

    private JTextField studentField;

    private JTextField scoreField;

    public CreateMark(String title, JFrame backFrame) {
        super(title, backFrame);
        loadBT = new JButton("Create!");
        loadBT.setBounds(40,190,100,40);
        loadBT.addActionListener(new createService());
        container.add(loadBT);

        //idField.setBounds(40,250,50,40);
        //updateBT.setBounds(40,310,100,40);


        courseField = new JTextField("courseID");
        studentField = new JTextField("studentID");
        scoreField = new JTextField("score");

        courseField.setBounds(120,250,100,40);
        studentField.setBounds(240,250,100,40);
        scoreField.setBounds(360,250,100,40);

        container.add(courseField);
        container.add(studentField);
        container.add(scoreField);

        this.setVisible(true);
    }


    class createService implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            MarkService service = new MarkService();
            StudentService studentService = new StudentService();
            CourseService courseService = new CourseService();
            Mark mark;
            try {
                mark = new Mark(
                        Long.parseLong(scoreField.getText()),
                        courseService.getCourseById(Long.parseLong(courseField.getText())),
                        studentService.getStudentById(Long.parseLong(studentField.getText()))
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
                service.create(mark);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
