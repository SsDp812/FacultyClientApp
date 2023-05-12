package org.example.AppWindows.StudentWindows;

import org.example.AppWindows.ClassRoomsWindows.ClassRoomWindow;
import org.example.AppWindows.StudentWindows.CoursesFunctions.AddCourse;
import org.example.AppWindows.StudentWindows.CoursesFunctions.RemoveCourse;
import org.example.AppWindows.StudentWindows.CoursesFunctions.ViewCourses;
import org.example.Entities.ClassRoom;
import org.example.Entities.Student;
import org.example.Services.ClassRoomService;
import org.example.Services.StudentService;
import org.example.StandartComponents.Panels.ChangePanel;
import org.example.StandartComponents.StandartWindow;
import org.example.Utils.InfoSplitter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class StudentWindow extends StandartWindow {
    private ChangePanel changePanel;
    private StudentService service;

    private JScrollPane pane;

    private JFrame thisFrame;
    public StudentWindow(String title, JFrame backFrame) {
        super(title, backFrame);

        pane = new JScrollPane();
        container.add(pane);

        service = new StudentService();
        thisFrame = this;
        changePanel = new ChangePanel(this,"student");
        container.add(changePanel.getPanel());


        JButton buttonToView = new JButton("View Courses");
        JButton buttonToAdd = new JButton("Add Course");
        JButton buttonToDelete = new JButton("Delete Course");
        changePanel.addButtonToCustomPanel(buttonToView);
        changePanel.addButtonToCustomPanel(buttonToAdd);
        changePanel.addButtonToCustomPanel(buttonToDelete);

        buttonToView.addActionListener(new viewListener());
        buttonToAdd.addActionListener(new addListener());
        buttonToDelete.addActionListener(new deleteListener());



        JButton refresh = new JButton("Load");
        refresh.setBounds(240,40,520,40);
        refresh.addActionListener(new loadListener());
        container.add(refresh);
        this.setVisible(true);
    }


    class viewListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ViewCourses window = new ViewCourses("View",thisFrame);
        }
    }


    class addListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            AddCourse window = new AddCourse("Add",thisFrame);
        }
    }

    class deleteListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            RemoveCourse window = new RemoveCourse("Remove",thisFrame);
        }
    }



    class loadListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                container.remove(pane);

                Student[] students = service.getAllStudents();



                String[][] data = new String[students.length][8];


                for(int i = 0; i < data.length;i++){
                    data[i] = InfoSplitter.splitInfo(students[i].toString());
                    System.out.println(students[i].toString());
                }

                String[] cols = new String[]{"Id","Name","Surname","MiddleName","Birthday","Address","Mobile","Mail"};




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
