package org.example.AppWindows.CourseWindows;

import org.example.AppWindows.ClassRoomsWindows.ClassRoomWindow;
import org.example.Entities.ClassRoom;
import org.example.Entities.Course;
import org.example.Services.ClassRoomService;
import org.example.Services.CourseService;
import org.example.StandartComponents.Panels.ChangePanel;
import org.example.StandartComponents.StandartWindow;
import org.example.Utils.InfoSplitter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CourseWindow extends StandartWindow {
    private ChangePanel changePanel;
    private CourseService service;

    private JScrollPane pane;

    private JFrame thisFrame;
    public CourseWindow(String title, JFrame backFrame) {
        super(title, backFrame);

        pane = new JScrollPane();
        container.add(pane);

        service = new CourseService();
        thisFrame = this;
        changePanel = new ChangePanel(this,"course");
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

                Course[] courses = service.getAllCourses();



                String[][] data = new String[courses.length][4];


                for(int i = 0; i < data.length;i++){
                    data[i] = InfoSplitter.splitInfo(courses[i].toString());
                    System.out.println(courses[i].toString());
                }

                String[] cols = new String[]{"Id","Name","Description","Teacher"};




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
