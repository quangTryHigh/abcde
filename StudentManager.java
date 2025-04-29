package hus.oop.students;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private static StudentManager instance;
    private List<Student> studentList;

    private StudentManager() {
        studentList = new ArrayList<>();
    }

    public static StudentManager getInstance() {
        if (instance == null) {
            instance = new StudentManager();
        }
        return instance;
    }

    public void append(Student student) {
        studentList.add(student);
    }

    public void add(Student student, int index) {
        studentList.add(index, student);
    }

    public void remove(int index) {
        studentList.remove(index);
    }

    public Student studentAt(int index) {
        return studentList.get(index);
    }

    public int numberOfStudents() {
        return studentList.size();
    }

    public List<Student> sortStudentsByName() {
        studentList.sort((s1, s2) -> s1.compareTo(s2));
        return studentList;
    }

    public List<Student> sortAverageGradeIncreasing() {
        studentList.sort((s1, s2) -> Double.compare(s1.getAverageGrade(), s2.getAverageGrade()));
        return studentList;
    }

    public List<Student> sortAverageGradeDecreasing() {
        studentList.sort((s1, s2) -> Double.compare(s2.getAverageGrade(), s1.getAverageGrade()));
        return studentList;
    }

    public List<Student> filterPassStudents() {
        List<Student> passStudents = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getMathsGrade() > 4.0 && student.getPhysicsGrade() > 4.0 && student.getChemistryGrade() > 4.0 && student.getAverageGrade() > 5.0) {
                passStudents.add(student);
            }
        }
        return passStudents;
    }

    public List<Student> filterFailureStudents(int howMany) {
        List<Student> failureStudents = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getMathsGrade() < 4.0 || student.getPhysicsGrade() < 4.0 || student.getChemistryGrade() < 4.0 || student.getAverageGrade() < 5.0) {
                failureStudents.add(student);
            }
        }
        return failureStudents.size() <= howMany ? failureStudents : failureStudents.subList(0, howMany);
    }

    public static String idOfStudentsToString(List<Student> studentList) {
        StringBuilder idOfStudents = new StringBuilder();
        idOfStudents.append("[");
        for (Student student : studentList) {
            idOfStudents.append(student.getId()).append(" ");
        }
        return idOfStudents.toString().trim() + "]";
    }

    public static void print(List<Student> studentList) {
        StringBuilder studentsString = new StringBuilder();
        studentsString.append("[\n");
        for (Student student : studentList) {
            studentsString.append(student.toString()).append("\n");
        }
        System.out.print(studentsString.toString().trim() + "\n]");
    }
}
