import java.util.*;

class School {
    String name;
    List<Student> students = new ArrayList<>();

    School(String name) {
        this.name = name;
    }

    void addStudent(Student student) {
        students.add(student);
    }

    void showStudents() {
        for (Student student : students) {
            System.out.println("Student: " + student.name);
            student.showCourses();
        }
    }
}

class Student {
    String name;
    List<Course> courses = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    void enrollCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.addStudent(this);
        }
    }

    void showCourses() {
        System.out.println("  Enrolled Courses:");
        for (Course course : courses) {
            System.out.println("  - " + course.name);
        }
    }
}

class Course {
    String name;
    List<Student> students = new ArrayList<>();

    Course(String name) {
        this.name = name;
    }

    void addStudent(Student student) {
        if (!students.contains(student)) students.add(student);
    }

    void showStudents() {
        System.out.println("Course: " + name);
        for (Student student : students) {
            System.out.println("  Student: " + student.name);
        }
    }
}

public class SchoolStudent {
    public static void main(String[] args) {
        School school = new School("SSD School");

        Student student1 = new Student("Sanjana");
        Student student2 = new Student("Khushi");

        Course course1 = new Course("Math");
        Course course2 = new Course("Science");

        student1.enrollCourse(course1);
        student1.enrollCourse(course2);
        student2.enrollCourse(course1);

        school.addStudent(student1);
        school.addStudent(student2);

        System.out.println("School Students and Courses:");
        school.showStudents();

        System.out.println("\nCourses and Enrolled Students:");
        course1.showStudents();
        course2.showStudents();
    }
}
