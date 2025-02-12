class StudentNode {
    int rollNumber, age;
    String name;
    char grade;
    StudentNode next;

    StudentNode(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList {
    private StudentNode head;

    void addStudentAtBeginning(int rollNumber, String name, int age, char grade) {
        StudentNode newStudent = new StudentNode(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    void addStudentAtEnd(int rollNumber, String name, int age, char grade) {
        StudentNode newStudent = new StudentNode(rollNumber, name, age, grade);
        if (head == null) head = newStudent;
        else {
            StudentNode temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newStudent;
        }
    }

    void addStudentAtPosition(int rollNumber, String name, int age, char grade, int position) {
        StudentNode newStudent = new StudentNode(rollNumber, name, age, grade);
        if (position == 1) {
            newStudent.next = head;
            head = newStudent;
            return;
        }
        StudentNode temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) temp = temp.next;
        if (temp == null) return;
        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    void deleteStudentByRollNumber(int rollNumber) {
        if (head == null) return;
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }
        StudentNode temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) temp = temp.next;
        if (temp.next == null) return;
        temp.next = temp.next.next;
    }

    StudentNode searchStudent(int rollNumber) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) return temp;
            temp = temp.next;
        }
        return null;
    }

    void updateGrade(int rollNumber, char newGrade) {
        StudentNode student = searchStudent(rollNumber);
        if (student != null) student.grade = newGrade;
    }

    void displayStudents() {
        StudentNode temp = head;
        while (temp != null) {
            System.out.println(temp.rollNumber + " " + temp.name + " " + temp.age + " " + temp.grade);
            temp = temp.next;
        }
    }
}

public class StudentRecordManager {
    public static void main(String[] args) {
        StudentLinkedList list = new StudentLinkedList();
        list.addStudentAtEnd(1, "Sanjana", 20, 'A');
        list.addStudentAtEnd(2, "Khushi", 21, 'B');
        list.addStudentAtBeginning(3, "Kislay", 22, 'C');
        list.addStudentAtPosition(4, "Aman", 23, 'D', 2);
        list.displayStudents();
        list.updateGrade(2, 'A');
        list.deleteStudentByRollNumber(3);
        list.displayStudents();
    }
}
