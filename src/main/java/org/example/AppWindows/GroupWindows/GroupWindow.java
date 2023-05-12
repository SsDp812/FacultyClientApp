package org.example.AppWindows.GroupWindows;

import org.example.AppWindows.ClassRoomsWindows.ClassRoomWindow;
import org.example.AppWindows.GroupWindows.StudentsFunctions.AddStudentToGroup;
import org.example.AppWindows.GroupWindows.StudentsFunctions.RemoveStuden;
import org.example.AppWindows.GroupWindows.StudentsFunctions.ViewStudentList;
import org.example.AppWindows.StudentWindows.StudentWindow;
import org.example.Entities.ClassRoom;
import org.example.Entities.Group;
import org.example.Services.ClassRoomService;
import org.example.Services.GroupService;
import org.example.StandartComponents.Panels.ChangePanel;
import org.example.StandartComponents.StandartWindow;
import org.example.Utils.InfoSplitter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GroupWindow extends StandartWindow {
    private ChangePanel changePanel;
    private GroupService service;

    private JScrollPane pane;
    private JFrame thisFrame;

    public GroupWindow(String title, JFrame backFrame) {
        super(title, backFrame);

        pane = new JScrollPane();
        container.add(pane);

        service = new GroupService();
        thisFrame = this;
        changePanel = new ChangePanel(this,"group");


        JButton buttonToView = new JButton("View Students");
        JButton buttonToAdd = new JButton("Add Student");
        JButton buttonToDelete = new JButton("Delete Student");
        changePanel.addButtonToCustomPanel(buttonToView);
        changePanel.addButtonToCustomPanel(buttonToAdd);
        changePanel.addButtonToCustomPanel(buttonToDelete);

        buttonToView.addActionListener(new viewListener());
        buttonToAdd.addActionListener(new addListener());
        buttonToDelete.addActionListener(new deleteListener());

        container.add(changePanel.getPanel());
        JButton refresh = new JButton("Load");
        refresh.setBounds(240,40,520,40);
        refresh.addActionListener(new loadListener());
        container.add(refresh);
        this.setVisible(true);
    }




    class viewListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ViewStudentList window = new ViewStudentList("View",thisFrame);
        }
    }


    class addListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            AddStudentToGroup window = new AddStudentToGroup("Add",thisFrame);
        }
    }

    class deleteListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            RemoveStuden window = new RemoveStuden("Remove",thisFrame);
        }
    }


    class loadListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                container.remove(pane);

                Group[] groups = service.getAllGroups();



                String[][] data = new String[groups.length][4];


                for(int i = 0; i < data.length;i++){
                    data[i] = InfoSplitter.splitInfo(groups[i].toString());
                    System.out.println(groups[i].toString());
                }

                String[] cols = new String[]{"Id","Name","Course","Student"};




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
