package src.test.Week3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import src.main.Week3.project.*;
import src.main.Week3.project.Flows.Flow;
import src.main.Week3.project.Flows.FlowTypes;
import src.main.Week3.project.Flows.Humanitarian;
import src.main.Week3.project.Flows.Mathematics;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class ScheduleTest {
    private Schedule schedule;
    private Audience lectureRoom;
    private Audience labRoom;
    private Group group1;
    private Group group2;
    private Flow humanitarianFlow;
    private Flow mathFlow;

    @BeforeEach
    void setUp() {
        schedule = new Schedule();

        // Создаем аудитории
        lectureRoom = new Audience(Types.LECTURE, "101");
        labRoom = new Audience(Types.LABORATORY, "201");

        // Создаем группы
        group1 = new Group();
        group2 = new Group();

        // Создаем потоки
        humanitarianFlow = new Humanitarian(FlowTypes.HUMANITARIAN);
        mathFlow = new Mathematics(FlowTypes.MATH);

        // Добавляем группы в потоки
        humanitarianFlow.addToFlow(group1);
        mathFlow.addToFlow(group2);
    }

    @Test
    @DisplayName("Успешное добавление занятия в расписание при отсутствии конфликтов")
    void testAddLessonSuccessfully() {
        LocalDate date = LocalDate.now();
        Lesson lesson = new Lesson(Types.LECTURE, TimeSlot.SLOT_1, lectureRoom, group1, humanitarianFlow, date);

        boolean added = schedule.addLesson(lesson);
        assertTrue(added, "Занятие должно быть добавлено успешно");
    }

    @Test
    @DisplayName("Ошибка добавления занятия из-за конфликта по аудитории в тот же временной слот")
    void testAddLessonFailsDueToRoomConflict() {
        LocalDate date = LocalDate.now();

        // Добавляем первое занятие
        Lesson lesson1 = new Lesson(Types.LECTURE, TimeSlot.SLOT_1, lectureRoom, group1, humanitarianFlow, date);
        schedule.addLesson(lesson1);

        // Добавляем второе занятие в ту же аудиторию и слот
        Lesson lesson2 = new Lesson(Types.SEMINAR, TimeSlot.SLOT_1, lectureRoom, group2, humanitarianFlow, date);
        boolean added = schedule.addLesson(lesson2);

        assertFalse(added, "Занятие не должно быть добавлено из-за конфликта по аудитории");
    }

    @Test
    @DisplayName("Ошибка добавления занятия из-за конфликта по времени для группы")
    void testAddLessonFailsDueToGroupConflict() {
        LocalDate date = LocalDate.now();

        // Добавляем первое занятие для группы 1
        Lesson lesson1 = new Lesson(Types.LECTURE, TimeSlot.SLOT_1, lectureRoom, group1, humanitarianFlow, date);
        schedule.addLesson(lesson1);

        // Попробуем добавить другое занятие для той же группы в тот же слот, но в другую аудиторию
        Lesson lesson2 = new Lesson(Types.SEMINAR, TimeSlot.SLOT_1, labRoom, group1, humanitarianFlow, date);
        boolean added = schedule.addLesson(lesson2);

        assertFalse(added, "Занятие не должно быть добавлено из-за конфликта по времени для группы");
    }

    @Test
    @DisplayName("Ошибка добавления занятия из-за конфликта потоков в одной аудитории на одно время")
    void testAddLessonFailsDueToFlowConflict() {
        LocalDate date = LocalDate.now();

        // Добавляем занятие для гуманитарного потока
        Lesson lesson1 = new Lesson(Types.LECTURE, TimeSlot.SLOT_1, lectureRoom, group1, humanitarianFlow, date);
        schedule.addLesson(lesson1);

        // Попробуем добавить занятие для математического потока в ту же аудиторию и слот
        Lesson lesson2 = new Lesson(Types.SEMINAR, TimeSlot.SLOT_1, lectureRoom, group2, mathFlow, date);
        boolean added = schedule.addLesson(lesson2);

        assertFalse(added, "Занятие не должно быть добавлено из-за конфликта по потоку в той же аудитории");
    }
}

