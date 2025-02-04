import java.util.Scanner;

class Patient {
    static String hospitalName = "City General Hospital";
    static int totalPatients;
    final int patientID;
    String name, ailment;
    int age;

    Patient(int patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }

    void displayPatientDetails() {
        if (this instanceof Patient) {
            System.out.println("\nHospital: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
        }
    }

    static void getTotalPatients() {
        System.out.println("\nTotal Patients Admitted: " + totalPatients);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Patient[] patients = new Patient[n];

        for (int i = 0; i < n; i++) {
            int patientID = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            int age = sc.nextInt();
            sc.nextLine();
            String ailment = sc.nextLine();

            patients[i] = new Patient(patientID, name, age, ailment);
        }

        getTotalPatients();

        for (int i = 0; i < n; i++) {
            patients[i].displayPatientDetails();
        }

    }
}
