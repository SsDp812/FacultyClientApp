package org.example.AppWindows.GroupWindows.StudentsFunctions;

import org.example.Services.GroupService;
import org.example.Services.StudentService;
import org.example.StandartComponents.StandartWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AddStudentToGroup extends StandartWindow {
    private JTextField idStudentField;
    private JTextField idGroupField;
    private JButton subbmit;
    public AddStudentToGroup(String title, JFrame backFrame) {
        super(title, backFrame);

        idStudentField = new JTextField("id-Student");
        idGroupField = new JTextField("id-Group");
        subbmit = new JButton("Add");
        subbmit.addActionListener(new subListener());
        idGroupField.setBounds(20,250,100,40);
        idStudentField.setBounds(20,310,100,40);
        subbmit.setBounds(20,370,100,40);

        container.add(idGroupField);
        container.add(idStudentField);
        container.add(subbmit);

        this.setVisible(true);
    }

    class subListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            GroupService service = new GroupService();
            try {
                service.addStudent(Long.parseLong(idGroupField.getText()),Long.parseLong(idStudentField.getText()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
