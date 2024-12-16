package src.main.Week3.project.UI;

import src.main.Week3.project.Group;
import src.main.Week3.project.Student;

import java.util.ArrayList;
import java.util.List;

public class GroupManagerImpl implements GroupManager {
    private final List<Group> groups = new ArrayList<>();

    @Override
    public void addGroup() {
        Group group = new Group();
        groups.add(group);
        System.out.println("Группа добавлена. Сейчас в группе " + group.getStudents().size() + " студентов.");
    }

    @Override
    public void addStudentToGroup(String studentName, int groupId) {
        if (groupId < 1 || groupId > groups.size()) {
            System.out.println("Неверный ID группы.");
            return;
        }
        Group group = groups.get(groupId - 1);
        group.addToGroup(new Student(studentName));
        System.out.println("Студент " + studentName + " добавлен в группу " + groupId);
    }

    @Override
    public List<Group> getGroups() {
        return groups;
    }
}
