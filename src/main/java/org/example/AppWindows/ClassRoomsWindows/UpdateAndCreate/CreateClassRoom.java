package org.example.AppWindows.ClassRoomsWindows.UpdateAndCreate;

import org.example.Entities.ClassRoom;
import org.example.Services.ClassRoomService;
import org.example.StandartComponents.StandartWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CreateClassRoom  extends StandartWindow {
    private JButton loadBT;
    private JTextField nameField;

    private JTextField descField;
    private JTextField capacityField;

    public CreateClassRoom(String title, JFrame backFrame) {
        super(title, backFrame);
        loadBT = new JButton("Create!");
        loadBT.setBounds(40,190,100,40);
        loadBT.addActionListener(new CreateListener());
        container.add(loadBT);


        nameField = new JTextField("name");
        descField = new JTextField("description");
        capacityField = new JTextField("capacity");

        nameField.setBounds(110,250,100,40);
        descField.setBounds(230,250,100,40);
        capacityField.setBounds(330,250,100,40);

        container.add(nameField);
        container.add(descField);
        container.add(capacityField);

        this.setVisible(true);
    }



    class CreateListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ClassRoomService service = new ClassRoomService();
            ClassRoom classRoom = new ClassRoom(
                    nameField.getText(),
                    descField.getText(),
                    (int) Long.parseLong(capacityField.getText())
            );
            try {
                service.create(classRoom);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    }

