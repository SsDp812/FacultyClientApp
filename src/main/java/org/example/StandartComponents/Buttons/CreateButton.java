package org.example.StandartComponents.Buttons;

import org.example.AppWindows.ClassRoomsWindows.UpdateAndCreate.CreateClassRoom;
import org.example.AppWindows.ClassRoomsWindows.UpdateAndCreate.UpdateClassRoom;
import org.example.AppWindows.CourseWindows.UpdateAndCreate.CreateCourse;
import org.example.AppWindows.CourseWindows.UpdateAndCreate.UpdateCourse;
import org.example.AppWindows.FacultyWindows.UpdateAndCreate.CreateFaculty;
import org.example.AppWindows.FacultyWindows.UpdateAndCreate.UpdateFaculty;
import org.example.AppWindows.GroupWindows.UpdateAndCreate.CreateGroup;
import org.example.AppWindows.GroupWindows.UpdateAndCreate.GroupUpdate;
import org.example.AppWindows.MarkWindows.UpdateAndCreate.CreateMark;
import org.example.AppWindows.MarkWindows.UpdateAndCreate.UpdateMark;
import org.example.AppWindows.ScheduleWindows.UpdateAndCreate.CreateSchedule;
import org.example.AppWindows.ScheduleWindows.UpdateAndCreate.UpdateSchedule;
import org.example.AppWindows.StudentWindows.UpdateAndCreate.CreateStudent;
import org.example.AppWindows.StudentWindows.UpdateAndCreate.UpdateStudent;
import org.example.AppWindows.TeacherWindows.UpdateAndCreate.CreateTeacher;
import org.example.AppWindows.TeacherWindows.UpdateAndCreate.UpdateTeacher;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateButton {
    private String entityName;

    private JButton button;
    private JFrame back;

    public JButton getButton() {
        return button;
    }

    public CreateButton(JFrame backFrame,String entityName){
        this.entityName = entityName;
        button = new JButton("Create");
        button.addActionListener(new createListener());
        this.back = backFrame;
        backFrame.setVisible(false);
    }

    private class createListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (entityName){
                case "classRoom":
                    CreateClassRoom classRoom = new CreateClassRoom("Create",back);
                    break;
                case "course":
                    CreateCourse course = new CreateCourse("Create",back);
                    break;
                case "faculty":
                    CreateFaculty faculty = new CreateFaculty("Create",back);
                    break;
                case "group":
                    CreateGroup group = new CreateGroup("Create",back);
                    break;
                case "mark":
                    CreateMark mark = new CreateMark("Create",back);
                    break;
                case "schedule":
                    CreateSchedule schedule = new CreateSchedule("Create",back);
                    break;
                case "student":
                    CreateStudent student = new CreateStudent("Create",back);
                    break;
                case "teacher":
                    CreateTeacher teacher = new CreateTeacher("Create",back);
                    break;
            }
        }
    }
}
