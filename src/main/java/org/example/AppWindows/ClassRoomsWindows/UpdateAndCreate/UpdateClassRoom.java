package org.example.AppWindows.ClassRoomsWindows.UpdateAndCreate;

import org.example.Entities.ClassRoom;
import org.example.Services.ClassRoomService;
import org.example.StandartComponents.ChangeWindows.UpdateWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UpdateClassRoom extends UpdateWindow {
    private JButton loadBT;


    private JTextField nameField;
    private JTextField descField;
    private JTextField capacityField;

    public UpdateClassRoom(String title, JFrame backFrame) {
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

    class loadBTListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ClassRoomService service = new ClassRoomService();
            try {
                ClassRoom classRoom = service.getClassRoomById(Long.parseLong(idField.getText()));
                nameField.setText(classRoom.getName());
                descField.setText(classRoom.getDescription());
                capacityField.setText(String.valueOf(classRoom.getCapacity()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }
    }





    class updateService implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ClassRoomService service = new ClassRoomService();
            ClassRoom classRoom = new ClassRoom(
                    Long.parseLong(idField.getText()),
                    nameField.getText(),
                    descField.getText(),
                    (int) Long.parseLong(capacityField.getText())
            );
            try {
                service.update(classRoom);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
