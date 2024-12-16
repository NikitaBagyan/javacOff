package src.main.Week3.project.UI;

import src.main.Week3.project.Group;

import java.util.List;

public interface GroupManager {
    void addGroup();
    void addStudentToGroup(String studentName, int groupId);
    List<Group> getGroups();
}
