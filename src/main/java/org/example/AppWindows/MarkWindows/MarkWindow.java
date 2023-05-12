package org.example.AppWindows.MarkWindows;

import org.example.AppWindows.ClassRoomsWindows.ClassRoomWindow;
import org.example.Entities.ClassRoom;
import org.example.Entities.Mark;
import org.example.Services.ClassRoomService;
import org.example.Services.MarkService;
import org.example.StandartComponents.Panels.ChangePanel;
import org.example.StandartComponents.StandartWindow;
import org.example.Utils.InfoSplitter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MarkWindow extends StandartWindow {
    private ChangePanel changePanel;
    private MarkService service;

    private JScrollPane pane;

    private JFrame thisFrame;
    public MarkWindow(String title, JFrame backFrame) {
        super(title, backFrame);

        pane = new JScrollPane();
        container.add(pane);

        service = new MarkService();
        thisFrame = this;
        changePanel = new ChangePanel(this,"mark");
        container.add(changePanel.getPanel());
        JButton refresh = new JButton("Load");
        refresh.setBounds(240,40,520,40);
        refresh.addActionListener(new loadListener());
        container.add(refresh);
        this.setVisible(true);
    }

    class loadListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                container.remove(pane);

                Mark[] marks = service.getAllMarks();



                String[][] data = new String[marks.length][4];


                for(int i = 0; i < data.length;i++){
                    data[i] = InfoSplitter.splitInfo(marks[i].toString());
                    System.out.println(marks[i].toString());
                }

                String[] cols = new String[]{"Id","Course","Student","Score"};




                TableModel model = new DefaultTableModel();
                ((DefaultTableModel) model).setColumnIdentifiers(cols);
                // Наполнение модели данными
                for (int i = 0; i < data.length; i++)
                    ((DefaultTableModel) model).addRow(data[i]);

                // Создание таблицы на основании модели данных
                JTable table1 = new JTable(model);

                pane = new JScrollPane(table1);

                //JTable table1 = new JTable(data,cols);
                pane.setBounds(240,140,520,440);

                container.add(pane);
                thisFrame.repaint();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
