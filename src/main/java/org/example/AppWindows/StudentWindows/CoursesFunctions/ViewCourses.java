package org.example.AppWindows.StudentWindows.CoursesFunctions;

import org.example.AppWindows.GroupWindows.StudentsFunctions.ViewStudentList;
import org.example.Entities.Course;
import org.example.Entities.Student;
import org.example.Services.GroupService;
import org.example.Services.StudentService;
import org.example.StandartComponents.StandartWindow;
import org.example.Utils.InfoSplitter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class ViewCourses extends StandartWindow {
    private JTextField idField;
    private JButton bt;

    private JScrollPane pane;
    private JFrame thisFrame;
    public ViewCourses(String title, JFrame backFrame) {
        super(title, backFrame);
        this.thisFrame = this;
        pane = new JScrollPane();
        container.add(pane);
        idField = new JTextField("StudentID");
        idField.setBounds(20,250,100,40);
        bt = new JButton("Load");
        bt.addActionListener(new loadListener());
        bt.setBounds(20,310,100,40);
        container.add(bt);
        container.add(idField);

        this.setVisible(true);
    }


    class loadListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                StudentService service = new StudentService();

                List<Course> data = service.getStudentById(Long.parseLong(idField.getText())).getCourses();

                String[][] newData = new String[data.size()][4];

                for(int i = 0; i < data.size();i++){
                    newData[i] = InfoSplitter.splitInfo(data.get(i).toString());
                }

                String[] cols = new String[]{"Id","Name","Description","Teacher"};




                TableModel model = new DefaultTableModel();
                ((DefaultTableModel) model).setColumnIdentifiers(cols);
                // Наполнение модели данными
                for (int i = 0; i < newData.length; i++)
                    ((DefaultTableModel) model).addRow(newData[i]);

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
