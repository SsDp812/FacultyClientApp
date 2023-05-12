package org.example.StandartComponents.ChangeWindows;

import org.example.StandartComponents.StandartWindow;

import javax.swing.*;
import java.awt.*;

public class UpdateWindow extends StandartWindow {
    protected TextField idField;
    protected JButton updateBT;

    public TextField getIdField() {
        return idField;
    }

    public void setIdField(TextField idField) {
        this.idField = idField;
    }

    public JButton getUpdateBT() {
        return updateBT;
    }

    public void setUpdateBT(JButton updateBT) {
        this.updateBT = updateBT;
    }

    public UpdateWindow(String title, JFrame backFrame) {
        super(title, backFrame);
        updateBT = new JButton("Update");
        idField = new TextField("id");
        idField.setBounds(40,250,50,40);
        updateBT.setBounds(40,310,100,40);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
