package org.example.AppWindows;

import org.example.StandartComponents.Panels.MainPanel;
import org.example.StandartComponents.StandartWindow;

import javax.swing.*;

public class MainWindow extends StandartWindow {
    protected JPanel panel;
    protected MainPanel mainPanel;
    public MainWindow(String title) {
        super(title);
        mainPanel = new MainPanel();
        panel = mainPanel.getMainPanel(this);
        panel.setBounds(200,100,400,400);
        container.add(panel);
        this.setVisible(true);
    }
}
