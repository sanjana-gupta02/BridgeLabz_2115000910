import java.util.*;

class University {
    String name;
    List<Department> departments = new ArrayList<>();
    List<Faculty> faculties = new ArrayList<>();

    University(String name) {
        this.name = name;
    }

    void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    void showDetails() {
        System.out.println("University: " + name);
        System.out.println("Departments:");
        for (Department dept : departments) {
            System.out.println("  - " + dept.name);
        }
        System.out.println("Faculties:");
        for (Faculty faculty : faculties) {
            System.out.println("  - " + faculty.name);
        }
    }
}

 class Department {
    String name;

    Department(String name) {
        this.name = name;
    }
}

class Faculty {
    String name;

    Faculty(String name) {
        this.name = name;
    }
}

public class UniversityFaculty {
    public static void main(String[] args) {
        University university = new University("GLA University");

        university.addDepartment("Computer Science");
        university.addDepartment("Mechanical Engineering");

        Faculty faculty1 = new Faculty("Mr. Satish");
        Faculty faculty2 = new Faculty("Mr. Gaurav");

        university.addFaculty(faculty1);
        university.addFaculty(faculty2);

        university.showDetails();
    }
}
