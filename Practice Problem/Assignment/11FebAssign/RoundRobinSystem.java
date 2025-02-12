class ProcessNode {
    int processId, burstTime, priority;
    ProcessNode next;

    ProcessNode(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private ProcessNode head;
    private int timeQuantum;

    RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    void addProcess(int processId, int burstTime, int priority) {
        ProcessNode newProcess = new ProcessNode(processId, burstTime, priority);
        if (head == null) {
            head = newProcess;
            head.next = head;
        } else {
            ProcessNode temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = newProcess;
            newProcess.next = head;
        }
    }

    void executeProcesses() {
        if (head == null) return;
        ProcessNode temp = head;
        do {
            if (temp.burstTime > 0) {
                int executionTime = Math.min(timeQuantum, temp.burstTime);
                System.out.println("Executing Process: " + temp.processId + " for " + executionTime + " units");
                temp.burstTime -= executionTime;
            }
            temp = temp.next;
        } while (temp != head);
        removeCompletedProcesses();
    }

    void removeCompletedProcesses() {
        if (head == null) return;
        ProcessNode temp = head, prev = null;
        do {
            if (temp.burstTime == 0) {
                if (prev != null) prev.next = temp.next;
                else {
                    ProcessNode last = head;
                    while (last.next != head) last = last.next;
                    head = head.next;
                    last.next = head;
                }
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    void displayProcesses() {
        if (head == null) return;
        ProcessNode temp = head;
        do {
            System.out.println("Process ID: " + temp.processId + " | Burst Time: " + temp.burstTime + " | Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
}

public class RoundRobinSystem {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(4);
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 3);
        scheduler.displayProcesses();
        scheduler.executeProcesses();
        scheduler.displayProcesses();
    }
}
