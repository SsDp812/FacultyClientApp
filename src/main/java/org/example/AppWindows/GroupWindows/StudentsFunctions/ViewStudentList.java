package org.example.AppWindows.GroupWindows.StudentsFunctions;

import org.example.Entities.Group;
import org.example.Entities.Student;
import org.example.Services.GroupService;
import org.example.StandartComponents.StandartWindow;
import org.example.Utils.InfoSplitter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class ViewStudentList extends StandartWindow {
    private JTextField idField;
    private JButton bt;

    private JScrollPane pane;
    private JFrame thisFrame;
    public ViewStudentList(String title, JFrame backFrame) {
        super(title, backFrame);
        this.thisFrame = this;
        pane = new JScrollPane();
        container.add(pane);
        idField = new JTextField("GroupID");
        idField.setBounds(20,250,100,40);
        bt = new JButton("Load");
        bt.addActionListener(new loadListener());
        bt.setBounds(20,310,100,40);
        container.add(bt);
        container.add(idField);

        this.setVisible(true);
    }


    class loadListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                GroupService service = new GroupService();

                List<Student> data = service.getGroupById(Long.parseLong(idField.getText())).getStudent();

                String[][] newData = new String[data.size()][8];

                for(int i = 0; i < data.size();i++){
                   newData[i] = InfoSplitter.splitInfo(data.get(i).toString());
                }

                String[] cols = new String[]{"Id","Name","Surname","Middle","Birthday","Address","Mobile","Mail"};




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
