package src.main.Week3.project.UI;

import src.main.Week3.project.Audience;
import src.main.Week3.project.Lesson;
import src.main.Week3.project.Student;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleManager {
    boolean addLesson(Lesson lesson);
    List<Lesson> getScheduleByAudience(Audience audience, LocalDate date);
    List<Lesson> getScheduleByStudent(Student student, LocalDate date);
}
