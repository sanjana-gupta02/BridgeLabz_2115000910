import java.util.*;

// Interface defining medical record behavior
interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}

// Abstract class Patient
abstract class Patient {
    private final String patientId;
    private final String name;
    private final int age;
    private final List<String> medicalRecords = new ArrayList<>();

    Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    abstract double calculateBill();

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId + ", Name: " + name + ", Age: " + age);
    }
}

// InPatient subclass
class InPatient extends Patient implements MedicalRecord {
    private final double dailyCharge;
    private final int daysAdmitted;
    private final List<String> records = new ArrayList<>();

    InPatient(String patientId, String name, int age, double dailyCharge, int daysAdmitted) {
        super(patientId, name, age);
        this.dailyCharge = dailyCharge;
        this.daysAdmitted = daysAdmitted;
    }

    @Override
    double calculateBill() {
        return dailyCharge * daysAdmitted;
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
    }

    @Override
    public List<String> viewRecords() {
        return records;
    }
}

// OutPatient subclass
class OutPatient extends Patient implements MedicalRecord {
    private final double consultationFee;
    private final List<String> records = new ArrayList<>();

    OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    @Override
    double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
    }

    @Override
    public List<String> viewRecords() {
        return records;
    }
}

public class HospitalPatientManagement {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();

        InPatient inPatient = new InPatient("P001", "Sanjana Gupta", 45, 2000, 5);
        OutPatient outPatient = new OutPatient("P002", "Khushi Gupta", 30, 500);

        patients.add(inPatient);
        patients.add(outPatient);

        inPatient.addRecord("Treated for Fever.");
        outPatient.addRecord("Routine health check-up.");

        for (Patient patient : patients) {
            patient.getPatientDetails();
            System.out.println("Total Bill: " + patient.calculateBill());
            if (patient instanceof MedicalRecord) {
                System.out.println("Medical Records: " + ((MedicalRecord) patient).viewRecords());
            }
        }
    }
}
