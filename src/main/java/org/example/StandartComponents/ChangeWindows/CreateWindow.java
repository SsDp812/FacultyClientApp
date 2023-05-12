package org.example.StandartComponents.ChangeWindows;

import org.example.AppWindows.ScheduleWindows.ScheduleWindow;

import javax.swing.*;

public class CreateWindow extends ScheduleWindow {
    public CreateWindow(String title, JFrame backFrame) {
        super(title, backFrame);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
