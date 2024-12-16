package src.main.Week3.project.UI;

import src.main.Week3.project.Audience;
import src.main.Week3.project.Lesson;
import src.main.Week3.project.Schedule;
import src.main.Week3.project.Student;

import java.time.LocalDate;
import java.util.List;

public class ScheduleManagerImpl implements ScheduleManager {
    private final Schedule schedule = new Schedule();

    @Override
    public boolean addLesson(Lesson lesson) {
        return schedule.addLesson(lesson);
    }

    @Override
    public List<Lesson> getScheduleByAudience(Audience audience, LocalDate date) {
        return schedule.getScheduleByAudience(audience, date);
    }

    @Override
    public List<Lesson> getScheduleByStudent(Student student, LocalDate date) {
        return schedule.getScheduleByStudent(student, date);
    }
}
