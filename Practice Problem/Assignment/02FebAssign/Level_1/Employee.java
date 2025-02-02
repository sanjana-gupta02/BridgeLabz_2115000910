public class Employee {
    public String employeeID;
    protected String department;
    private double salary;

    public Employee(String employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee {

    public Manager(String employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    public void displayManagerDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + getSalary());
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee("E123", "Sales", 50000.0);
        employee1.displayEmployeeDetails();

        Manager manager1 = new Manager("M456", "Marketing", 75000.0);
        manager1.displayManagerDetails();

        employee1.setSalary(55000.0);
        employee1.displayEmployeeDetails();
    }
}
