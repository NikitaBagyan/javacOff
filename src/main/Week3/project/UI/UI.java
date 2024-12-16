package src.main.Week3.project.UI;

import src.main.Week3.project.*;
import src.main.Week3.project.Flows.Flow;
import src.main.Week3.project.Flows.FlowTypes;
import src.main.Week3.project.Flows.Humanitarian;
import src.main.Week3.project.Flows.Mathematics;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class UI {
    private final AudienceManager audienceManager;
    private final GroupManager groupManager;
    private final ScheduleManager scheduleManager;
    private final InputHandler inputHandler;

    public UI(AudienceManager audienceManager, GroupManager groupManager, ScheduleManager scheduleManager) {
        this.audienceManager = audienceManager;
        this.groupManager = groupManager;
        this.scheduleManager = scheduleManager;
        this.inputHandler = new InputHandler();
    }

    public void start() {
        boolean running = true;
        while (running) {
            inputHandler.print("""
                    Выберите действие:
                    1. Добавить аудиторию
                    2. Добавить группу
                    3. Добавить студента в группу
                    4. Добавить занятие
                    5. Показать расписание аудитории
                    6. Показать расписание студента
                    7. Выход
                    """);

            int choice = inputHandler.getIntInput("Ваш выбор:");
            switch (choice) {
                case 1 -> handleAddAudience();
                case 2 -> handleAddGroup();
                case 3 -> handleAddStudentToGroup();
                case 4 -> handleAddLesson();
                case 5 -> handleShowScheduleByAudience();
                case 6 -> handleShowScheduleByStudent();
                case 7 -> running = false;
                default -> inputHandler.print("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private void handleAddAudience() {
        String roomNumber = inputHandler.getStringInput("Введите номер аудитории:");
        List<Types> audienceTypes = audienceManager.getAudienceTypes();
        inputHandler.print("Выберите тип аудитории:");
        for (int i = 0; i < audienceTypes.size(); i++) {
            inputHandler.print((i + 1) + ". " + audienceTypes.get(i));
        }
        int typeIndex = inputHandler.getIntInput("Ваш выбор:");
        audienceManager.addAudience(roomNumber, typeIndex);
    }

    private void handleAddGroup() {
        groupManager.addGroup();
    }

    private void handleAddStudentToGroup() {
        String studentName = inputHandler.getStringInput("Введите имя студента:");
        List<Group> groups = groupManager.getGroups();
        inputHandler.print("Выберите группу:");
        for (int i = 0; i < groups.size(); i++) {
            inputHandler.print((i + 1) + ". Группа " + (i + 1));
        }
        int groupIndex = inputHandler.getIntInput("Ваш выбор:");
        groupManager.addStudentToGroup(studentName, groupIndex);
    }

    private void handleAddLesson() {
        // Ввод даты занятия
        String dateString = inputHandler.getStringInput("Введите дату занятия (ГГГГ-ММ-ДД):");
        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);

        // Выбор типа занятия
        List<Types> types = audienceManager.getAudienceTypes();
        inputHandler.print("Выберите тип занятия:");
        for (int i = 0; i < types.size(); i++) {
            inputHandler.print((i + 1) + ". " + types.get(i));
        }
        int typeIndex = inputHandler.getIntInput("Ваш выбор:");
        Types lessonType = types.get(typeIndex - 1);

        // Выбор времени занятия
        TimeSlot[] slots = TimeSlot.values();
        inputHandler.print("Выберите слот времени:");
        for (int i = 0; i < slots.length; i++) {
            inputHandler.print((i + 1) + ". " + slots[i]);
        }
        int slotIndex = inputHandler.getIntInput("Ваш выбор:");
        TimeSlot timeSlot = slots[slotIndex - 1];

        // Выбор аудитории
        List<Audience> audiences = audienceManager.getAudiences();
        inputHandler.print("Выберите аудиторию:");
        for (int i = 0; i < audiences.size(); i++) {
            inputHandler.print((i + 1) + ". " + audiences.get(i));
        }
        int audienceIndex = inputHandler.getIntInput("Ваш выбор:");
        Audience audience = audiences.get(audienceIndex - 1);

        // Выбор группы
        List<Group> groups = groupManager.getGroups();
        inputHandler.print("Выберите группу:");
        for (int i = 0; i < groups.size(); i++) {
            inputHandler.print((i + 1) + ". Группа " + (i + 1));
        }
        int groupIndex = inputHandler.getIntInput("Ваш выбор:");
        Group group = groups.get(groupIndex - 1);

        // Выбор потока
        inputHandler.print("Выберите поток:");
        inputHandler.print("1. Гуманитарный поток");
        inputHandler.print("2. Математический поток");
        int flowChoice = inputHandler.getIntInput("Ваш выбор:");
        Flow flow = (flowChoice == 1) ? new Humanitarian(FlowTypes.HUMANITARIAN) : new Mathematics(FlowTypes.MATH);

        // Создание и добавление занятия
        Lesson lesson = new Lesson(lessonType, timeSlot, audience, group, flow, date);
        if (scheduleManager.addLesson(lesson)) {
            inputHandler.print("Занятие успешно добавлено.");
        } else {
            inputHandler.print("Не удалось добавить занятие. Возможен конфликт.");
        }
    }


    private void handleShowScheduleByAudience() {
        // Выбор аудитории
        List<Audience> audiences = audienceManager.getAudiences();
        inputHandler.print("Выберите аудиторию:");
        for (int i = 0; i < audiences.size(); i++) {
            inputHandler.print((i + 1) + ". " + audiences.get(i));
        }
        int audienceIndex = inputHandler.getIntInput("Ваш выбор:");
        Audience audience = audiences.get(audienceIndex - 1);

        // Выбор периода
        inputHandler.print("Выберите период для расписания:");
        inputHandler.print("1. Сегодня");
        inputHandler.print("2. Неделя");
        int periodChoice = inputHandler.getIntInput("Ваш выбор:");

        if (periodChoice == 1) {
            // Расписание на сегодня
            LocalDate today = LocalDate.now();
            List<Lesson> dailySchedule = scheduleManager.getScheduleByAudience(audience, today);
            inputHandler.print("Расписание на сегодня для " + audience + ":");
            dailySchedule.forEach(lesson -> inputHandler.print(lesson.getTimeSlot() + ": " + lesson.getTypes()));
        } else {
            // Расписание на неделю
            LocalDate startOfWeek = LocalDate.now();
            List<Lesson> weeklySchedule = scheduleManager.getScheduleByAudience(audience, startOfWeek);
            inputHandler.print("Расписание на неделю для " + audience + ":");
            weeklySchedule.forEach(lesson -> inputHandler.print(lesson.getDate() + " " + lesson.getTimeSlot() + ": " + lesson.getTypes()));
        }
    }


    private void handleShowScheduleByStudent() {
        // Ввод имени студента
        String studentName = inputHandler.getStringInput("Введите имя студента:");
        Student student = findStudentByName(studentName);

        if (student == null) {
            inputHandler.print("Студент не найден.");
            return;
        }

        // Выбор периода
        inputHandler.print("Выберите период для расписания:");
        inputHandler.print("1. Сегодня");
        inputHandler.print("2. Неделя");
        int periodChoice = inputHandler.getIntInput("Ваш выбор:");

        if (periodChoice == 1) {
            // Расписание на сегодня
            LocalDate today = LocalDate.now();
            List<Lesson> dailySchedule = scheduleManager.getScheduleByStudent(student, today);
            inputHandler.print("Расписание на сегодня для студента " + studentName + ":");
            dailySchedule.forEach(lesson -> inputHandler.print(lesson.getTimeSlot() + ": " + lesson.getTypes() + " в " + lesson.getAudience()));
        } else {
            // Расписание на неделю
            LocalDate startOfWeek = LocalDate.now();
            List<Lesson> weeklySchedule = scheduleManager.getScheduleByStudent(student, startOfWeek);
            inputHandler.print("Расписание на неделю для студента " + studentName + ":");
            weeklySchedule.forEach(lesson -> inputHandler.print(lesson.getDate() + " " + lesson.getTimeSlot() + ": " + lesson.getTypes() + " в " + lesson.getAudience()));
        }
    }

    private Student findStudentByName(String studentName) {
        for (Group group : groupManager.getGroups()) {
            for (Student student : group.getStudents()) {
                if (student.getName().equalsIgnoreCase(studentName)) {
                    return student;
                }
            }
        }
        return null;
    }


}
