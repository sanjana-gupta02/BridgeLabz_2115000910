import java.util.Scanner;

class Student {
    static String universityName = "GLA University";
    static int totalStudents;
    final int rollNumber;
    String name;
    double grade;

    Student(int rollNumber, String name, double grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }

    void displayStudentDetails() {
        if (this instanceof Student) {
            System.out.println("\nUniversity: " + universityName);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
        }
    }

    void updateGrade(double newGrade) {
        if (this instanceof Student) {
            grade = newGrade;
        }
    }

    static void displayTotalStudents() {
        System.out.println("\nTotal Students Enrolled: " + totalStudents);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            int rollNumber = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            double grade = sc.nextDouble();
            sc.nextLine();

            students[i] = new Student(rollNumber, name, grade);
        }

        displayTotalStudents();

        for (int i = 0; i < n; i++) {
            students[i].displayStudentDetails();
        }

        int updateIndex = sc.nextInt();
        if (updateIndex >= 0 && updateIndex < n) {
            double newGrade = sc.nextDouble();
            students[updateIndex].updateGrade(newGrade);
        }

        for (int i = 0; i < n; i++) {
            students[i].displayStudentDetails();
        }

    }
}
