package src.main.Week3.project;

import java.util.ArrayList;
import java.util.List;

public class Group {
    List<Student> students = new ArrayList<>();

    public void addToGroup(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }
}
