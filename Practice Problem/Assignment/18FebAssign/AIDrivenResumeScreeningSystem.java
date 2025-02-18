abstract class JobRole {
    public abstract String getRoleDescription();
}

class SoftwareEngineer extends JobRole {
    @Override
    public String getRoleDescription() {
        return "Software Engineer";
    }
}

class DataScientist extends JobRole {
    @Override
    public String getRoleDescription() {
        return "Data Scientist";
    }
}

class ProductManager extends JobRole {
    @Override
    public String getRoleDescription() {
        return "Product Manager";
    }
}

class Resume<T extends JobRole> {
    private String candidateName;
    private T jobRole;
    private String resumeDetails;

    public Resume(String candidateName, T jobRole, String resumeDetails) {
        this.candidateName = candidateName;
        this.jobRole = jobRole;
        this.resumeDetails = resumeDetails;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public T getJobRole() {
        return jobRole;
    }

    public String getResumeDetails() {
        return resumeDetails;
    }

    @Override
    public String toString() {
        return "Candidate: " + candidateName + ", Role: " + jobRole.getRoleDescription() + ", Details: " + resumeDetails;
    }
}

class ResumeScreeningSystem {
    public static <T extends JobRole> void processResume(Resume<T> resume) {
        System.out.println("Processing resume for " + resume.getCandidateName() + " applying for " + resume.getJobRole().getRoleDescription());
    }
}

class ScreeningUtils {
    public static void displayResumes(java.util.List<? extends Resume<? extends JobRole>> resumes) {
        for (Resume<? extends JobRole> resume : resumes) {
            System.out.println(resume);
        }
    }
}

public class AIDrivenResumeScreeningSystem {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> seResume = new Resume<>("Alice", new SoftwareEngineer(), "Expert in Java and C++");
        Resume<DataScientist> dsResume = new Resume<>("Bob", new DataScientist(), "Proficient in Python and R");
        Resume<ProductManager> pmResume = new Resume<>("Charlie", new ProductManager(), "Experienced in agile methodologies");

        java.util.List<Resume<? extends JobRole>> resumes = new java.util.ArrayList<>();
        resumes.add(seResume);
        resumes.add(dsResume);
        resumes.add(pmResume);

        ResumeScreeningSystem.processResume(seResume);
        ResumeScreeningSystem.processResume(dsResume);
        ResumeScreeningSystem.processResume(pmResume);

        System.out.println("\nDisplaying all resumes:");
        ScreeningUtils.displayResumes(resumes);
    }
}
