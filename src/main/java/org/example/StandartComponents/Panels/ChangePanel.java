package org.example.StandartComponents.Panels;

import org.example.StandartComponents.Buttons.CreateButton;
import org.example.StandartComponents.Buttons.DeleteButton;
import org.example.StandartComponents.Buttons.UpdateButton;
import org.example.StandartComponents.ChangeWindows.DeleteWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePanel {
    private JPanel panel;
    private JFrame thisFrame;
    private String entityName;
    private DeleteButton deleteButton;
    private UpdateButton updateButton;
    private CreateButton createButton;

    public ChangePanel(JFrame thisFrame,String entityName){
        updateButton = new UpdateButton(thisFrame,entityName);
        createButton = new CreateButton(thisFrame,entityName);
        deleteButton = new DeleteButton(thisFrame,entityName);

        panel = new JPanel(new GridLayout(6,1));
        panel.add(updateButton.getButton());
        panel.add(deleteButton.getButton());
        panel.add(createButton.getButton());
        panel.setBounds(20,80,180,480);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void addButtonToCustomPanel(JButton button){
        panel.add(button);
    }

    class DeleteButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            DeleteWindow deleteWindow = new DeleteWindow(thisFrame,entityName);
        }
    }
}
