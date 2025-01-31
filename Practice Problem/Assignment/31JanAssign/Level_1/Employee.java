import java.util.Scanner;

public class Employee {
    private int id;
    private int salary;
    private String name;

    public Employee(String name, int id, int salary){
        this.id = id;
        this.salary = salary;
        this.name = name;
    }

    public void displayDetails(){
        System.out.println("Employee Name: " +name);
        System.out.println("Employee ID: " +id);
        System.out.println("Employee Salary: " +salary);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Employee Details:");
        String name = sc.next();
        int id = sc.nextInt();
        int salary = sc.nextInt();

        Employee display = new Employee(name, id, salary);
        display.displayDetails();
    }

}
