class TaskNode {
    int taskId, priority;
    String taskName, dueDate;
    TaskNode next;

    TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    private TaskNode head;

    void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newTask = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            head.next = head;
        } else {
            TaskNode temp = head;
            while (temp.next != head) temp = temp.next;
            newTask.next = head;
            temp.next = newTask;
            head = newTask;
        }
    }

    void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newTask = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            head.next = head;
        } else {
            TaskNode temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = newTask;
            newTask.next = head;
        }
    }

    void removeTaskById(int taskId) {
        if (head == null) return;
        if (head.taskId == taskId && head.next == head) {
            head = null;
            return;
        }
        TaskNode temp = head, prev = null;
        do {
            if (temp.taskId == taskId) {
                if (prev != null) prev.next = temp.next;
                else {
                    TaskNode last = head;
                    while (last.next != head) last = last.next;
                    head = head.next;
                    last.next = head;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    TaskNode searchTaskByPriority(int priority) {
        if (head == null) return null;
        TaskNode temp = head;
        do {
            if (temp.priority == priority) return temp;
            temp = temp.next;
        } while (temp != head);
        return null;
    }

    void displayTasks() {
        if (head == null) return;
        TaskNode temp = head;
        do {
            System.out.println(temp.taskId + " " + temp.taskName + " " + temp.priority + " " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    void viewCurrentAndMoveNext() {
        if (head == null) return;
        System.out.println("Current Task: " + head.taskId + " " + head.taskName + " " + head.priority + " " + head.dueDate);
        head = head.next;
    }
}

public class TaskSchedulerSystem {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addTaskAtEnd(1, "Complete Project", 2, "12-02-2025");
        scheduler.addTaskAtEnd(2, "Review Code", 1, "13-02-2025");
        scheduler.addTaskAtBeginning(3, "Fix Bugs", 3, "11-02-2025");
        scheduler.displayTasks();
        scheduler.viewCurrentAndMoveNext();
        scheduler.removeTaskById(2);
        scheduler.displayTasks();
    }
}
