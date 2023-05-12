package org.example.AppWindows.StudentWindows.CoursesFunctions;

import org.example.Entities.Student;
import org.example.Services.GroupService;
import org.example.Services.StudentService;
import org.example.StandartComponents.StandartWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RemoveCourse extends StandartWindow {
    private JTextField idStudentField;
    private JTextField idCourseField;
    private JButton subbmit;
    public RemoveCourse(String title, JFrame backFrame) {
        super(title, backFrame);

        idCourseField = new JTextField("id-course");
        idStudentField = new JTextField("id-student");
        subbmit = new JButton("Remove");
        subbmit.addActionListener(new subListener());
        idCourseField.setBounds(20,250,100,40);
        idStudentField.setBounds(20,310,100,40);
        subbmit.setBounds(20,370,100,40);

        container.add(idCourseField);
        container.add(idStudentField);
        container.add(subbmit);

        this.setVisible(true);
    }

    class subListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            StudentService service = new StudentService();
            try {
                service.removeCourse(Long.parseLong(idStudentField.getText()),Long.parseLong(idCourseField.getText()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
