package hus.oop.students;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 7) {
                    continue;
                }
                if (dataList.get(0).equals("id")) {
                    continue;
                }

                Student newStudent = new Student.StudentBuilder(dataList.get(0))
                        .withLastname(dataList.get(1))
                        .withFirstname(dataList.get(2))
                        .withYearOfBirth(Integer.parseInt(dataList.get(3)))
                        .withMathsGrade(Double.parseDouble(dataList.get(4)))
                        .withPhysicsGrade(Double.parseDouble(dataList.get(5)))
                        .withChemistryGrade(Double.parseDouble(dataList.get(6)))
                        .build();

                StudentManager.getInstance().append(newStudent);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataReader != null)
                    dataReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (String s : splitData) {
                result.add(s);
            }
        }
        return result;
    }

    public static void init() {
        String filePath = "C://Users//Admin//Downloads//OOPHKII2425_MidtermExam_De3//data//students.csv";
        readListData(filePath);
    }

    public static void testOriginalData() {
        List<Student> students = StudentManager.getInstance().sortStudentsByName();
        StudentManager.print(students);
    }

    public static void testSortStudentsByName() {
        List<Student> students = StudentManager.getInstance().sortStudentsByName();
        StudentManager.print(students);
    }

    public static void testSortAverageGradeIncreasing() {
        List<Student> students = StudentManager.getInstance().sortAverageGradeIncreasing();
        StudentManager.print(students);
    }

    public static void testSortAverageGradeDecreasing() {
        List<Student> students = StudentManager.getInstance().sortAverageGradeDecreasing();
        StudentManager.print(students);
    }

    public static void testFilterPassStudents() {
        List<Student> passStudents = StudentManager.getInstance().filterPassStudents();
        StudentManager.print(passStudents);
    }

    public static void testFilterFailureStudents() {
        List<Student> failureStudents = StudentManager.getInstance().filterFailureStudents(10);
        StudentManager.print(failureStudents);
    }

    public static void main(String[] args) {
        init();
        testOriginalData();
        testSortStudentsByName();
        testSortAverageGradeIncreasing();
        testSortAverageGradeDecreasing();
        testFilterPassStudents();
        testFilterFailureStudents();
    }
}
