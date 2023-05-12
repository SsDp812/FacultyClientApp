package org.example.StandartComponents.Buttons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackButton {
    private JButton backButton;

    public BackButton(JFrame backFrame,JFrame thisFrame){
        backButton = new JButton("Back");
        backButton.setBounds(20,20,100,40);
        backButton.addActionListener(new backListener(backFrame,thisFrame));
    }

    public JButton getBackButton() {
        return backButton;
    }

    private class backListener implements ActionListener{
        private JFrame backFrame;
        private JFrame thisFrame;
        public backListener(JFrame backFrame, JFrame thisFrame){
            this.backFrame = backFrame;
            this.thisFrame = thisFrame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            backFrame.setVisible(true);
            thisFrame.dispose();
        }
    }
}
