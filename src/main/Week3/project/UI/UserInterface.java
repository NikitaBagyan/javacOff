package src.main.Week3.project.UI;/*
package src.main.Week3.project.UI;

import src.main.Week3.project.*;
import src.main.Week3.project.Flows.Flow;
import src.main.Week3.project.Flows.FlowTypes;
import src.main.Week3.project.Flows.Humanitarian;
import src.main.Week3.project.Flows.Mathematics;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Schedule schedule = new Schedule();
    private List<Group> groups = new ArrayList<>();
    private List<Audience> audiences = new ArrayList<>();
    private List<Types> audienceTypes = Arrays.asList(Types.values());

    private Scanner scanner = new Scanner(System.in);

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить аудиторию");
            System.out.println("2. Добавить группу");
            System.out.println("3. Добавить студента в группу");
            System.out.println("4. Добавить занятие");
            System.out.println("5. Показать расписание аудитории");
            System.out.println("6. Показать расписание студента");
            System.out.println("7. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addAudience();
                    break;
                case 2:
                    addGroup();
                    break;
                case 3:
                    addStudentToGroup();
                    break;
                case 4:
                    addLesson();
                    break;
                case 5:
                    showScheduleByAudience();
                    break;
                case 6:
                    showScheduleByStudent();
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }


    }

    private void addAudience() {
        System.out.print("Введите номер аудитории: ");
        String roomNumber = scanner.nextLine();

        System.out.println("Выберите тип аудитории:");
        for (Types type : audienceTypes) {
            System.out.println(type.ordinal() + 1 + ". " + type);
        }
        int typeChoice = scanner.nextInt();
        scanner.nextLine();

        Types type = audienceTypes.get(typeChoice - 1);
        Audience audience = new Audience(type, roomNumber);
        audiences.add(audience);
        System.out.println("Аудитория добавлена: " + audience);
    }

    private void addGroup() {
        Group group = new Group();
        groups.add(group);
        System.out.println("Новая группа добавлена. Сейчас в группе " + group.getStudents().size() + " студентов.");
    }

    private void addStudentToGroup() {
        if (groups.isEmpty()) {
            System.out.println("Нет доступных групп. Сначала добавьте группу.");
            return;
        }

        System.out.print("Введите имя студента: ");
        String studentName = scanner.nextLine();
        Student student = new Student(studentName);

        System.out.println("Выберите группу для добавления студента:");
        for (int i = 0; i < groups.size(); i++) {
            System.out.println((i + 1) + ". Группа " + (i + 1));
        }
        int groupChoice = scanner.nextInt();
        scanner.nextLine();

        Group group = groups.get(groupChoice - 1);
        group.addToGroup(student);
        System.out.println("Студент " + studentName + " добавлен в группу " + groupChoice);
    }

    private void addLesson() {
        if (groups.isEmpty() || audiences.isEmpty()) {
            System.out.println("Нет доступных групп или аудиторий. Добавьте их сначала.");
            return;
        }

        System.out.println("Введите дату занятия (ГГГГ-ММ-ДД): ");
        String dateString = scanner.nextLine();
        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println("Выберите тип занятия:");
        for (Types type : audienceTypes) {
            System.out.println(type.ordinal() + 1 + ". " + type);
        }
        int typeChoice = scanner.nextInt();
        scanner.nextLine();
        Types lessonType = audienceTypes.get(typeChoice - 1);

        System.out.println("Выберите слот времени:");
        for (TimeSlot slot : TimeSlot.values()) {
            System.out.println(slot.ordinal() + 1 + ". " + slot);
        }
        int slotChoice = scanner.nextInt();
        scanner.nextLine();
        TimeSlot timeSlot = TimeSlot.values()[slotChoice - 1];

        System.out.println("Выберите аудиторию:");
        for (int i = 0; i < audiences.size(); i++) {
            System.out.println((i + 1) + ". " + audiences.get(i));
        }
        int audienceChoice = scanner.nextInt();
        scanner.nextLine();
        Audience audience = audiences.get(audienceChoice - 1);

        System.out.println("Выберите группу:");
        for (int i = 0; i < groups.size(); i++) {
            System.out.println((i + 1) + ". Группа " + (i + 1));
        }
        int groupChoice = scanner.nextInt();
        scanner.nextLine();
        Group group = groups.get(groupChoice - 1);

        System.out.println("Выберите поток:");
        System.out.println("1. Гуманитарный поток");
        System.out.println("2. Математический поток");
        int flowChoice = scanner.nextInt();
        scanner.nextLine();
        Flow flow = (flowChoice == 1) ? new Humanitarian(FlowTypes.HUMANITARIAN) : new Mathematics(FlowTypes.MATH);

        Lesson lesson = new Lesson(lessonType, timeSlot, audience, group, flow, date);
        if (schedule.addLesson(lesson)) {
            System.out.println("Занятие успешно добавлено.");
        } else {
            System.out.println("Не удалось добавить занятие. Возможен конфликт.");
        }
    }

    private void showScheduleByAudience() {
        System.out.println("Выберите аудиторию для отображения расписания:");
        for (int i = 0; i < audiences.size(); i++) {
            System.out.println((i + 1) + ". " + audiences.get(i));
        }
        int audienceChoice = scanner.nextInt();
        scanner.nextLine();
        Audience audience = audiences.get(audienceChoice - 1);

        System.out.println("Выберите период для расписания: 1. Сегодня 2. Неделя");
        int periodChoice = scanner.nextInt();
        scanner.nextLine();

        if (periodChoice == 1) {
            LocalDate today = LocalDate.now();
            List<Lesson> dailySchedule = schedule.getScheduleByAudience(audience, today);
            System.out.println("Расписание на сегодня для " + audience + ":");
            dailySchedule.forEach(lesson -> System.out.println(lesson.getTimeSlot() + ": " + lesson.getTypes()));
        } else {
            LocalDate startOfWeek = LocalDate.now();
            List<Lesson> weeklySchedule = schedule.getWeeklyScheduleByAudience(audience, startOfWeek);
            System.out.println("Расписание на неделю для " + audience + ":");
            weeklySchedule.forEach(lesson -> System.out.println(lesson.getDate() + " " + lesson.getTimeSlot() + ": " + lesson.getTypes()));
        }
    }

    private void showScheduleByStudent() {
        System.out.print("Введите имя студента: ");
        String studentName = scanner.nextLine();

        Student student = null;
        for (Group group : groups) {
            for (Student s : group.getStudents()) {
                if (s.getName().equals(studentName)) {
                    student = s;
                    break;
                }
            }
        }

        if (student == null) {
            System.out.println("Студент не найден.");
            return;
        }

        System.out.println("Выберите период для расписания: 1. Сегодня 2. Неделя");
        int periodChoice = scanner.nextInt();
        scanner.nextLine();

        if (periodChoice == 1) {
            LocalDate today = LocalDate.now();
            List<Lesson> dailySchedule = schedule.getScheduleByStudent(student, today);
            System.out.println("Расписание на сегодня для студента " + studentName + ":");
            for (Lesson lesson : dailySchedule) {
                System.out.println(lesson.getTimeSlot() + ": " + lesson.getTypes() + " в " + lesson.getAudience());
            }
        } else if (periodChoice == 2) {
            LocalDate startOfWeek = LocalDate.now();
            List<Lesson> weeklySchedule = schedule.getWeeklyScheduleByStudent(student, startOfWeek);
            System.out.println("Расписание на неделю для студента " + studentName + ":");
            for (Lesson lesson : weeklySchedule) {
                System.out.println(lesson.getDate() + " " + lesson.getTimeSlot() + ": " + lesson.getTypes() + " в " + lesson.getAudience());
            }
        } else {
            System.out.println("Неверный выбор.");
        }
    }
}

*/
