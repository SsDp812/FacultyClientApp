package org.example.StandartComponents.Buttons;

import org.example.AppWindows.ClassRoomsWindows.UpdateAndCreate.UpdateClassRoom;
import org.example.AppWindows.CourseWindows.UpdateAndCreate.UpdateCourse;
import org.example.AppWindows.FacultyWindows.UpdateAndCreate.UpdateFaculty;
import org.example.AppWindows.GroupWindows.UpdateAndCreate.GroupUpdate;
import org.example.AppWindows.MarkWindows.UpdateAndCreate.UpdateMark;
import org.example.AppWindows.ScheduleWindows.UpdateAndCreate.UpdateSchedule;
import org.example.AppWindows.StudentWindows.UpdateAndCreate.UpdateStudent;
import org.example.AppWindows.TeacherWindows.UpdateAndCreate.UpdateTeacher;
import org.example.Services.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UpdateButton {
    private String entityName;
    private JButton button;
    private JFrame back;

    public JButton getButton() {
        return button;
    }

    public UpdateButton(JFrame backFrame, String entityName){
        this.entityName = entityName;
        this.back = backFrame;
        button = new JButton("Update!");

        button.addActionListener(new updateWindowSwitcher());
        backFrame.setVisible(false);
    }

    private class updateWindowSwitcher implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (entityName){
                case "classRoom":
                    UpdateClassRoom window = new UpdateClassRoom("Update",back);
                    break;
                case "course":
                    UpdateCourse updateCourse = new UpdateCourse("Update",back);
                    break;
                case "faculty":
                    UpdateFaculty updateFaculty = new UpdateFaculty("Update",back);
                    break;
                case "group":
                    GroupUpdate updateGroup = new GroupUpdate("Update",back);
                    break;
                case "mark":
                    UpdateMark updateMark = new UpdateMark("Update",back);
                    break;
                case "schedule":
                    UpdateSchedule updateSchedule = new UpdateSchedule("Update",back);
                    break;
                case "student":
                    UpdateStudent updateStudent = new UpdateStudent("Update",back);
                    break;
                case "teacher":
                    UpdateTeacher updateTeacher = new UpdateTeacher("Update",back);
                    break;
            }
        }
    }


}
