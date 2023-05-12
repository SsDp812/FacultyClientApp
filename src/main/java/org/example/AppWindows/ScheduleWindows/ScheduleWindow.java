package org.example.AppWindows.ScheduleWindows;

import org.example.AppWindows.ClassRoomsWindows.ClassRoomWindow;
import org.example.Entities.ClassRoom;
import org.example.Entities.Schedule;
import org.example.Services.ClassRoomService;
import org.example.Services.ScheduleService;
import org.example.StandartComponents.Panels.ChangePanel;
import org.example.StandartComponents.StandartWindow;
import org.example.Utils.InfoSplitter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ScheduleWindow extends StandartWindow {
    private ChangePanel changePanel;
    private ScheduleService service;

    private JScrollPane pane;

    private JFrame thisFrame;
    public ScheduleWindow(String title, JFrame backFrame) {
        super(title, backFrame);

        pane = new JScrollPane();
        container.add(pane);

        service = new ScheduleService();
        thisFrame = this;
        changePanel = new ChangePanel(this,"schedule");
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

                Schedule[] schedules = service.getAllSchedules();



                String[][] data = new String[schedules.length][7];


                for(int i = 0; i < data.length;i++){
                    data[i] = InfoSplitter.splitInfo(schedules[i].toString());
                    System.out.println(schedules[i].toString());
                }

                String[] cols = new String[]{"Id","ClassRoom","Day","Start","End","Course","Teacher"};




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
