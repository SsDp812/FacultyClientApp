package org.example.AppWindows.ScheduleWindows.UpdateAndCreate;

import org.example.Entities.Schedule;
import org.example.Services.ClassRoomService;
import org.example.Services.CourseService;
import org.example.Services.ScheduleService;
import org.example.Services.TeacherService;
import org.example.StandartComponents.StandartWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Time;

public class CreateSchedule extends StandartWindow {
    private JButton loadBT;


    private JTextField classRoomField;

    private JTextField dayOfWeekField;
    private JTextField startTimeField;
    private JTextField endTimeField;
    private JTextField courseField;
    private JTextField teacherField;


    public CreateSchedule(String title, JFrame backFrame) {
        super(title, backFrame);
        loadBT = new JButton("Create!");
        loadBT.setBounds(40,190,100,40);
        loadBT.addActionListener(new createService());
        container.add(loadBT);

        //idField.setBounds(40,250,50,40);
        //updateBT.setBounds(40,310,100,40);


        classRoomField = new JTextField("classID");
        dayOfWeekField = new JTextField("DayWeek");
        startTimeField = new JTextField("StartTime");
        endTimeField = new JTextField("EndTime");
        courseField = new JTextField("CourseID");
        teacherField = new JTextField("TeacherID");

        classRoomField.setBounds(120,250,100,40);
        dayOfWeekField.setBounds(240,250,100,40);
        startTimeField.setBounds(360,250,100,40);
        endTimeField.setBounds(480,250,100,40);
        courseField.setBounds(600,250,100,40);
        teacherField.setBounds(720,250,80,40);

        container.add(classRoomField);
        container.add(dayOfWeekField);
        container.add(startTimeField);
        container.add(endTimeField);
        container.add(courseField);
        container.add(teacherField);

        this.setVisible(true);
    }



    class createService implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ScheduleService scheduleService = new ScheduleService();
            ClassRoomService classRoomService = new ClassRoomService();
            CourseService courseService = new CourseService();
            TeacherService teacherService = new TeacherService();
            Schedule schedule;
            try {
                schedule = new Schedule(
                        classRoomService.getClassRoomById(Long.parseLong(classRoomField.getText())),
                        dayOfWeekField.getText(),
                        Time.valueOf(startTimeField.getText()),
                        Time.valueOf(endTimeField.getText()),
                        courseService.getCourseById(Long.parseLong(courseField.getText())),
                        teacherService.getTeacherById(Long.parseLong(teacherField.getText()))
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
                scheduleService.create(schedule);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
