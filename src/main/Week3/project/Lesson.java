package src.main.Week3.project;

import src.main.Week3.project.Flows.Flow;

import java.time.LocalDate;

public class Lesson {

    private Types types;
    private TimeSlot timeSlot;
    private Audience audience;
    private Group group;
    private Flow flow;
    private LocalDate date;

    public Lesson(Types types, TimeSlot timeSlot, Audience audience, Group group, Flow flow, LocalDate date) {
        this.types = types;
        this.timeSlot = timeSlot;
        this.audience = audience;
        this.group = group;
        this.flow = flow;
        this.date = date;
    }

    public Lesson(Types lessonType, TimeSlot timeSlot, Audience audience, Group group, LocalDate date) {
    }

    // Геттеры
    public Types getTypes() {
        return types;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public Audience getAudience() {
        return audience;
    }

    public Group getGroup() {
        return group;
    }

    public Flow getFlow() {
        return flow;
    }

    public LocalDate getDate() {
        return date;
    }
}





