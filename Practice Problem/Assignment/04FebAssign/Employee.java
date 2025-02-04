import java.util.Scanner;

class Employee {
    static String companyName = "Tech Corp";
    static int totalEmployees;
    final int id;
    String name, designation;

    Employee(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        totalEmployees++;
    }

    void displayEmployeeDetails() {
        if (this instanceof Employee) {
            System.out.println("\nCompany: " + companyName);
            System.out.println("Employee ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Designation: " + designation);
        }
    }

    static void displayTotalEmployees() {
        System.out.println("\nTotal Employees: " + totalEmployees);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            String designation = sc.nextLine();

            employees[i] = new Employee(id, name, designation);
        }

        displayTotalEmployees();

        for (int i = 0; i < n; i++) {
            employees[i].displayEmployeeDetails();
        }
    }
}
