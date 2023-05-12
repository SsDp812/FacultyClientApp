package org.example.AppWindows.ScheduleWindows.UpdateAndCreate;

import org.example.AppWindows.MarkWindows.UpdateAndCreate.UpdateMark;
import org.example.Entities.ClassRoom;
import org.example.Entities.Mark;
import org.example.Entities.Schedule;
import org.example.Services.*;
import org.example.StandartComponents.ChangeWindows.UpdateWindow;

import javax.security.auth.kerberos.KerberosTicket;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Time;

public class UpdateSchedule extends UpdateWindow {
    private JButton loadBT;


    private JTextField classRoomField;

    private JTextField dayOfWeekField;
    private JTextField startTimeField;
    private JTextField endTimeField;
    private JTextField courseField;
    private JTextField teacherField;


    public UpdateSchedule(String title, JFrame backFrame) {
        super(title, backFrame);
        loadBT = new JButton("Load by Id");
        loadBT.setBounds(40,190,100,40);
        loadBT.addActionListener(new loadBTListener());
        updateBT.addActionListener(new updateService());
        container.add(loadBT);
        container.add(updateBT);
        container.add(idField);

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

    class loadBTListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ScheduleService service = new ScheduleService();
            try {
                Schedule schedule = service.getScheduleById(((Long.parseLong(idField.getText()))));
              classRoomField.setText(schedule.getClassRoom().getId().toString());
              dayOfWeekField.setText(schedule.getDayOfWeek());
              startTimeField.setText(schedule.getStart_time().toString());
              endTimeField.setText(schedule.getEnd_time().toString());
              courseField.setText(schedule.getCourse().getId().toString());
              teacherField.setText(schedule.getTeacher().getId().toString());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }
    }



    class updateService implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           ScheduleService scheduleService = new ScheduleService();
           ClassRoomService classRoomService = new ClassRoomService();
          CourseService courseService = new CourseService();
            TeacherService teacherService = new TeacherService();
            Schedule schedule;
            try {
                schedule = new Schedule(
                        Long.parseLong(idField.getText()),
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
                scheduleService.update(schedule);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
