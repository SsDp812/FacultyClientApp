package org.example.StandartComponents;

import org.example.StandartComponents.Buttons.BackButton;

import javax.swing.*;
import java.awt.*;

public class StandartWindow extends JFrame {
    protected Container container;
    protected BackButton backButton;

    public Container getContainer() {
        return container;
    }

    public StandartWindow(String title){
        super(title);
        container = this.getContentPane();
        this.setResizable(false);
        this.setLayout(null);
        this.setBounds(40,40,800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public StandartWindow(String title,JFrame backFrame){
        super(title);
        container = this.getContentPane();
        this.setResizable(false);
        this.setLayout(null);
        this.setBounds(40,40,800,600);
        backButton = new BackButton(backFrame,this);
        container.add(backButton.getBackButton());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
