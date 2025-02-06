import java.util.ArrayList;
import java.util.List;

class Courses {
    String courseName;
    Professor professor;
    List<Students> enrolledStudents;

    Courses(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    void assignProfessor(Professor professor) {
        this.professor = professor;
    }

    void enrollStudent(Students student) {
        enrolledStudents.add(student);
    }

    void displayCourseDetails() {
        System.out.println("Course: " + courseName);
        if (professor != null) {
            System.out.println("Professor: " + professor.name);
        } else {
            System.out.println("Professor: Not assigned yet.");
        }
        System.out.println("Enrolled Students:");
        for (Students student : enrolledStudents) {
            System.out.println(student.name);
        }
    }
}

class Students {
    String name;
    List<Courses> courses;

    Students(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    void enrollCourse(Courses course) {
        courses.add(course);
        course.enrollStudent(this);
    }

    void displayStudentDetails() {
        System.out.println("Student: " + name);
        System.out.println("Courses enrolled:");
        for (Courses course : courses) {
            System.out.println(course.courseName);
        }
    }
}

class Professor {
    String name;
    List<Courses> courses;

    Professor(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    void assignCourse(Courses course) {
        courses.add(course);
        course.assignProfessor(this);
    }

    void displayProfessorDetails() {
        System.out.println("Professor: " + name);
        System.out.println("Courses taught:");
        for (Courses course : courses) {
            System.out.println(course.courseName);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Students student1 = new Students("Sanjana");
        Students student2 = new Students("Khushi");

        Professor professor1 = new Professor("Dr. Aman");
        Professor professor2 = new Professor("Dr. Kislay");

        Courses course1 = new Courses("Computer Science");
        Courses course2 = new Courses("Mathematics");

        professor1.assignCourse(course1);
        professor2.assignCourse(course2);

        student1.enrollCourse(course1);
        student2.enrollCourse(course1);
        student1.enrollCourse(course2);

        student1.displayStudentDetails();
        student2.displayStudentDetails();

        professor1.displayProfessorDetails();
        professor2.displayProfessorDetails();

        course1.displayCourseDetails();
        course2.displayCourseDetails();
    }
}
