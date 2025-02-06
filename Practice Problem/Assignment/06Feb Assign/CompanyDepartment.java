import java.util.ArrayList;
import java.util.List;

class Company {
    String name;
    List<Depart> departments = new ArrayList<>();

    Company(String name) {
        this.name = name;
    }

    void addDepartment(String deptName) {
        departments.add(new Depart(deptName));
    }

    void showDepartments() {
        for (Depart dept : departments) {
            System.out.println("Department: " + dept.name);
            dept.showEmployees();
        }
    }
}

class Depart {
    String name;
    List<Employee> employees = new ArrayList<>();

    Depart(String name) {
        this.name = name;
    }

    void addEmployee(String empName) {
        employees.add(new Employee(empName));
    }

    void showEmployees() {
        for (Employee emp : employees) {
            System.out.println("  Employee: " + emp.name);
        }
    }
}

class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }
}

public class CompanyDepartment {
    public static void main(String[] args) {
        Company company = new Company("Capgemini");

        company.addDepartment("IT");
        company.addDepartment("HR");

        company.departments.get(0).addEmployee("Sanjana");
        company.departments.get(0).addEmployee("Khushi");


        System.out.println("Company Structure:");
        company.showDepartments();
    }
}