package org.example.StandartComponents.Buttons;

import org.example.StandartComponents.ChangeWindows.DeleteWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteButton {
    private String entityName;

    private JButton button;
    private JFrame backFrame;

    public JButton getButton() {
        return button;
    }

    public DeleteButton(JFrame backFrame, String entityName){
        this.entityName = entityName;
        this.backFrame = backFrame;
        button = new JButton("Delete");
        button.addActionListener(new deleteButtonListener());
        backFrame.setVisible(false);
    }

    private class deleteButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            DeleteWindow deleteWindow = new DeleteWindow(backFrame,entityName);

        }
    }
}
