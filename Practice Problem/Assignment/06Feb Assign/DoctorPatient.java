import java.util.ArrayList;
import java.util.List;

class Doctor {
    String name;
    List<Patient> patients;

    Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    void addPatient(Patient patient) {
        patients.add(patient);
    }

    void consult(Patient patient) {
        System.out.println("Consultation between Dr. " + this.name + " and " + patient.name + ":");
        System.out.println(patient.name + " has come to see Dr. " + this.name + " for a consultation.");
    }
}

class Patient {
    String name;
    List<Doctor> doctors;

    Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    void consultWithDoctor(Doctor doctor) {
        doctor.consult(this);
    }
}

class Hospital {
    String name;
    List<Doctor> doctors;
    List<Patient> patients;

    Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    void addPatient(Patient patient) {
        patients.add(patient);
    }
}

public class DoctorPatient {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Hospital");

        Doctor doctor1 = new Doctor("Aman");
        Doctor doctor2 = new Doctor("Kislay");

        Patient patient1 = new Patient("Sanjana");
        Patient patient2 = new Patient("Khushi");

        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);
        hospital.addPatient(patient1);
        hospital.addPatient(patient2);

        patient1.addDoctor(doctor1);
        patient1.addDoctor(doctor2);
        patient2.addDoctor(doctor1);

        doctor1.addPatient(patient1);
        doctor1.addPatient(patient2);

        patient1.consultWithDoctor(doctor1);
        patient1.consultWithDoctor(doctor2);
        patient2.consultWithDoctor(doctor1);
    }
}
