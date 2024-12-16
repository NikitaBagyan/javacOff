package src.main.Week3.project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Schedule {

    private List<Lesson> lessons = new ArrayList<>();

    public boolean addLesson(Lesson lesson) {

        for (Lesson l : lessons) {
            if (l.getDate().equals(lesson.getDate())
                    && l.getTimeSlot().equals(lesson.getTimeSlot())
                    && l.getAudience().equals(lesson.getAudience())) {
                if (!l.getFlow().equals(lesson.getFlow())) {
                    System.out.println("Ошибка: аудитория занята студентами другого потока!");
                    return false;
                }
                System.out.println("Ошибка: аудитория уже занята в этот временной слот!");
                return false;
            }

            if (l.getDate().equals(lesson.getDate())
                    && l.getTimeSlot().equals(lesson.getTimeSlot())
                    && l.getGroup().equals(lesson.getGroup())) {
                System.out.println("У группы уже есть занятие в это время!");
                return false;
            }
        }
        lessons.add(lesson);
        return true;
    }


    public List<Lesson> getScheduleByAudience(Audience audience, LocalDate date) {
        List<Lesson> audienceSchedule = new ArrayList<>();
        for (Lesson lesson : lessons) {
            if (lesson.getAudience().equals(audience)
                    && lesson.getDate().equals(date)) {
                audienceSchedule.add(lesson);
            }
        }
        return audienceSchedule;
    }

    public List<Lesson> getWeeklyScheduleByAudience(Audience audience, LocalDate startOfWeek) {
        List<Lesson> weeklySchedule = new ArrayList<>();
        for (Lesson lesson : lessons) {
            if (lesson.getAudience().equals(audience)
                    && (lesson.getDate().isEqual(startOfWeek)
                    || (lesson.getDate().isAfter(startOfWeek)
                    && lesson.getDate().isBefore(startOfWeek.plusDays(7))))) {
                weeklySchedule.add(lesson);
            }
        }
        return weeklySchedule;
    }

    public List<Lesson> getScheduleByStudent(Student student, LocalDate date) {
        List<Lesson> studentSchedule = new ArrayList<>();
        for (Lesson lesson : lessons) {
            if (lesson.getGroup().getStudents().contains(student)
                    && lesson.getDate().equals(date)) {
                studentSchedule.add(lesson);
            }
        }
        return studentSchedule;
    }

    public List<Lesson> getWeeklyScheduleByStudent(Student student, LocalDate startOfWeek) {
        List<Lesson> weeklySchedule = new ArrayList<>();
        for (Lesson lesson : lessons) {
            if (lesson.getGroup().getStudents().contains(student)
                    && (lesson.getDate().isEqual(startOfWeek)
                    || (lesson.getDate().isAfter(startOfWeek)
                    && lesson.getDate().isBefore(startOfWeek.plusDays(7))))) {
                weeklySchedule.add(lesson);
            }
        }
        return weeklySchedule;
    }
}
