import java.io.*;
import java.util.*;

class Student {
    private int id;
    private String name;
    private int age;
    private int marks;

    public Student(int id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student { ID: " + id + ", Name: " + name + ", Age: " + age + ", Marks: " + marks + " }";
    }
}

public class CSVToStudentList {
    public static void main(String[] args) {
        String filePath = "students.csv";
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                int id = Integer.parseInt(columns[0].trim());
                String name = columns[1].trim();
                int age = Integer.parseInt(columns[2].trim());
                int marks = Integer.parseInt(columns[3].trim());
                students.add(new Student(id, name, age, marks));
            }

            students.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
