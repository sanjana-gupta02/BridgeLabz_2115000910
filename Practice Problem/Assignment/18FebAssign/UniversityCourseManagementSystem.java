abstract class CourseType {
    public abstract String getEvaluationDetails();
}

class ExamCourse extends CourseType {
    private int examDuration;

    public ExamCourse(int examDuration) {
        this.examDuration = examDuration;
    }

    @Override
    public String getEvaluationDetails() {
        return "Exam Duration: " + examDuration + " minutes";
    }
}

class AssignmentCourse extends CourseType {
    private int numberOfAssignments;

    public AssignmentCourse(int numberOfAssignments) {
        this.numberOfAssignments = numberOfAssignments;
    }

    @Override
    public String getEvaluationDetails() {
        return "Number of Assignments: " + numberOfAssignments;
    }
}

class ResearchCourse extends CourseType {
    private String researchTopic;

    public ResearchCourse(String researchTopic) {
        this.researchTopic = researchTopic;
    }

    @Override
    public String getEvaluationDetails() {
        return "Research Topic: " + researchTopic;
    }
}

class Course<T extends CourseType> {
    private String courseName;
    private T evaluationType;

    public Course(String courseName, T evaluationType) {
        this.courseName = courseName;
        this.evaluationType = evaluationType;
    }

    public String getCourseName() {
        return courseName;
    }

    public T getEvaluationType() {
        return evaluationType;
    }

    @Override
    public String toString() {
        return "Course: " + courseName + " | " + evaluationType.getEvaluationDetails();
    }
}

class UniversityUtils {
    public static void displayCourses(java.util.List<? extends Course<? extends CourseType>> courses) {
        for (Course<? extends CourseType> course : courses) {
            System.out.println(course);
        }
    }
}

public class UniversityCourseManagementSystem {
    public static void main(String[] args) {
        java.util.List<Course<? extends CourseType>> examCourses = new java.util.ArrayList<>();
        java.util.List<Course<? extends CourseType>> assignmentCourses = new java.util.ArrayList<>();
        java.util.List<Course<? extends CourseType>> researchCourses = new java.util.ArrayList<>();

        examCourses.add(new Course<>( "Calculus", new ExamCourse(120) ));
        examCourses.add(new Course<>( "Physics", new ExamCourse(90) ));

        assignmentCourses.add(new Course<>( "Literature", new AssignmentCourse(5) ));
        assignmentCourses.add(new Course<>( "History", new AssignmentCourse(3) ));

        researchCourses.add(new Course<>( "Biology", new ResearchCourse("Genetics") ));
        researchCourses.add(new Course<>( "Computer Science", new ResearchCourse("Artificial Intelligence") ));

        System.out.println("Exam Courses:");
        UniversityUtils.displayCourses(examCourses);

        System.out.println("\nAssignment Courses:");
        UniversityUtils.displayCourses(assignmentCourses);

        System.out.println("\nResearch Courses:");
        UniversityUtils.displayCourses(researchCourses);
    }
}
