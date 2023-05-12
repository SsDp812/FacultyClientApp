package org.example.StandartComponents.Panels;

import org.example.AppWindows.ClassRoomsWindows.ClassRoomWindow;
import org.example.AppWindows.CourseWindows.CourseWindow;
import org.example.AppWindows.FacultyWindows.FacultyWindow;
import org.example.AppWindows.GroupWindows.GroupWindow;
import org.example.AppWindows.MarkWindows.MarkWindow;
import org.example.AppWindows.ScheduleWindows.ScheduleWindow;
import org.example.AppWindows.StudentWindows.StudentWindow;
import org.example.AppWindows.TeacherWindows.TeacherWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel {

     public JPanel getMainPanel(JFrame thisFrame){
        JPanel buttonPanel = new JPanel(new GridLayout(4,2));
        JButton classRoom = new JButton("ClassRooms");
        panelListener listener = new panelListener(thisFrame);
        classRoom.setActionCommand("classRoom"); ///
         classRoom.addActionListener(listener);
        JButton course = new JButton("Courses");
        course.setActionCommand("course"); ///
         course.addActionListener(listener);
        JButton faculty = new JButton("Facultis");
        faculty.setActionCommand("faculty"); ///
         faculty.addActionListener(listener);
        JButton group = new JButton("Groups");
        group.setActionCommand("group"); ///
         group.addActionListener(listener);
        JButton mark = new JButton("Marks");
        mark.setActionCommand("mark"); ///
         mark.addActionListener(listener);
        JButton schedule = new JButton("Schedules");
        schedule.setActionCommand("schedule"); ///
         schedule.addActionListener(listener);
        JButton student = new JButton("Students");
        student.setActionCommand("student"); ///
         student.addActionListener(listener);
        JButton teacher = new JButton("Teachers");
        teacher.setActionCommand("teacher"); ///
         teacher.addActionListener(listener);
        buttonPanel.add(classRoom);
        buttonPanel.add(course);
        buttonPanel.add(faculty);
        buttonPanel.add(group);
        buttonPanel.add(mark);
        buttonPanel.add(schedule);
        buttonPanel.add(student);
        buttonPanel.add(teacher);
        return buttonPanel;
    }

    protected class panelListener implements ActionListener{
        private JFrame thisFrame;
        public panelListener(JFrame thisFrame){
            this.thisFrame = thisFrame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()){
                case "classRoom":
                    ClassRoomWindow window = new ClassRoomWindow("ClassRooms",thisFrame);
                    thisFrame.setVisible(false);
                    break;
                case "course":
                    CourseWindow courseWindow = new CourseWindow("Courses",thisFrame);
                    thisFrame.setVisible(false);
                    break;
                case "faculty":
                    FacultyWindow facultyWindow =  new FacultyWindow("Faculties",thisFrame);
                    thisFrame.setVisible(false);
                    break;
                case "group":
                    GroupWindow groupWindow = new GroupWindow("Groups",thisFrame);
                    thisFrame.setVisible(false);
                    break;
                case "mark":
                    MarkWindow markWindow = new MarkWindow("Marks",thisFrame);
                    thisFrame.setVisible(false);
                    break;
                case "schedule":
                    ScheduleWindow scheduleWindow = new ScheduleWindow("Schedules",thisFrame);
                    thisFrame.setVisible(false);
                    break;
                case "student":
                    StudentWindow studentWindow = new StudentWindow("Students",thisFrame);
                    thisFrame.setVisible(false);
                    break;
                case "teacher":
                    TeacherWindow teacherWindow = new TeacherWindow("Teachers",thisFrame);
                    thisFrame.setVisible(false);
                    break;

            }
        }
    }
}
